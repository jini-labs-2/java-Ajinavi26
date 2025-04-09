package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Review;
import com.example.demo.form.ReviewRegistForm;
import com.example.demo.service.RegistService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RegistController {

	private final RegistService service;
	
	@PostMapping("/show-review-form")
	public String showReviewForm(@ModelAttribute ReviewRegistForm form) {
		return "regist-review";
	}

	@PostMapping("/show-review-form-ret")
	public String showReviewFormRet(@ModelAttribute ReviewRegistForm form) {
		return "regist-review";
	}
	
	@PostMapping("/regist-review")
	public String registReview(
			@Validated @ModelAttribute ReviewRegistForm form,
			BindingResult result) {
		if (result.hasErrors()) {
			return "regist-review";
		}
		return "confirm-regist-review";
	}
	@PostMapping("/confirm-regist-review")
	public String confirmRegisReview(
			@Validated ReviewRegistForm form,
			BindingResult result,
			RedirectAttributes redirectAttibutes) {
		
			if (result.hasErrors()) {
				return "regist-review";
			}
			
			Review createReview = new Review();
			createReview.setRestaurantId(form.getRestaurantId());
			createReview.setUserId(form.getUserId());
			createReview.setVisitDate(form.getVisitDate());
			createReview.setRating(form.getRating());
			createReview.setComment(form.getComment());
			this.service.regist(createReview);
			
			redirectAttibutes.addAttribute("msg", "レビュー登録");
			
		return "redirect:/complete";
	}
}
