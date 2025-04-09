package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Restaurant;

public interface RestaurantService {

//	public String getName(int Id);
	public Restaurant getRestaurant(int Id);
	public List<Restaurant> getList(String restaurantName);
}
