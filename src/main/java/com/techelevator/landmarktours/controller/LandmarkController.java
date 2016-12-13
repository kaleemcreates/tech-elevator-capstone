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
import com.techelevator.landmarktours.model.LandmarkSuggestions;
import com.techelevator.landmarktours.model.LandmarkSuggestionsDAO;
import com.techelevator.landmarktours.model.Landmarks;
import com.techelevator.landmarktours.model.LandmarksDAO;

@Controller
public class LandmarkController {
	
	@Autowired
	LandmarksDAO landmarksDAO;
	@Autowired
	LandmarkReviewsDAO landmarkReviewsDAO;
	@Autowired 
	LandmarkSuggestionsDAO landmarkSuggestionsDAO;
	
	@Autowired
	public LandmarkController(LandmarksDAO landmarksDAO, LandmarkReviewsDAO landmarkReviewsDAO, LandmarkSuggestionsDAO landmarkSuggestionsDAO) {
		this.landmarksDAO = landmarksDAO;
		this.landmarkReviewsDAO = landmarkReviewsDAO;
		this.landmarkSuggestionsDAO = landmarkSuggestionsDAO;
	}
	
	
	@RequestMapping(path="/landmarkDetail", method=RequestMethod.GET)
	public String getLandmarkAndReviewsById(HttpServletRequest request) {
		List <Landmarks>landmarkList= landmarksDAO.getLandmarks();
		request.setAttribute("landmarkList", landmarkList);
		
		String landmarkId = request.getParameter("landmark_id");
		Landmarks landmark = landmarksDAO.getLandmarksById(landmarkId);
		request.setAttribute("landmark", landmark);
		
		List<LandmarkReviews> reviewList = new ArrayList<LandmarkReviews>();
		reviewList = landmarkReviewsDAO.getLandmarkReviewsByLandmarkId(landmarkId);
		request.setAttribute("reviewList", reviewList);
		
		
		int thumbsUpCount = landmarkReviewsDAO.getNumberOfThumbsUpByLandMarkId(landmarkId);
		request.setAttribute("thumbsUpCount", thumbsUpCount);
		
		int thumbsDownCount = landmarkReviewsDAO.getNumberOfThumbsDownByLandMarkId(landmarkId);
		request.setAttribute("thumbsDownCount", thumbsDownCount);

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
		return "redirect:/landmarkDetail?landmark_id="+landmark_id;
	}
	@RequestMapping(path="/addLandmark", method=RequestMethod.GET)
	public String showAddLandmark(HttpServletRequest request) {

		return "addLandmark";
	}
	
	@RequestMapping(path="/addLandmark", method=RequestMethod.POST)
	public String processSuggestLandmark(@RequestParam String name,
											@RequestParam String type,
											@RequestParam String zip,
											@RequestParam String description) {
		LandmarkSuggestions suggestion = new LandmarkSuggestions();
		suggestion.setName(name);
		suggestion.setType(type);
		suggestion.setZip(zip);
		suggestion.setDateRequested(LocalDateTime.now());
		suggestion.setDescription(description);
		
		landmarkSuggestionsDAO.save(suggestion);
		return "redirect:/adminLanding";
	}


	
	
	
	
	
	
	
	
	
	
	
	
	

}
