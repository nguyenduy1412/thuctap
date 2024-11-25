package com.thuctap.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.thuctap.models.Product;

public interface ProductService {
	List<Product> getAll();
	Boolean create(Product a);
	Boolean update(Product a);
	Boolean delete(Integer id);
	Product findById(Integer id);
	List<Product> findProductNew(Integer id);
	List<Product> findProductSale();
	List<Product> searchProduct(String keyword);
	Page<Product> getAll(Integer page,Integer limit);
	Page<Product> listProductNew(Integer id,Integer page,Integer limit);
	Page<Product> listProductSale(Integer page);
	Page<Product> searchProduct(String keyword,Integer page,Integer limit);
	List<Product> findByCategoryId(Integer id);
	Page<Product> findByCateId(Integer id,Integer page);
	// lấy danh sách sách theo thứ tự alphabeta
	List<Product> findAllByOrderByProductNameAsc();
}
