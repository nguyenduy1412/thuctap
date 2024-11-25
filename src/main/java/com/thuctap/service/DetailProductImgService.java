package com.thuctap.service;

import java.util.List;

import com.thuctap.models.DetailProductImg;


public interface DetailProductImgService {
	List<DetailProductImg> getAll();
	Boolean create(DetailProductImg a);
	Boolean update(DetailProductImg a);
	Boolean delete(Integer id);
	DetailProductImg findById(Integer id);
	Boolean deleteByProductId(Integer id);
}
