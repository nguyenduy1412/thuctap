package com.thuctap.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.thuctap.models.WishList;




public interface WishListRepository extends JpaRepository<WishList, Integer> {
	WishList findByUserId(Long id);
	long countByUserId(Long id);
}
