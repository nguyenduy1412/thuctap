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
import com.thuctap.models.ProductSize;
import com.thuctap.models.Size;
import com.thuctap.repository.BrandRepository;
import com.thuctap.repository.ProductSizeRepository;

@Service
public class ProductSizeServiceImpl implements ProductSizeService{
	@Autowired
	private ProductSizeRepository productSizeRepository;
	@Override
	public List<ProductSize> findAll() {
		// TODO Auto-generated method stub
		return this.productSizeRepository.findAll();
	}

	@Override
	public Boolean create(ProductSize a) {
		try {
			this.productSizeRepository.save(a);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean delete(Integer id) {
		try {
			this.productSizeRepository.delete(findById(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return false;
	}

	@Override
	public ProductSize findById(Integer id) {
		// TODO Auto-generated method stub
		return this.productSizeRepository.findById(id).get();
	}
	@Override
	public Boolean deleteByProductId(Integer id) {
		// TODO Auto-generated method stub
		try{
			this.productSizeRepository.deleteByProductId(id);
			return true;
		}catch (Exception e) {
			e.printStackTrace();	
		}
		return false;
	}

	@Override
	public List<Size> findSizesByProductId(Integer id) {
		// TODO Auto-generated method stub
		return this.productSizeRepository.findSizesByProductId(id);
	}
	
	
}
