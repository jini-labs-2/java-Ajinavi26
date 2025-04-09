package com.example.demo.repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Review;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepository {

	private final JdbcTemplate jdbcTemplate;
	@Override
	public void add(Review review) {
//		System.out.println("--登録--");
//		System.out.println(review);
		String sql =
				"insert into t_review" +
				" (restaurant_id, user_id, visit_date, rating, comment) " +
				" VALUES (?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, review.getRestaurantId(),
			review.getUserId(),
			review.getVisitDate(),
			review.getRating(),
			review.getComment());
		
	}
	@Override
	public List<Review> getListId(Integer Id) {
		String sql = 
				" select " + 
				"    review_id,           " + 
				"    restaurant_id,       " + 
				"    user_id,             " + 
				"    visit_date,          " + 
				"    rating,              " + 
				"    comment              " + 
				" from t_review " +
				" where restaurant_id = ? ";
			
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, Id);

		List<Review> result = new ArrayList<Review>();
		for (Map<String, Object> one : list) {
			Review res = new Review();
			res.setReviewId((int)one.get("review_id"));
			res.setRestaurantId((int)one.get("restaurant_id"));
			res.setUserId((String)one.get("user_id"));
			res.setVisitDate((Date)one.get("visit_date"));
			res.setRating((int)one.get("rating"));
			res.setComment((String)one.get("comment"));
		
			result.add(res);
		}

		return result;
	}
	@Override
	public void update(Review review) {

		String sql =
			" UPDATE t_review " +
					" set user_id = ?, " +
					" visit_date = ?, " +
					" rating = ?, " +
					" comment = ? " +
					" WHERE review_id = ?";
		jdbcTemplate.update(sql,
				review.getUserId(),
				review.getVisitDate(),
				review.getRating(),
				review.getComment(),
				review.getReviewId());
	}
	
	@Override
	public void remove(Integer Id) {
		String sql =
				" delete from t_review " +
						" WHERE review_id = ?";
		jdbcTemplate.update(sql, Id);
		
	}

}
