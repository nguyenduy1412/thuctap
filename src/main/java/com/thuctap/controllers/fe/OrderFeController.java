package com.thuctap.controllers.fe;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thuctap.models.AddressOrder;
import com.thuctap.models.Cart;
import com.thuctap.models.Color;
import com.thuctap.models.DetailCart;
import com.thuctap.models.OrderDetail;
import com.thuctap.models.Orders;
import com.thuctap.models.Product;
import com.thuctap.models.Review;
import com.thuctap.models.Size;
import com.thuctap.models.Users;
import com.thuctap.service.AddressOrderService;
import com.thuctap.service.CartService;
import com.thuctap.service.DetailCartService;
import com.thuctap.service.OrderDetailService;
import com.thuctap.service.OrderService;
import com.thuctap.service.ProductColorService;
import com.thuctap.service.ProductService;
import com.thuctap.service.ProductSizeService;

import jakarta.servlet.http.HttpSession;

@Controller
public class OrderFeController {
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductColorService productColorService;
	@Autowired
	private ProductSizeService productSizeService;
	@Autowired
	private AddressOrderService addressOrderService;
	@Autowired
	private DetailCartService detailCartService;
	@Autowired
	private CartService cartService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderDetailService orderDetailService;
	@GetMapping("/checkout")
	public String detail(Model model,HttpSession session) {
		System.out.println("1");
		Users user = (Users) session.getAttribute("user");
		if (user == null) {
			return "redirect:/login";
		}
		AddressOrder addressOrder=this.addressOrderService.finByUsers(user);
		Integer cartId = (Integer) session.getAttribute("cartId");
		System.out.println("CartId trong cart "+cartId);
		Double total=0.0;
		List<DetailCart> listItem=new ArrayList<DetailCart>();
		if (cartId != null) {
			listItem = this.detailCartService.findByCartIdOrderByIdDesc(cartId);
			session.setAttribute("listItem", listItem);
			
			total = this.cartService.findById(cartId).totalPrice();
		}
		model.addAttribute("total", total);
		model.addAttribute("list", listItem);
		model.addAttribute("addressOrder", addressOrder);
		return "fe/checkout";
	}
	@PostMapping("/checkout")
	public String postCheckout(HttpSession session, @ModelAttribute("addressOrder") AddressOrder addressOrder,
			@RequestParam("note") String note,Model model) {
		Users user = (Users) session.getAttribute("user");
		
		if (user == null) {
			return "redirect:/login";
		}
		System.out.println("---------------------->");
		System.out.println("note "+note);
		Orders orders=new Orders();
		
		
		Cart cart = cartService.findByUserId(user.getId());
		
		
		orders.setUser(user);
		orders.setDateOrder(new Date());
		orders.setStatus(0);
		orders.setStatusPay(false);
		orders.setNote(note);
		orders.setSumMoney(cart.totalPrice());
		if (this.orderService.create(orders)) {
			// thêm tất cả các sản phẩm trong giỏ hàng vào order detail và thêm các review vào orderdetail
			for (DetailCart a : cart.getDetailCarts()) {
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setOrders(orders);
				orderDetail.setPrice(a.getProduct().getPriceSale());
				orderDetail.setQuantity(a.getQuantity());
				orderDetail.setProduct(a.getProduct());
				orderDetail.setColor(a.getColor());
				orderDetail.setSize(a.getSize());
//				Review review=new Review();
//				review.setStatus(false);
//				this.reviewService.create(review);
//				orderDetail.setReview(review);
				this.orderDetailService.create(orderDetail);
			}
			// xóa tất cả sản phẩm trong giỏ hàng
			this.detailCartService.deleteByCartId(cart.getId());
		}
		addressOrder.setUsers(user);
		addressOrder.setOrders(orders);
		if(this.addressOrderService.create(addressOrder)) {
			return "redirect:/";
		}	
	return "fe/checkout";
	}
}
