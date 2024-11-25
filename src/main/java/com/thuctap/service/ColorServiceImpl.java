package com.thuctap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thuctap.models.Color;
import com.thuctap.models.Size;
import com.thuctap.repository.ColorRepository;
import com.thuctap.repository.SizeRepository;

@Service
public class ColorServiceImpl implements ColorService{

	@Autowired
	private ColorRepository colorRepository;
	@Override
	public List<Color> findAll() {
		// TODO Auto-generated method stub
		return this.colorRepository.findAll();
	}

	@Override
	public Boolean create(Color a) {
		try {
			this.colorRepository.save(a);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean delete(Integer id) {
		try {
			this.colorRepository.delete(findById(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return false;
	}

	@Override
	public Color findById(Integer id) {
		// TODO Auto-generated method stub
		return this.colorRepository.findById(id).get();
	}

}
