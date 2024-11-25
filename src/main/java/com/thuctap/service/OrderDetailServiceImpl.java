
package com.thuctap.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.thuctap.models.OrderDetail;
import com.thuctap.models.Product;
import com.thuctap.repository.OrderDetailRepository;


@Service
public class OrderDetailServiceImpl implements OrderDetailService{
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	@Autowired
	private ProductService productService;
	@Override
	public List<OrderDetail> getAll() {
		// TODO Auto-generated method stub
		return this.orderDetailRepository.findAll();
	}

	@Override
	public List<OrderDetail> getByOrderId(Integer id) {
		// TODO Auto-generated method stub
		return this.orderDetailRepository.findByOrdersId(id);
	}

	@Override
	public Boolean create(OrderDetail a) {
		try {
			this.orderDetailRepository.save(a);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return false;
	}

	@Override
	public OrderDetail findById(Integer id) {
		// TODO Auto-generated method stub
		return this.orderDetailRepository.findById(id).get();
	}

	@Override
	public Boolean deleteByOrdersId(Integer id) {
		try {
			this.orderDetailRepository.deleteByOrdersId(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> findProductTrend() {
		List<Integer> listId=this.orderDetailRepository.findProductTrend();
		List<Product> listBook=new ArrayList<Product>();
		int i=0;
		for (Integer id : listId) {
			listBook.add(this.productService.findById(id));
			i++;
			if(i==6) {
				break;
			}
		}
		return listBook;
	}

	@Override
	public Page<Product> findProductTrend(Integer page) {
		List<Product> list = this.findAllProductTrend();
		Pageable pageable = PageRequest.of(page - 1, 4);
		int start = (int) pageable.getOffset();
		int end = Math.min(start + pageable.getPageSize(), list.size());

		List<Product> sublist = list.subList(start, end);

		return new PageImpl<>(sublist, pageable, list.size());
	}

	@Override
	public List<Product> findAllProductTrend() {
		List<Integer> listId=this.orderDetailRepository.findProductTrend();
		List<Product> listProduct=new ArrayList<Product>();
		
		for (Integer id : listId) {
			listProduct.add(this.productService.findById(id));
		}
		return listProduct;
	}



}
