package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Review;

public interface ReviewRepository {

	void add(Review review);
	public List<Review> getListId(Integer Id);
	void update(Review review);
	void remove(Integer id);
}
