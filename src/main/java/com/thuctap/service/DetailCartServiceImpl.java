package com.thuctap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thuctap.models.DetailCart;
import com.thuctap.repository.DetailCartRepository;



@Service
public class DetailCartServiceImpl implements DetailCartService{
	
	@Autowired
	private DetailCartRepository detailCartRepository;

	@Override
	public List<DetailCart> getAll() {
		// TODO Auto-generated method stub
		return this.detailCartRepository.findAll();
	}

	@Override
	public Boolean createOrUpdate(DetailCart a) {
		try {
			this.detailCartRepository.save(a);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean delete(Integer id) {
		try {
			this.detailCartRepository.delete(findById(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public DetailCart findById(Integer id) {
		// TODO Auto-generated method stub
		return this.detailCartRepository.findById(id).get();
	}

	@Override
	public Integer sumQuantityByCartId(Integer id) {
		// TODO Auto-generated method stub
		return this.detailCartRepository.sumQuantityByCartId(id);
	}

	@Override
	public DetailCart findByCartIdAndProductId(Integer cartId, Integer productId) {
		// TODO Auto-generated method stub
		return this.detailCartRepository.findByCartIdAndProductId(cartId, productId);
	}

	@Override
	public List<DetailCart> findByCartId(Integer id) {
		// TODO Auto-generated method stub
		return this.detailCartRepository.findByCartId(id);
	}

	@Override
	public DetailCart update(DetailCart a) {
		try {
			return this.detailCartRepository.save(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean deleteByCartId(Integer id) {
		try {
			this.detailCartRepository.deleteByCartId(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<DetailCart> findByCartIdOrderByIdDesc(Integer id) {
		// TODO Auto-generated method stub
		return this.detailCartRepository.findByCartIdOrderByIdDesc(id);
	}


	

}
