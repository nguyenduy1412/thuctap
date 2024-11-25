package com.thuctap.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.thuctap.models.Brand;
import com.thuctap.models.Category;
import com.thuctap.models.Color;
import com.thuctap.models.ProductSize;
import com.thuctap.models.Size;

public interface ProductSizeService {
	List<ProductSize> findAll();
	Boolean create(ProductSize a);
	Boolean delete(Integer id);
	ProductSize findById(Integer id);
	Boolean deleteByProductId(Integer id);
	List<Size> findSizesByProductId(Integer id);
}
