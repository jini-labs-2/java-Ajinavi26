package com.example.demo.controller;

import java.sql.Date;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Review;
import com.example.demo.form.ReviewEditForm;
import com.example.demo.service.ReviewService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ReviewEditController {
	private final ReviewService service;
	
	@PostMapping("/show-edit-form")
	public String showEditForm(@ModelAttribute ReviewEditForm form) {
	
		return "edit-review";
	}
	
	@PostMapping("/edit-review")
	public String editReview(@ModelAttribute ReviewEditForm form,
			BindingResult result) {
		
		if (result.hasErrors()) {
			return "edit-review";
		}
		
		return "confirm-edit-review";
	}
	
	@PostMapping("/confirm-edit-review")
	public String confirmEditReview(@Validated ReviewEditForm form,
			BindingResult result,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return "edit-review";
		}
		
		Review r = new Review();
		r.setReviewId((int)form.getReviewId());
		r.setRestaurantId((int)form.getRestaurantId());
		r.setUserId((String)form.getUserId());
		r.setVisitDate((Date)form.getVisitDate());
		r.setRating((int)form.getRating());
		r.setComment((String)form.getComment());
		
		System.out.println("--レビュー更新--");
		System.out.println(r);
		
		service.updateReview(r);
		
		redirectAttributes.addFlashAttribute("msg", "(レビュー更新)");
		
		return "redirect:/complete";
	}
	
}
