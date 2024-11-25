package com.thuctap.service;

import java.util.List;

import com.thuctap.models.DetailCart;



public interface DetailCartService {
	List<DetailCart> getAll();
	Boolean createOrUpdate(DetailCart a);
	DetailCart update(DetailCart a);
	Boolean delete(Integer id);
	Boolean deleteByCartId(Integer id);
	DetailCart findById(Integer id);
	Integer sumQuantityByCartId(Integer id);
	DetailCart findByCartIdAndProductId(Integer cartId,Integer productId);
	List<DetailCart> findByCartId(Integer id);
	List<DetailCart> findByCartIdOrderByIdDesc(Integer id);
}
