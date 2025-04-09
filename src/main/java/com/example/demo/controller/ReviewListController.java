package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Review;
import com.example.demo.form.ReviewSearchForm;
import com.example.demo.service.ReviewService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ReviewListController {

	private final ReviewService service;
	
	@PostMapping("/search-review")
	public String searchReview(@ModelAttribute ReviewSearchForm form,
			Model model) {

		List<Review> list = this.service.getList(form.getRestaurantId());
		
		if (list.size() > 0)
			model.addAttribute("reviewList", list);
		
		return "review-list";
		
	}
}
