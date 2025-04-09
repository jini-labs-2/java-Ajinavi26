package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Restaurant;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class RestaurantRepositoryImpl implements RestaurantRepository {

	private final JdbcTemplate db;

	//  @Override
	//	public String getName(int Id){
	//	
	//	String sql = " select restaurant_name from m_restaurant where restaurant_id = ? ";
	//	
	//	String name = db.queryForObject(sql, Id);
	//	
	//	return name;		
	//}
	
	@Override
	public Restaurant getRestaurant(int Id){
		
		String sql = " select * from m_restaurant where restaurant_id = ? ";
		
		Map<String, Object> result = db.queryForMap(sql, Id);
		
		Restaurant res = new Restaurant();
		res.setRestaurantId((int)result.get("restaurant_id"));
		res.setRestaurantName((String)result.get("restaurant_name"));
		res.setCatchPhrase((String)result.get("catch_phrase"));
		res.setAverageRating((double)result.get("average_rating"));
		
		return res;
	}
	
	@Override
	public List<Restaurant> getList(String name){
	
		//String sql = " select * from m_restaurant where restaurant_name LIKE ?";
		String sql = 
			" select mr.restaurant_id , mr.restaurant_name, mr.catch_phrase, " + 
			" coalesce(avg(tr.rating), 0.0) average_rating " +
			" from m_restaurant mr " +
			" left outer join t_review tr on mr.restaurant_id = tr.restaurant_id " +
			" where mr.restaurant_name like ? " +
			" group BY mr.restaurant_id, mr.restaurant_name, mr.catch_phrase " + 
			" order by mr.restaurant_id ";
		
		List<Map<String, Object>> list = db.queryForList(sql, ("%" + name + "%"));
		
		List<Restaurant> result = new ArrayList<Restaurant>();
		for (Map<String, Object> one:list) {
			Restaurant res = new Restaurant();
			res.setRestaurantId((int)one.get("restaurant_id"));
			res.setRestaurantName((String)one.get("restaurant_name"));
			res.setCatchPhrase((String)one.get("catch_phrase"));
			double d = ((BigDecimal)one.get("average_rating")).doubleValue();
			res.setAverageRating(d);
		
			result.add(res);
		}
		
		return result;
	}
}
