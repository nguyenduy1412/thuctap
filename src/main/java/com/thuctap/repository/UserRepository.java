package com.thuctap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thuctap.models.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
	Users findByUserName(String userName);
}
