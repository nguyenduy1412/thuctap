package com.thuctap.controllers.admin;

import java.util.List;

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

import com.thuctap.models.Brand;
import com.thuctap.models.Category;
import com.thuctap.models.Users;
import com.thuctap.service.BrandService;
import com.thuctap.service.CategoryService;
import com.thuctap.service.UserService;

@Controller
@RequestMapping("/admin")
public class BrandController {
	@Autowired
	private BrandService brandService;
	@GetMapping("/brand")
    public String index(Model model,@Param("keyword") String keyword,
    		@RequestParam(name="page",defaultValue = "1") Integer page) {
		Page<Brand> list=this.brandService.getAll(page,5);
		if(keyword !=null) {
			list=this.brandService.searchBrand(keyword, page, 5);
			model.addAttribute("keyword",keyword);
		}
		model.addAttribute("totalPage", list.getTotalPages());
		model.addAttribute("currentPage",page);
		model.addAttribute("list",list);		
        return "admin/brand/index";
    }
	@GetMapping("/brand/add")
    public String add(Model model) {
    	Brand brand=new Brand();
    	brand.setStatus(true);
    	model.addAttribute("brand", brand);
    	return "admin/brand/add";
    }
    @PostMapping("/brand/add")
    public String save(Model model,@ModelAttribute("brand") Brand brand) {
    	
    	if(this.brandService.create(brand)) {
    		return "redirect:/admin/brand";
    	}
    	else {
    		return "admin/brand/add";
    	}
    }
    @GetMapping("brand/edit/{id}")
    public String edit(Model model,@PathVariable("id") Integer id) {
    	Brand brand =this.brandService.findById(id);
    	model.addAttribute("brand",brand);
    	return "admin/brand/edit";
    }
    @PostMapping("brand/edit")
    public String update(@ModelAttribute("brand") Brand brand) {
    	
    	if(this.brandService.create(brand)) {
    		return "redirect:/admin/brand";
    	}
    	return "admin/brand/edit";
    }
    @GetMapping("brand/delete/{id}")
    public String delete(Model model,@PathVariable("id") Integer id) {
    	if(this.brandService.delete(id)) {
    		return "redirect:/admin/brand";
    	}
    	return "redirect:/admin/brand";
    }
}
