package com.techelevator.landmarktours.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.techelevator.landmarktours.model.LandmarksDAO;

@Controller
public class HomeController {

	@RequestMapping(path={"/", "/home"}, method=RequestMethod.GET)
	public String showHomePage(Map<String, Object> model) {
		//model.put("landmarks", landmarkDAO.getHotels(5));
	
		return "home";
	}
}