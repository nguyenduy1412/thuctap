package com.thuctap.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.thuctap.models.Users;




public interface UserService {
	Users findByUserName(String userName);
	List<Users> findAllUsers();
	Users update(Users a);
}
