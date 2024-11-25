package com.thuctap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thuctap.models.AddressOrder;
import com.thuctap.models.Brand;
import com.thuctap.models.Users;


public interface AddressOrderRepository extends JpaRepository<AddressOrder, Integer> {
	AddressOrder findByUsers(Users user);
}
