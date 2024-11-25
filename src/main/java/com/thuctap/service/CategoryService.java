package com.thuctap.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.thuctap.models.Category;

public interface CategoryService {
	List<Category> findAll();
	Boolean create(Category a);
	Boolean delete(Integer id);
	Category findById(Integer id);
	Page<Category> getAll(Integer page,Integer limit);
	Page<Category> searchCategory(String keyword, Integer page,Integer limit);
	List<Category> searchCategory(String keyword);
	
}
