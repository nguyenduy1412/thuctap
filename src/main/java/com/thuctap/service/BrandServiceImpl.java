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
import com.thuctap.repository.BrandRepository;

@Service
public class BrandServiceImpl implements BrandService{
	@Autowired
	private BrandRepository brandRepository;
	@Override
	public List<Brand> findAll() {
		// TODO Auto-generated method stub
		return this.brandRepository.findAll(Sort.by(Sort.Direction.ASC, "brandName"));
	}

	@Override
	public Boolean create(Brand a) {
		try {
			this.brandRepository.save(a);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean delete(Integer id) {
		try {
			this.brandRepository.delete(findById(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return false;
	}

	@Override
	public Brand findById(Integer id) {
		// TODO Auto-generated method stub
		return this.brandRepository.findById(id).get();
	}

	@Override
	public Page<Brand> getAll(Integer page, Integer limit) {
		Pageable pageable=PageRequest.of(page-1, limit);
		return this.brandRepository.findAll(pageable);
	}

	@Override
	public Page<Brand> searchBrand(String keyword, Integer page, Integer limit) {
		List list=this.searchBrand(keyword);
		Pageable pageable=PageRequest.of(page-1,limit);
		Integer start=(int) pageable.getOffset();
		Integer end=  (int) ( pageable.getOffset() + pageable.getPageSize()  > list.size() ? list.size() : pageable.getOffset()+pageable.getPageSize());
		list=list.subList(start, end);
		return new PageImpl<Brand>(list, pageable, this.searchBrand(keyword).size());
	}

	@Override
	public List<Brand> searchBrand(String keyword) {
		// TODO Auto-generated method stub
		return this.brandRepository.findByBrandNameContainingIgnoreCaseOrderByBrandNameAsc(keyword);
	}
	
}
