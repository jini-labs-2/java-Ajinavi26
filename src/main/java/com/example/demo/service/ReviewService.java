package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Review;

public interface ReviewService {

	public List<Review> getList(Integer Id);
	
	public void updateReview(Review review);
	
	public void removeReview(Integer Id);
}
