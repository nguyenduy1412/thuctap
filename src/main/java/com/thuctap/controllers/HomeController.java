package com.thuctap.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thuctap.models.Cart;
import com.thuctap.models.Category;
import com.thuctap.models.CustomUserDetails;
import com.thuctap.models.DetailCart;
import com.thuctap.models.Product;
import com.thuctap.models.Users;
import com.thuctap.service.CartService;
import com.thuctap.service.CategoryService;
import com.thuctap.service.DetailCartService;
import com.thuctap.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	@Autowired
	private DetailCartService detailCartService;
	@Autowired
	private CartService cartService;
	@RequestMapping("/")
	public String index(Model model,HttpServletRequest request,Principal principal,HttpSession session) {
		List<Category> listCate=this.categoryService.findAll();
		List<Product> listNewLaptop=this.productService.findProductNew(8);
		
		List<Product> listNewSmartphones=this.productService.findProductNew(9);
		model.addAttribute("listCate", listCate);
		model.addAttribute("listNewLaptop",listNewLaptop);
		model.addAttribute("listNewSmartphones",listNewSmartphones);
		Double total=null;
		Integer soluong=null;
		
		try {
			Users user=(Users) session.getAttribute("user");
			if(user==null) {
				CustomUserDetails userCus = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				user=userCus.getUser();
			}
			session.setAttribute("user", user);
			Cart cart=cartService.findByUserId(user.getId());
			// nếu có cart thì lấy số lượng và total + listItem bắn sang index
			if(cart!=null) {
				soluong= this.detailCartService.sumQuantityByCartId(cart.getId()) ;
				total=cart.totalPrice();
				List<DetailCart> listItem=this.detailCartService.findByCartIdOrderByIdDesc(cart.getId());	
				session.setAttribute("listItem", listItem);
				session.setAttribute("cartId", cart.getId());
			}
		} catch (Exception e) {
			
		}
		soluong= (soluong==null)? 0 : soluong;
		session.setAttribute("soluong", soluong);
		session.setAttribute("total", total);
		
	
		return "fe/index";
	}
}
