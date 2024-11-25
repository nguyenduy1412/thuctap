package com.thuctap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thuctap.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
	List<Category> findByCategoryNameContainingIgnoreCaseOrderByCategoryNameAsc(String keyword);
}
