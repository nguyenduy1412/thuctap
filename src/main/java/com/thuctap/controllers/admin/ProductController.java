package com.thuctap.controllers.admin;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.thuctap.method.FileName;
import com.thuctap.models.Brand;
import com.thuctap.models.Category;
import com.thuctap.models.Color;
import com.thuctap.models.DetailProductImg;
import com.thuctap.models.Product;
import com.thuctap.models.ProductColor;
import com.thuctap.models.ProductSize;
import com.thuctap.models.Size;
import com.thuctap.service.BrandService;
import com.thuctap.service.CategoryService;
import com.thuctap.service.ColorService;
import com.thuctap.service.DetailProductImgService;
import com.thuctap.service.ProductColorService;
import com.thuctap.service.ProductService;
import com.thuctap.service.ProductSizeService;
import com.thuctap.service.SizeService;
import com.thuctap.service.StorageService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/admin")
public class ProductController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	@Autowired
	private StorageService storageService;
	@Autowired
	private DetailProductImgService detailProductImgService;
	@Autowired
	private BrandService brandService;
	@Autowired
	private ColorService colorService;
	@Autowired
	private SizeService sizeService;
	@Autowired
	private ProductSizeService productSizeService;
	@Autowired
	private ProductColorService productColorService;

	@RequestMapping("/product")
	public String index(Model model, @Param("keyword") String keyword,
			@RequestParam(name = "page", defaultValue = "1") Integer page) {
		Page<Product> list = this.productService.getAll(page, 6);
		if (keyword != null) {
			list = this.productService.searchProduct(keyword, page, 6);
			model.addAttribute("keyword", keyword);
		}
		model.addAttribute("totalPage", list.getTotalPages());
		model.addAttribute("currentPage", page);
		model.addAttribute("list", list);
		return "admin/product/index";
	}

	@GetMapping("/product/add")
	public String add(Model model) {
		Product product = new Product();
		product.setStatus(true);
		List<Category> listCate = this.categoryService.findAll();
		List<Brand> listBrand = this.brandService.findAll();
		List<Size> listSize = this.sizeService.findAll();
		List<Color> listColor = this.colorService.findAll();
		model.addAttribute("product", product);
		model.addAttribute("listCate", listCate);
		model.addAttribute("listBrand", listBrand);
		model.addAttribute("listSize", listSize);
		model.addAttribute("listColor", listColor);
		return "admin/product/add";
	}

	@PostMapping("/product/add")
	public String save(Model model, @ModelAttribute("product") Product product,
			@RequestParam("fileImage") MultipartFile file, @RequestParam("fileImages") MultipartFile[] files,
			@RequestParam(value = "selectedSizes", required = false) List<Integer> selectedSizes,
			@RequestParam(value = "selectedColors", required = false) List<Integer> selectedColors) {

		

//		 //đặt tên file bằng ngày giờ hiện tại để không bị ghi đè file
		String fileName = file.getOriginalFilename()+ FileName.getFileNameToDateNow();
		this.storageService.store(file, fileName);
		product.setImage(fileName);
		// giá nhập / 1,lai

		Double price = product.getPriceEnter() * ((double) product.getProfit() / 100 + 1);
		Double priceSale = price * (1 - (double) product.getSale() / 100);
		price = Math.round(price * 100.0) / 100.0;
		priceSale = Math.round(priceSale * 100.0) / 100.0;
		product.setPrice(price);
		product.setPriceSale(priceSale);
		product.setStar(0.0);
		String fileName1 = files[0].getOriginalFilename();
		Boolean isEmpty1 = fileName1 == null || fileName1.trim().length() == 0;

		if (this.productService.create(product)) {

			if (!isEmpty1) {
				for (MultipartFile multipartFile : files) {
					DetailProductImg detailProductImg = new DetailProductImg();
					String fileNames = multipartFile.getOriginalFilename()+FileName.getFileNameToDateNow();
					detailProductImg.setImage(fileNames);
					detailProductImg.setProduct(product);
					this.storageService.store(multipartFile, fileNames);
					this.detailProductImgService.create(detailProductImg);
				}
			}
			for (Integer c : selectedColors) {
				ProductColor pc = new ProductColor();
				Color color = colorService.findById(c);
				System.out.println(color);
				pc.setColor(color);
				pc.setProduct(product);
				System.out.println(pc);
				if (this.productColorService.create(pc)) {

				} else {
					return "admin/product/add";
				}
			}
			for (Integer s : selectedSizes) {
				ProductSize ps = new ProductSize();
				Size size = sizeService.findById(s);
				ps.setSize(size);
				ps.setProduct(product);
				System.out.println(ps);
				if (this.productSizeService.create(ps)) {
				} else {
					System.out.println("eRRORR");
					return "admin/product/add";
				}
			}
			return "redirect:/admin/product";
		}
		return "admin/product/add";

	}

	@GetMapping("/product/edit/{id}")
	public String edit(Model model, @PathVariable("id") Integer id) {
		Product product = this.productService.findById(id);
		model.addAttribute("product", product);
		System.out.println(product);
		Set<ProductColor> listColorCheck=product.getProductColors();
		Set<ProductSize> listSizeCheck=product.getProductSizes();
		List<Integer> listColorSelected = new ArrayList<Integer>();
		for (ProductColor i : listColorCheck) {
			listColorSelected.add(i.getColor().getId());
		}
		List<Integer> listSizeSelected = new ArrayList<Integer>();
		for (ProductSize i : listSizeCheck) {
			listSizeSelected.add(i.getSize().getId());
		}
		
		List<Category> listCate = categoryService.findAll();
		model.addAttribute("listCate", listCate);
		List<Brand> listBrand = this.brandService.findAll();
		List<Size> listSize = this.sizeService.findAll();
		List<Color> listColor = this.colorService.findAll();
		model.addAttribute("product", product);
		model.addAttribute("listCate", listCate);
		model.addAttribute("listBrand", listBrand);
		model.addAttribute("listSize", listSize);
		model.addAttribute("listColor", listColor);
		model.addAttribute("listColorSelected", listColorSelected);
		model.addAttribute("listSizeSelected", listSizeSelected);
		return "admin/product/edit";
	}

	@PostMapping("/product/edit")
	public String update(Model model, @ModelAttribute("product") Product product,
		@RequestParam("fileImage") MultipartFile file
		,@RequestParam("listChoose")String listChoose,@RequestParam("fileImages") MultipartFile[] files,
		@RequestParam(value = "selectedSizes", required = false) List<Integer> selectedSizes,
		@RequestParam(value = "selectedColors", required = false) List<Integer> selectedColors) {
		
		
		String fileName = file.getOriginalFilename();
		boolean isEmpty = fileName == null || fileName.trim().length() == 0;
		if (!isEmpty) {
			fileName=file.getOriginalFilename()+ FileName.getFileNameToDateNow();
			this.storageService.store(file,fileName);
			product.setImage(fileName);
		}
		if(!listChoose.isEmpty())
		{
			String[] arrayChoose=listChoose.split(" ");
			for (String i : arrayChoose) {
				this.detailProductImgService.delete(Integer.parseInt(i));
			}
		}
		
		String fileName1=files[0].getOriginalFilename();
		Boolean isEmpty1=fileName1==null || fileName1.trim().length()==0;
		
		
		Double price = product.getPriceEnter() * ((double) product.getProfit() / 100 + 1);
		Double priceSale = price * (1 - (double) product.getSale() / 100);
		price = Math.round(price * 100.0) / 100.0;
		priceSale = Math.round(priceSale * 100.0) / 100.0;
		product.setPrice(price);
		product.setPriceSale(priceSale);
		if (this.productService.update(product)) {
			if(!isEmpty1) {
				for (MultipartFile multipartFile : files) {
					DetailProductImg detailProductImg=new DetailProductImg();
					String fileNames = multipartFile.getOriginalFilename()+FileName.getFileNameToDateNow();
					detailProductImg.setImage(fileNames);
					detailProductImg.setProduct(product);
					this.storageService.store(multipartFile,fileNames);
					this.detailProductImgService.create(detailProductImg);
				}
			}
			if(this.productColorService.deleteByProductId(product.getId())){
				for (Integer c : selectedColors) {
					ProductColor pc = new ProductColor();
					Color color = colorService.findById(c);
					System.out.println(color);
					pc.setColor(color);
					pc.setProduct(product);
					System.out.println(pc);
					if (this.productColorService.create(pc)) {

					} else {
						return "admin/product/edit";
					}
				}
			}
			if(this.productSizeService.deleteByProductId(product.getId())){
				for (Integer s : selectedSizes) {
					ProductSize ps = new ProductSize();
					Size size = sizeService.findById(s);
					ps.setSize(size);
					ps.setProduct(product);
					System.out.println(ps);
					if (this.productSizeService.create(ps)) {
						
					} else {
						System.out.println("eRRORR");
						return "admin/product/edit";
					}
				}
			}
			return "redirect:/admin/product";
		}
		return "admin/product/edit";

	}

	@GetMapping("/product/delete/{id}")
	public String delete(Model model, @PathVariable("id") Integer id) {
		this.detailProductImgService.deleteByProductId(id);
		this.productColorService.deleteByProductId(id);
		this.productSizeService.deleteByProductId(id);
		if (this.productService.delete(id)) {
			return "redirect:/admin/product";
		}
		return "redirect:/admin/product";
	}

}
