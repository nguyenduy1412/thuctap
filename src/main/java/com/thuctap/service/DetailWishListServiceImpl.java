package com.thuctap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.thuctap.models.DetailWishList;
import com.thuctap.repository.DetailWishListRepository;



@Service
public class DetailWishListServiceImpl implements DetailWishListService{
	
	@Autowired
	private DetailWishListRepository detailWishListRepository;

	

	@Override
	public Boolean createOrUpdate(DetailWishList a) {
		try {
			this.detailWishListRepository.save(a);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean delete(Integer id) {
		try {
			this.detailWishListRepository.delete(findById(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public DetailWishList findById(Integer id) {
		// TODO Auto-generated method stub
		return this.detailWishListRepository.findById(id).get();
	}

	@Override
	public Page<DetailWishList> findByFavouriteId(Integer id, Integer page, Integer limit) {
		List<DetailWishList> list = this.findByFavouriteIdOrderByIdDesc(id);
		Pageable pageable = PageRequest.of(page - 1, limit);
		int start = (int) pageable.getOffset();
		int end = Math.min(start + pageable.getPageSize(), list.size());

		List<DetailWishList> sublist = list.subList(start, end);

		return new PageImpl<>(sublist, pageable, list.size());
	}

	@Override
	public List<DetailWishList> findByFavouriteIdOrderByIdDesc(Integer id) {
		// TODO Auto-generated method stub
		return this.detailWishListRepository.findByWishListIdOrderByIdDesc(id);
	}

	@Override
	public DetailWishList findByFavouriteIdAndProductId(Integer wishListId, Integer productId) {
		return this.detailWishListRepository.findByWishListIdAndProductId(wishListId, productId);
	}



}
