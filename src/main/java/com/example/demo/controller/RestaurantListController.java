package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Restaurant;
import com.example.demo.form.RestaurantSearchForm;
import com.example.demo.service.RestaurantService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RestaurantListController {
	
	private final RestaurantService service;

	@GetMapping("/top")
	private String restaurantList(@ModelAttribute RestaurantSearchForm form) {
		
		return "restaurant-list";
	}
	
	@PostMapping("/restaurant-search")
	private String restaurantSearch(@ModelAttribute RestaurantSearchForm form,
			Model model) {

//		List<Restaurant> list = new ArrayList<Restaurant>();
//		list.add(new Restaurant(1, "shop 1", "catch phrase 1", 3.5));
//		list.add(new Restaurant(1, "shop 122", "catch phrase 2", 0.0));
//		list.add(new Restaurant(1, "shop 133333", "catch phrase 3", 4.5));
		
		List<Restaurant> list = this.service.getList(form.getRestaurantName());
		
		model.addAttribute("restaurantList", list);
		
		return "restaurant-list";
	}
}
