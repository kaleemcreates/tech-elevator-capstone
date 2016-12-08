package com.techelevator.landmarktours.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.landmarktours.model.LandmarkReviews;
import com.techelevator.landmarktours.model.LandmarkReviewsDAO;
import com.techelevator.landmarktours.model.Landmarks;
import com.techelevator.landmarktours.model.LandmarksDAO;

@Controller
public class LandmarkController {
	
	@Autowired
	LandmarksDAO landmarksDAO;
	@Autowired
	LandmarkReviewsDAO landmarkReviewsDAO;
	
	@RequestMapping(path="/landmarkDetail", method=RequestMethod.GET)
	public String getLandmarkById(HttpServletRequest request) {
		String landmarkIdParam = request.getParameter("landmark_id");
		String landmarkId = landmarkIdParam;
	
		Landmarks landmark = landmarksDAO.getLandmarksById(landmarkId);
		request.setAttribute("landmark", landmark);
		return "landmarkDetail";
	}
	
	@RequestMapping(path="/landmarkDetail", method=RequestMethod.POST)
	public String processReviewSubmission(@RequestParam String landmark_id,
											@RequestParam String userName,
											@RequestParam boolean thumbsUp,
											@RequestParam String reviewText) {
		LandmarkReviews review = new LandmarkReviews();
		review.setLandmarkId(landmark_id);
		review.setUserName(userName);
		review.setThumbsUp(thumbsUp);
		review.setReviewText(reviewText);
		review.setCreateDate(LocalDateTime.now());
		
		landmarkReviewsDAO.save(review);
		return "redirect:/landmarkReviewsResults?landmark_id=" + landmark_id;
	}
	
	@RequestMapping("/landmarkReviewsResults")
	public String handleLandmarkReviewsResults(HttpServletRequest request,
												@RequestParam String landmark_id) {
		List<LandmarkReviews> reviewList = new ArrayList<LandmarkReviews>();
		reviewList = landmarkReviewsDAO.getLandmarkReviewsByLandmarkId(landmark_id);
		request.setAttribute("reviewList", reviewList);
		
		return "landmarkReviewsResults";
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
