package com.thuctap.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.thuctap.models.OrderDetail;
import com.thuctap.models.Product;



public interface OrderDetailService {
	List<OrderDetail> getAll();
	List<OrderDetail> getByOrderId(Integer id);
	Boolean create(OrderDetail a);
	OrderDetail findById(Integer id);
	Boolean deleteByOrdersId(Integer id);
	List<Product> findProductTrend();
	List<Product> findAllProductTrend();
	Page<Product> findProductTrend(Integer page);
}
