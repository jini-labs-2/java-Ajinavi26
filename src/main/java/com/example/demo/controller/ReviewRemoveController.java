package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.form.ReviewRemoveForm;
import com.example.demo.service.ReviewService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ReviewRemoveController {
	private final ReviewService service;
	
	@PostMapping("/remove-review")
	public String removeReview(
			@Validated @ModelAttribute ReviewRemoveForm form,
			BindingResult result) {
		
		if (result.hasErrors()) {
			throw new IllegalArgumentException("**removeReview()**");
		}
		
		return "confirm-remove-review";
	}
	
	@PostMapping("/confirm-remove-review")
	public String confirmRemoveReview(
			@Validated @ModelAttribute ReviewRemoveForm form,
			BindingResult result,
			RedirectAttributes redirectAttributes) {
		
		if (result.hasErrors()) {
			throw new IllegalArgumentException("**confirmRemoveReview()**");
		}
		
		service.removeReview(form.getReviewId());
//		System.out.println(form.getReviewId());
		
		redirectAttributes.addFlashAttribute("msg", "削除完了");
		
		return "redirect:/complete";
	}
}
