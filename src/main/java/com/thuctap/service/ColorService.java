package com.thuctap.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.thuctap.models.Brand;
import com.thuctap.models.Category;
import com.thuctap.models.Color;
import com.thuctap.models.Size;

public interface ColorService {
	List<Color> findAll();
	Boolean create(Color a);
	Boolean delete(Integer id);
	Color findById(Integer id);
	
	
}
