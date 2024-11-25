package com.thuctap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.thuctap.models.Brand;
import com.thuctap.models.Color;
import com.thuctap.models.ProductSize;
import com.thuctap.models.Size;

import jakarta.transaction.Transactional;


public interface ProductSizeRepository extends JpaRepository<ProductSize, Integer> {
	List<ProductSize> findByProductId(Integer id);
	@Transactional
	@Modifying
	@Query("delete from ProductSize i where i.product.id =?1 ")
	void deleteByProductId(Integer id);
	@Query("SELECT ps.size FROM ProductSize ps WHERE ps.product.id = :productId")
	List<Size> findSizesByProductId(@Param("productId") Integer productId);
}
