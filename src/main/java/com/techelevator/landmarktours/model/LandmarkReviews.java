package com.techelevator.landmarktours.model;

import java.time.LocalDateTime;

public class LandmarkReviews {
	
	private String reviewId;
	private String landmarkId;
	private String userName;
	private boolean thumbsUp;
	private String reviewText;
	private LocalDateTime createDate;
	
	public String getReviewId() {
		return reviewId;
	}
	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}
	public String getLandmarkId() {
		return landmarkId;
	}
	public void setLandmarkId(String landmarkId) {
		this.landmarkId = landmarkId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public boolean isThumbsUp() {
		return thumbsUp;
	}
	public void setThumbsUp(boolean thumbsUp) {
		this.thumbsUp = thumbsUp;
	}
	public String getReviewText() {
		return reviewText;
	}
	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
	
	

}
