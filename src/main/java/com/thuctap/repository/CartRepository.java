package com.thuctap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thuctap.models.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{
	long countByUserId(Long id);
	Cart findByUserId(Long id);
}
