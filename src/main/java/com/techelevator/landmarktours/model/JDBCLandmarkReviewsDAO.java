package com.techelevator.landmarktours.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCLandmarkReviewsDAO implements LandmarkReviewsDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCLandmarkReviewsDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<LandmarkReviews> getLandmarkReviewsByLandmarkId(String landmarkId) {
		List<LandmarkReviews> landmarkReviewsByLandmarkId = new ArrayList<>();
		String sqlSelectReviewsByLandmarkId = "SELECT * "
											+ "FROM landmark_reviews "
											+ "WHERE landmark_id = ? ";
								
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectReviewsByLandmarkId, landmarkId);
		while(results.next()) {
			LandmarkReviews landmarkReview = new LandmarkReviews();
			landmarkReview.setReviewId(results.getString("review_id"));
			landmarkReview.setLandmarkId(results.getString("landmark_id"));
			landmarkReview.setUserName(results.getString("user_name"));
			landmarkReview.setThumbsUp(results.getBoolean("thumbs_up"));
			landmarkReview.setReviewText(results.getString("review_text"));
			landmarkReview.setCreateDate(results.getTimestamp("create_date").toLocalDateTime());
			landmarkReviewsByLandmarkId.add(landmarkReview);
		}
		return landmarkReviewsByLandmarkId;
	}

	@Override
	public void save(LandmarkReviews review) {
		String sqlInsertReview = "INSERT INTO landmark_reviews(review_id, landmark_id, user_name, thumbs_up, review_text, create_date) "
								+ "VALUES (?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sqlInsertReview, review.getReviewId(), review.getLandmarkId(), review.getUserName(), review.isThumbsUp(), review.getReviewText(), review.getCreateDate());
	}

}
