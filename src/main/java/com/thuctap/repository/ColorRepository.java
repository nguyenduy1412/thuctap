package com.thuctap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thuctap.models.Color;
import com.thuctap.models.Size;


public interface ColorRepository extends JpaRepository<Color, Integer> {
	
}
