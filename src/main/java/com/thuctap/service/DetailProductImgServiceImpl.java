package com.thuctap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thuctap.models.DetailProductImg;
import com.thuctap.repository.DetailProductImgRepository;


@Service
public class DetailProductImgServiceImpl implements DetailProductImgService{

	@Autowired
	private DetailProductImgRepository detailProductImgRepository;
	@Override
	public List<DetailProductImg> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean create(DetailProductImg a) {
		try {
			this.detailProductImgRepository.save(a);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return false;
	}

	@Override
	public Boolean update(DetailProductImg a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Integer id) {
		try {
			this.detailProductImgRepository.delete(findById(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();	
		}
		return false;
	}

	@Override
	public DetailProductImg findById(Integer id) {
		// TODO Auto-generated method stub
		return this.detailProductImgRepository.findById(id).get();
	}

	@Override
	public Boolean deleteByProductId(Integer id) {
		try {
			this.detailProductImgRepository.deleteByProductId(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();	
		}
		return false;
	}

	

}
