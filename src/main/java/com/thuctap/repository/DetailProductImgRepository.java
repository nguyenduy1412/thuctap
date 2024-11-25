package com.thuctap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.thuctap.models.DetailProductImg;

import jakarta.transaction.Transactional;

public interface DetailProductImgRepository extends JpaRepository<DetailProductImg, Integer>{
	@Transactional
	@Modifying
	@Query("delete from DetailProductImg i where i.product.id =?1 ")
	void deleteByProductId(Integer id);
}
