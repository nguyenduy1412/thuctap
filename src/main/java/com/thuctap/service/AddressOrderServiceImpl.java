package com.thuctap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.thuctap.models.AddressOrder;
import com.thuctap.models.Brand;
import com.thuctap.models.Category;
import com.thuctap.models.Users;
import com.thuctap.repository.AddressOrderRepository;
import com.thuctap.repository.BrandRepository;

@Service
public class AddressOrderServiceImpl implements AddressOrderService{
	@Autowired
	private AddressOrderRepository addressOrderRepository;

	@Override
	public Boolean create(AddressOrder a) {
		try {
			this.addressOrderRepository.save(a);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean delete(Integer id) {
		try {
			this.addressOrderRepository.delete(findById(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return false;
	}

	@Override
	public AddressOrder findById(Integer id) {
		// TODO Auto-generated method stub
		return this.addressOrderRepository.findById(id).get();
	}

	@Override
	public AddressOrder finByUsers(Users a) {
		// TODO Auto-generated method stub
		return this.addressOrderRepository.findByUsers(a);
	}

	

	
	
}
