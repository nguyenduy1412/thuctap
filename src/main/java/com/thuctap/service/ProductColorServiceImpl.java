package com.thuctap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.thuctap.models.Brand;
import com.thuctap.models.Category;
import com.thuctap.models.Color;
import com.thuctap.models.ProductColor;
import com.thuctap.models.ProductSize;
import com.thuctap.repository.BrandRepository;
import com.thuctap.repository.ProductColorRepository;
import com.thuctap.repository.ProductSizeRepository;

@Service
public class ProductColorServiceImpl implements ProductColorService{
	@Autowired
	private ProductColorRepository productColorRepository;
	@Override
	public List<ProductColor> findAll() {
		// TODO Auto-generated method stub
		return this.productColorRepository.findAll();
	}

	@Override
	public Boolean create(ProductColor a) {
		try {
			this.productColorRepository.save(a);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean delete(Integer id) {
		try {
			this.productColorRepository.delete(findById(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return false;
	}

	@Override
	public ProductColor findById(Integer id) {
		// TODO Auto-generated method stub
		return this.productColorRepository.findById(id).get();
	}

	@Override
	public Boolean deleteByProductId(Integer id) {
		// TODO Auto-generated method stub
		try{
			this.productColorRepository.deleteByProductId(id);
			return true;
		}catch (Exception e) {
			e.printStackTrace();	
		}
		return false;
	}

	@Override
	public List<Color> findColorsByProductId(Integer id) {
		// TODO Auto-generated method stub
		return this.productColorRepository.findColorsByProductId(id);
	}
	
}
