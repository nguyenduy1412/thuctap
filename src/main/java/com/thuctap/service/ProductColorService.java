package com.thuctap.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.thuctap.models.Brand;
import com.thuctap.models.Category;
import com.thuctap.models.Color;
import com.thuctap.models.ProductColor;
import com.thuctap.models.ProductSize;

public interface ProductColorService {
	List<ProductColor> findAll();
	Boolean create(ProductColor a);
	Boolean delete(Integer id);
	ProductColor findById(Integer id);
	Boolean deleteByProductId(Integer id);
	List<Color> findColorsByProductId(Integer id);
}
