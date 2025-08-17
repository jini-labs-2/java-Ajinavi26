package com.example.demo.form;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.web.multipart.MultipartFile;

class ReviewEditFormTest {
	private static ReviewEditForm reviewEditFormTest;

	@BeforeAll
	static void beforeAll() {
		reviewEditFormTest = new ReviewEditForm();
	}
	@Test
	void setterGetterComment() {
		reviewEditFormTest.setComment("コメントです。");
		assertEquals("コメントです。", reviewEditFormTest.getComment());
	}
	
	@Test
	void setterGetter() {
		reviewEditFormTest.setRating(15);
		assertEquals(15, reviewEditFormTest.getRating());
	}
	
	@Test
	void setterGetterInfile() throws IOException {
		MultipartFile mockF = mock(MultipartFile.class);
		String fn = "test.txt";
		byte[] fileContent = "Hello, world".getBytes();
		
		when(mockF.getOriginalFilename()).thenReturn(fn);
		when(mockF.getBytes()).thenReturn(fileContent);
		
		reviewEditFormTest.setInfile(mockF);
		
		MultipartFile retrievedFile = reviewEditFormTest.getInfile();
		
		assertThat(retrievedFile).isNotNull();
		
	}

}
