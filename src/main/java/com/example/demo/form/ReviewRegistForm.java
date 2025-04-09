package com.example.demo.form;

import java.sql.Date;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ReviewRegistForm {

	@NotNull(message="入力して下さい")
	@Min(value=1, message="正の整数を入力して下さい")
	private Integer restaurantId;
	
	private String restaurantName;

	@NotNull(message="入力して下さい")
	private String userId;

	@Past(message="今日以前の日付を入力して下さい")
	private Date visitDate;
	
	@Min(value=1, message="1-5で指定して下さい")
	@Max(value=5, message="1-5で指定して下さい")
	private Integer rating;

	@Size(min=1, max=128, message="1~128文字で指定して下さい")
	private String comment;
}
