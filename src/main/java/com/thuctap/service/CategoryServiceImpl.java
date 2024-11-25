package com.thuctap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.thuctap.models.Category;
import com.thuctap.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return this.categoryRepository.findAll(Sort.by(Sort.Direction.ASC, "categoryName"));
	}

	@Override
	public Boolean create(Category a) {
		try {
			this.categoryRepository.save(a);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean delete(Integer id) {
		try {
			this.categoryRepository.delete(findById(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return false;
	}

	@Override
	public Category findById(Integer id) {
		// TODO Auto-generated method stub
		return this.categoryRepository.findById(id).get();
	}

	@Override
	public Page<Category> getAll(Integer page,Integer limit) {
		Pageable pageable=PageRequest.of(page-1, limit);
		return this.categoryRepository.findAll(pageable);
	}
	@Override
	public Page<Category> searchCategory(String keyword, Integer page,Integer limit) {
		List list=this.searchCategory(keyword);
		Pageable pageable=PageRequest.of(page-1,limit);
		Integer start=(int) pageable.getOffset();
		Integer end=  (int) ( pageable.getOffset() + pageable.getPageSize()  > list.size() ? list.size() : pageable.getOffset()+pageable.getPageSize());
		list=list.subList(start, end);
		return new PageImpl<Category>(list, pageable, this.searchCategory(keyword).size());
	}

	@Override
	public List<Category> searchCategory(String keyword) {
		// TODO Auto-generated method stub
		return this.categoryRepository.findByCategoryNameContainingIgnoreCaseOrderByCategoryNameAsc(keyword);
	}

	

}
