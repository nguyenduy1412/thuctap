package com.thuctap.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.thuctap.models.Brand;
import com.thuctap.models.Category;

public interface BrandService {
	List<Brand> findAll();
	Boolean create(Brand a);
	Boolean delete(Integer id);
	Brand findById(Integer id);
	Page<Brand> getAll(Integer page,Integer limit);
	Page<Brand> searchBrand(String keyword, Integer page,Integer limit);
	List<Brand> searchBrand(String keyword);
	
}
