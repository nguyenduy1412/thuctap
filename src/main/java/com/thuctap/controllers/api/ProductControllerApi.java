package com.thuctap.controllers.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thuctap.models.Product;
import com.thuctap.service.ProductService;


@RestController
@RequestMapping("/api/product")
public class ProductControllerApi {
	@Autowired
	private ProductService productService;
	@GetMapping
	public List<Product> getAll( ) {
		return this.productService.findAllByOrderByProductNameAsc();
	}
}
