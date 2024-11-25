package com.thuctap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thuctap.models.WishList;
import com.thuctap.repository.WishListRepository;


@Service
public class WishListServiceImpl implements WishListService{
	@Autowired
	private WishListRepository wishListRepository;
	@Override
	public Boolean create(WishList a) {
		try {
			this.wishListRepository.save(a);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean checkWishList(Long id) {
		// TODO Auto-generated method stub
		return this.wishListRepository.countByUserId(id)>0;
	}

	@Override
	public WishList findByUserId(Long id) {
		// TODO Auto-generated method stub
		return this.wishListRepository.findByUserId(id);
	}

	@Override
	public WishList findById(Integer id) {
		// TODO Auto-generated method stub
		return this.wishListRepository.findById(id).get();
	}

}
