package com.thuctap.service;

import com.thuctap.models.WishList;

public interface WishListService {
	Boolean create(WishList a);
	Boolean checkWishList(Long id);
	WishList findByUserId(Long id);
	WishList findById(Integer id);
}
