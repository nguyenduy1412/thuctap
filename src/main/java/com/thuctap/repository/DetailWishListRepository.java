package com.thuctap.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.thuctap.models.DetailWishList;



public interface DetailWishListRepository extends JpaRepository<DetailWishList, Integer> {
	List<DetailWishList> findByWishListId(Integer id);
	List<DetailWishList> findByWishListIdOrderByIdDesc(Integer id);
	DetailWishList findByWishListIdAndProductId(Integer wishListId, Integer productId);
}
