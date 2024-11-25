package com.thuctap.service;

import com.thuctap.models.Cart;

public interface CartService {
	Boolean create(Cart a);
	Boolean checkCart(Long id);
	Cart findByUserId(Long id);
	Cart findById(Integer id);
}
