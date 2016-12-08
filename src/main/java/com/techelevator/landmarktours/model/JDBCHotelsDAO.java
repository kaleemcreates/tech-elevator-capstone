package com.techelevator.landmarktours.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.bouncycastle.util.encoders.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.security.PasswordHasher;

@Component
public class JDBCHotelsDAO implements HotelsDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCHotelsDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);

	}

	@Override
	public void getHotelById(String locationId) {
		String sqlSearchForHotel = "SELECT * "+
			      "FROM hotels "+
			      "WHERE location_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchForHotel, locationId);
		mapRowToHotels(results);
		}
//	@Override
//	public void getHotelLatitude(Decimal ) {
//		String sqlSearchForHotel = "SELECT * "+
//			      "FROM hotels "+
//			      "WHERE latitude =?";
//		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchForHotel, locationId);
//		mapRowToHotels(results);
//		}
	
	public List<Hotels> getHotels(int limit) {
		String sqlSelectLandmarks = "SELECT * "+
									"FROM landmarks "+
									"LIMIT ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectLandmarks, limit);
		return mapRowSetToHotels(results);
	}
	
	
	private List<Hotels> mapRowSetToHotels(SqlRowSet results) {
		ArrayList<Hotels> hotelList = new ArrayList<>();
		while(results.next()) {
			hotelList.add(mapRowToHotels(results));
		}
		return hotelList;
	}
	
	private Hotels mapRowToHotels(SqlRowSet results) {
		Hotels hotel = new Hotels();
		hotel.setLocationId(results.getString("location_id"));
		hotel.setName(results.getString("name"));
		hotel.setStreetAddress(results.getString("streetAddress"));
		hotel.setCity(results.getString("city"));
		hotel.setState(results.getString("state"));
		hotel.setZip(results.getString("zip"));
		hotel.setLatitude(results.getDouble("latitude"));
		hotel.setLongitude(results.getDouble("longitude"));
		hotel.setZip(results.getString("zip"));

		return hotel;
	}
		
}
	



