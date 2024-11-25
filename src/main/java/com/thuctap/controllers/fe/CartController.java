package com.thuctap.controllers.fe;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thuctap.models.Cart;
import com.thuctap.models.Color;
import com.thuctap.models.DetailCart;
import com.thuctap.models.DetailWishList;
import com.thuctap.models.Orders;
import com.thuctap.models.Product;
import com.thuctap.models.Size;
import com.thuctap.models.Users;
import com.thuctap.models.WishList;
import com.thuctap.service.CartService;
import com.thuctap.service.ColorService;
import com.thuctap.service.DetailCartService;
import com.thuctap.service.DetailWishListService;
import com.thuctap.service.OrderService;
import com.thuctap.service.ProductColorService;
import com.thuctap.service.ProductService;
import com.thuctap.service.ProductSizeService;
import com.thuctap.service.SizeService;
import com.thuctap.service.UserService;
import com.thuctap.service.WishListService;

import jakarta.servlet.http.HttpSession;
@Controller
public class CartController {
    
	@Autowired
	private CartService cartService;
	@Autowired
	private DetailCartService detailCartService;
	@Autowired
	private ProductService productService;
	@Autowired
	private ColorService colorService;
	@Autowired
	private SizeService sizeService;
	@Autowired
	private WishListService wishListService;
	@Autowired
	private DetailWishListService detailWishListService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userService;
	@GetMapping("/cart")
	public String showCart(HttpSession session, Model model) {
		Integer soluong = null;
		double total = 0;
		Users user = (Users) session.getAttribute("user");
		if (user == null) {
			return "redirect:/login";
		}
		Integer cartId = (Integer) session.getAttribute("cartId");
		System.out.println("CartId trong cart "+cartId);
		if (cartId != null) {
			List<DetailCart> listItem = this.detailCartService.findByCartIdOrderByIdDesc(cartId);
			session.setAttribute("listItem", listItem);
			soluong = this.detailCartService.sumQuantityByCartId(cartId);
			total = this.cartService.findById(cartId).totalPrice();
		}
		soluong = (soluong == null) ? 0 : soluong;
		session.setAttribute("total", total);
		session.setAttribute("soluong", soluong);
	
		return "fe/cart";
	}

	@PostMapping("/cart")
	public String addCart(@RequestParam("id") Integer idProduct, @RequestParam("quantity") Integer quantity,
			Principal principal, HttpSession session,@RequestParam("size_id") Integer sizeId,
			@RequestParam("color_id") Integer colorId) {
		Users user = (Users) session.getAttribute("user");
		if (user == null) {
			return "redirect:/login";
		}
		Color color=this.colorService.findById(colorId);
		Size size=this.sizeService.findById(sizeId);
		Cart cart = cartService.findByUserId(user.getId());
		if (cart == null) {
			cart = new Cart();
			cart.setUser(user);
			this.cartService.create(cart);
		}
		session.setAttribute("cartId", cart.getId());
		System.out.println("CartId post "+cart.getId());
		DetailCart detailCart = this.detailCartService.findByCartIdAndProductId(cart.getId(), idProduct);
		if (detailCart != null) {
			Integer soluong = detailCart.getQuantity() + quantity;
			detailCart.setQuantity(soluong);
		} else {
			detailCart = new DetailCart();
			detailCart.setCart(cart);
			detailCart.setProduct(this.productService.findById(idProduct));
			detailCart.setQuantity(quantity);
			detailCart.setColor(color.getColorName());
			detailCart.setSize(size.getSizeName());
		
		}
		this.detailCartService.createOrUpdate(detailCart);
		Integer soluong = this.detailCartService.sumQuantityByCartId(cart.getId());
		session.setAttribute("soluong", soluong);
		return "redirect:/cart";
	}

	@GetMapping("delete-cart-item/{id}")
	public String delete(Model model, @PathVariable("id") Integer id, HttpSession session) {
		if (this.detailCartService.delete(id)) {
			return "redirect:/cart";
		}
		return "redirect:/cart";
	}
	@GetMapping("/wish-list")
	public String showWishList(HttpSession session, Model model) {
		
		Users user = (Users) session.getAttribute("user");
		if (user == null) {
			return "redirect:/login";
		}
		WishList wl=this.wishListService.findByUserId(user.getId());
		if (wl != null) {
			List<DetailWishList> listItem = this.detailWishListService.findByFavouriteIdOrderByIdDesc(wl.getId());
			model.addAttribute("listItem", listItem);
		}
		return "fe/wishList";
	}
	@GetMapping("/add-wish/{id}")
	public String addWishList(@PathVariable("id") Integer id, Model model,HttpSession session) {
		Users user = (Users) session.getAttribute("user");
		if (user == null) {
			return "redirect:/login";
		}
		Product pd=this.productService.findById(id);
		WishList wl=this.wishListService.findByUserId(user.getId());
		DetailWishList dt=new DetailWishList();
		dt.setProduct(pd);
		dt.setWishList(wl);
		if(this.detailWishListService.createOrUpdate(dt)) {
			return "redirect:/wish-list";
		}
		return "redirect:/wish-list";
	}
	@GetMapping("/myaccount")
	public String myaccount(Model model,HttpSession session) {
		Users user = (Users) session.getAttribute("user");
		if (user == null) {
			return "redirect:/login";
		}
		List<Orders> listOrder=orderService.getByUserIdOrderByIdDesc(user.getId());
		model.addAttribute("listOrder", listOrder);
		return "fe/myaccount";
	}
}
