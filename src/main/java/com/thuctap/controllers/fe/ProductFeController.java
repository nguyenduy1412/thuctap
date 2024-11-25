package com.thuctap.controllers.fe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thuctap.models.Color;
import com.thuctap.models.Product;
import com.thuctap.models.Size;
import com.thuctap.service.ProductColorService;
import com.thuctap.service.ProductService;
import com.thuctap.service.ProductSizeService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProductFeController {
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductColorService productColorService;
	@Autowired
	private ProductSizeService productSizeService;
	@RequestMapping("/product-detail/{id}")
	public String detail(Model model,HttpSession session, @PathVariable("id") Integer id) {
		List<Color> listColor=this.productColorService.findColorsByProductId(id);
		List<Size> listSize=this.productSizeService.findSizesByProductId(id);
		Product product=this.productService.findById(id);
		model.addAttribute("product",product);
		model.addAttribute("color", listColor);
		model.addAttribute("size", listSize);
		return "fe/product-detail";
	}
}
