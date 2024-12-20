package com.thuctap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.thuctap.models.OrderDetail;

import jakarta.transaction.Transactional;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer>{
	List<OrderDetail> findByOrdersId(Integer id);
	@Transactional
	@Modifying
	@Query("delete from OrderDetail i where i.orders.id =?1 ")
	void deleteByOrdersId(Integer id);
	@Query("select  i.product.id from OrderDetail i group by i.product.id order by count(*) desc")
	List<Integer> findProductTrend();
}
