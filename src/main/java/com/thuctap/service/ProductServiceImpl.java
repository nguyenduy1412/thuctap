package com.thuctap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.thuctap.models.Product;
import com.thuctap.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository ;

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return this.productRepository.findAll();
	}

	@Override
	public Boolean create(Product a) {
		// TODO Auto-generated method stub
		try {
			this.productRepository.save(a);
			return true;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}

	@Override
	public Boolean update(Product a) {
		try {
			this.productRepository.save(a);
			return true;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}

	@Override
	public Boolean delete(Integer id) {
		try {
			this.productRepository.delete(findById(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}

	@Override
	public Product findById(Integer id) {
		// TODO Auto-generated method stub
		return this.productRepository.findById(id).get();
	}

	@Override
	public List<Product> findProductNew(Integer id) {
		// TODO Auto-generated method stub
		return this.productRepository.findTop6ByCategoryIdOrderByIdDesc(id);
	}

	@Override
	public List<Product> findProductSale() {
		// TODO Auto-generated method stub
		return this.productRepository.findProductSale();
	}

	@Override
	public List<Product> searchProduct(String keyword) {
		// TODO Auto-generated method stub
		return this.productRepository.findByProductNameContainingIgnoreCaseOrderByProductNameAsc(keyword);
	}

	@Override
	public Page<Product> getAll(Integer page ,Integer limit) {
		List<Product> list = this.getAll();
		Pageable pageable = PageRequest.of(page - 1, limit);
		int start = (int) pageable.getOffset();
		int end = Math.min(start + pageable.getPageSize(), list.size());

		List<Product> sublist = list.subList(start, end);

		return new PageImpl<>(sublist, pageable, list.size());
	}

	@Override
	public Page<Product> listProductNew(Integer id,Integer page,Integer limit) {
		List<Product> list = this.findProductNew(id);
		Pageable pageable = PageRequest.of(page - 1, limit);
		int start = (int) pageable.getOffset();
		int end = Math.min(start + pageable.getPageSize(), list.size());

		List<Product> sublist = list.subList(start, end);

		return new PageImpl<>(sublist, pageable, list.size());
	}

	@Override
	public Page<Product> searchProduct(String keyword, Integer page,Integer limit) {
		List list = this.searchProduct(keyword);
		Pageable pageable = PageRequest.of(page - 1, limit);
		Integer start = (int) pageable.getOffset();
		Integer end = (int) (pageable.getOffset() + pageable.getPageSize() > list.size() ? list.size()
				: pageable.getOffset() + pageable.getPageSize());

		list = list.subList(start, end);
		return new PageImpl<Product>(list, pageable, this.searchProduct(keyword).size());
	}

	@Override
	public List<Product> findByCategoryId(Integer id) {
		// TODO Auto-generated method stub
		return this.productRepository.findByCategoryIdOrderByIdDesc(id);
	}

	@Override
	public Page<Product> findByCateId(Integer id,Integer page) {
		List<Product> list=this.findByCategoryId(id);
		Pageable pageable = PageRequest.of(page - 1, 4);
		int start = (int) pageable.getOffset();
		int end = Math.min(start + pageable.getPageSize(), list.size());

		List<Product> sublist = list.subList(start, end);

		return new PageImpl<>(sublist, pageable, list.size());
	}

	@Override
	public List<Product> findAllByOrderByProductNameAsc() {
		// TODO Auto-generated method stub
		return this.productRepository.findAllByOrderByProductNameAsc();
	}

	@Override
	public Page<Product> listProductSale(Integer page) {
		List<Product> list = this.findProductSale();
		Pageable pageable = PageRequest.of(page - 1, 4);
		int start = (int) pageable.getOffset();
		int end = Math.min(start + pageable.getPageSize(), list.size());

		List<Product> sublist = list.subList(start, end);

		return new PageImpl<>(sublist, pageable, list.size());
	}

	 
	 

}
