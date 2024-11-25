package com.thuctap.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.thuctap.models.AddressOrder;
import com.thuctap.models.Brand;
import com.thuctap.models.Category;
import com.thuctap.models.Users;

public interface AddressOrderService {
	AddressOrder finByUsers(Users a);
	Boolean create(AddressOrder a);
	Boolean delete(Integer id);
	AddressOrder findById(Integer id);
	
	
}
