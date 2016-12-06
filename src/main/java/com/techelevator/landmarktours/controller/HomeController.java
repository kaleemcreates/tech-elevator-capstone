package com.techelevator.landmarktours.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.techelevator.landmarktours.model.LandmarksDAO;

@Controller
public class HomeController {
	
	//private ReviewDAO reviewDAO;
	//private LandmarkDAO landmarkDAO;
//	@Autowired
//	public HomeController(ReviewDAO reviewDAO) {
//		this.reviewDAO = reviewDAO;
//	}
//	@Autowired
//	public HomeController(LandmarkDAO landmarkDAO){
//		this.landmarkDAO = landmarkDAO;
//	}
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String showHomePage(Map<String, Object> model) {
		//model.put("landmarks", landmarkDAO.getHotels(5));
	
		return "home";
	}
}
