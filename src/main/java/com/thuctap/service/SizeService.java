package com.thuctap.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.thuctap.models.Brand;
import com.thuctap.models.Category;
import com.thuctap.models.Size;

public interface SizeService {
	List<Size> findAll();
	Boolean create(Size a);
	Boolean delete(Integer id);
	Size findById(Integer id);
	
	
}
