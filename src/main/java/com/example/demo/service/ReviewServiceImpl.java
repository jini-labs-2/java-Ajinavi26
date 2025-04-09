package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Review;
import com.example.demo.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

	private final ReviewRepository repository;
	
	@Override
	public List<Review> getList(Integer Id) {
		List<Review> res = repository.getListId(Id);
		
		return res;
	}

	@Override
	public void updateReview(Review review) {
		repository.update(review);		
	}

	@Override
	public void removeReview(Integer Id) {
		repository.remove(Id);
	}
}
