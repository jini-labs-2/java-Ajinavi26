package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Restaurant;

public interface RestaurantRepository {
//	public String getName(int Id);
	public Restaurant getRestaurant(int Id);
	public List<Restaurant> getList(String name);

}
