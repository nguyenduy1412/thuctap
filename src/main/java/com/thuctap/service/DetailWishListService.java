package com.thuctap.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.thuctap.models.DetailWishList;


public interface DetailWishListService {
	Boolean createOrUpdate(DetailWishList a);
	Boolean delete(Integer id);
	DetailWishList findById(Integer id);
	Page<DetailWishList> findByFavouriteId(Integer id,Integer page,Integer limit);
	List<DetailWishList> findByFavouriteIdOrderByIdDesc(Integer id);
	DetailWishList findByFavouriteIdAndProductId(Integer favouriteId, Integer productId);
}
