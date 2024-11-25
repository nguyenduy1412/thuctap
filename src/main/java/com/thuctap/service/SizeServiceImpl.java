package com.thuctap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.thuctap.models.Size;
import com.thuctap.repository.SizeRepository;

@Service
public class SizeServiceImpl implements SizeService{

	@Autowired
	private SizeRepository sizeRepository;
	@Override
	public List<Size> findAll() {
		// TODO Auto-generated method stub
		return this.sizeRepository.findAll();
	}

	@Override
	public Boolean create(Size a) {
		try {
			this.sizeRepository.save(a);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean delete(Integer id) {
		try {
			this.sizeRepository.delete(findById(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return false;
	}

	@Override
	public Size findById(Integer id) {
		// TODO Auto-generated method stub
		return this.sizeRepository.findById(id).get();
	}

}
