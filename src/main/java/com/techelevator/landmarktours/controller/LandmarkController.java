package com.techelevator.landmarktours.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.landmarktours.model.Landmarks;
import com.techelevator.landmarktours.model.LandmarksDAO;

@Controller
public class LandmarkController {
	
	@Autowired
	LandmarksDAO landmarksDAO;
	
	@RequestMapping(path="/landmarkDetail", method=RequestMethod.GET)
	public String getLandmarkById(HttpServletRequest request) {
		String landmarkIdParam = request.getParameter("landmark_id");
		String landmarkId = landmarkIdParam;
	
		Landmarks landmark = landmarksDAO.getLandmarksById(landmarkId);
		request.setAttribute("landmark", landmark);
		return "landmarkDetail";
	}

}
