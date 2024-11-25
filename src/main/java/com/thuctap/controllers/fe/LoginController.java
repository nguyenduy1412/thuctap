package com.thuctap.controllers.fe;

import java.security.Principal;
import java.util.List;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thuctap.models.Cart;
import com.thuctap.models.Color;
import com.thuctap.models.DetailCart;
import com.thuctap.models.Orders;
import com.thuctap.models.Product;
import com.thuctap.models.Size;
import com.thuctap.models.Users;
import com.thuctap.models.WishList;
import com.thuctap.service.CartService;
import com.thuctap.service.DetailCartService;
import com.thuctap.service.ProductColorService;
import com.thuctap.service.ProductService;
import com.thuctap.service.ProductSizeService;
import com.thuctap.service.UserService;
import com.thuctap.service.WishListService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
@Controller
public class LoginController {
    
	@Autowired
	private CartService cartService;
	@Autowired
	private DetailCartService detailCartService;
	@Autowired
	private ProductService productService;
	@Autowired
	private UserService userService;
	@Autowired
	private WishListService wishListService;
	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error, Model model, HttpServletRequest request) {
		if (error != null) {
            HttpSession session = request.getSession(false);
            String errorMessage = "";
            if (session != null) {
                AuthenticationException ex = (AuthenticationException) session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
                if (ex instanceof InternalAuthenticationServiceException) {
                    Throwable cause = ex.getCause();
                    if (cause instanceof DisabledException) {
                    	errorMessage= "Tài khoản của bạn đã bị vô hiệu hóa.";
                    } else {
                    	errorMessage= "Lỗi.";
                    }
                } else if (ex instanceof BadCredentialsException) {
                		errorMessage= "Sai tên đăng nhập hoặc mật khẩu.";
                } else {
                	errorMessage= "Lỗi.";
                }
            }
            
            model.addAttribute("error", errorMessage);
        }
		return "fe/login";
	}
	@GetMapping("/register")
	public String register(HttpSession session, Model model) {
		Users user=new Users();
		model.addAttribute("user", user);
		return "fe/register";
	}
	@PostMapping("/register")
	public String doRegister(@Valid @ModelAttribute("user") Users user,BindingResult bindingResult,Model model) {
		if (bindingResult.hasErrors()) {
            System.out.println("ERRORR");
            return "fe/register";
        }
		String error="";
		System.out.println("giá trị "+ bindingResult.hasErrors());
		Users check=userService.findByUserName(user.getUserName());
		if(check!=null) {
			error="Tên tài khoản bị trùng";
			model.addAttribute("error", error);
			return "fe/register";
		}
		String pass=new BCryptPasswordEncoder().encode(user.getPassWord());
		user.setPassWord(pass);
		user.setEnabled(true);
		if(this.userService.update(user)!=null) {
			Cart cart=new Cart();
			cart.setUser(user);
			cart.setTotal(0.0);
			WishList wl=new WishList();
			wl.setUser(user);
			
			if(this.cartService.create(cart) && this.wishListService.create(wl)) {
				return "fe/login";
			}
		}
		return "fe/register";
	}
	
	
}
