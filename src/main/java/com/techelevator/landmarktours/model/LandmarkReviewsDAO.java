package com.techelevator.landmarktours.model;

import java.util.List;

public interface LandmarkReviewsDAO {
	
	public List<LandmarkReviews> getLandmarkReviewsByLandmarkId(String landmarkId);
	public void save(LandmarkReviews review);


}
