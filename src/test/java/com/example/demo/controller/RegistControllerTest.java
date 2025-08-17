package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.form.ReviewRegistForm;
import com.example.demo.service.RegistService;

@WebMvcTest(RegistController.class)
class RegistControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private RegistService service;

	@Test
	void testShowReviewForm() throws Exception {
		ReviewRegistForm form = new ReviewRegistForm();
		form.setUserId("user1");
		form.setRestaurantId(1111);
		form.setRestaurantName("res111");
		form.setComment("good");
		
		mockMvc.perform(post("/show-review-form")
				.flashAttr("reviewRegistForm", form))
				.andExpect(status().isOk())
				.andExpect(view().name("regist-review"))
				.andExpect(model().attributeExists("reviewRegistForm"))
				.andExpect(model().attribute("reviewRegistForm", form));
		

		
		
		
		
	}

}
