package com.thuctap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thuctap.models.Brand;


public interface BrandRepository extends JpaRepository<Brand, Integer> {
	List<Brand> findByBrandNameContainingIgnoreCaseOrderByBrandNameAsc(String keyword);
}
