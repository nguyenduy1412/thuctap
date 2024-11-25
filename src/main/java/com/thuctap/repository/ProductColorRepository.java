package com.thuctap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.thuctap.models.Brand;
import com.thuctap.models.Color;
import com.thuctap.models.ProductColor;
import com.thuctap.models.ProductSize;

import jakarta.transaction.Transactional;


public interface ProductColorRepository extends JpaRepository<ProductColor, Integer> {
	List<ProductColor> findByProductId(Integer id);
	@Transactional
	@Modifying
	@Query("delete from ProductColor i where i.product.id =?1 ")
	void deleteByProductId(Integer id);
	@Query("SELECT pc.color FROM ProductColor pc WHERE pc.product.id = :productId")
    List<Color> findColorsByProductId(@Param("productId") Integer productId);
}
