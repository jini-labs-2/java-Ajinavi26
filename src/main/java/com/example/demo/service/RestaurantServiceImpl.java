package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Restaurant;
import com.example.demo.repository.RestaurantRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

	private final RestaurantRepository repository;
	
//	@Override
//	public String getName(int Id) {
//		return this.repository.getName(Id);
//	}

	@Override
	public Restaurant getRestaurant(int Id) {
		return repository.getRestaurant(Id);
	}
	
	@Override
	public List<Restaurant> getList(String restaurantName) {
		List<Restaurant> list = repository.getList(restaurantName);
		
		return list;
	}

}
