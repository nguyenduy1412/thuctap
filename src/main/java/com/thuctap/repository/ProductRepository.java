package com.thuctap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.thuctap.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	List<Product> findByProductNameContainingIgnoreCaseOrderByProductNameAsc(String keyword);
	List<Product> findAllByOrderByProductNameAsc();
	List<Product> findByCategoryIdOrderByIdDesc(Integer id);
	@Query("SELECT c FROM Product c WHERE c.sale > 0")
	List<Product> findProductSale();
	

    List<Product> findTop6ByCategoryIdOrderByIdDesc(Integer id);
}
