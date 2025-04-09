package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Review;
import com.example.demo.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegistServiceImpl implements RegistService {

//	@Autowired
	private final ReviewRepository repository;

	@Override
	public void regist(Review review) {
		this.repository.add(review);
	}

}
