package com.thuctap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.thuctap.models.DetailCart;

import jakarta.transaction.Transactional;

public interface DetailCartRepository extends JpaRepository<DetailCart, Integer>{
	@Query("SELECT SUM(c.quantity) FROM DetailCart c WHERE c.cart.id = ?1")
	Integer sumQuantityByCartId(Integer cartId);
	DetailCart findByCartIdAndProductId(Integer cartId,Integer bookId);
	List<DetailCart> findByCartId(Integer id);
	@Transactional
	@Modifying
	@Query("delete from DetailCart i where i.cart.id =?1 ")
	void deleteByCartId(Integer id);
	List<DetailCart> findByCartIdOrderByIdDesc(Integer id);
}
