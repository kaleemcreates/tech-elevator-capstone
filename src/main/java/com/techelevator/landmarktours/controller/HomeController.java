package com.techelevator.landmarktours.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.landmarktours.model.LandmarksDAO;

@Controller
public class HomeController {

	@RequestMapping(path={"/", "/home"}, method=RequestMethod.GET)
	public String showHomePage(Map<String, Object> model) {
		//model.put("landmarks", landmarkDAO.getHotels(5));
	
		return "home";
	}
	@RequestMapping(path={"/", "/home"}, method=RequestMethod.POST)
	public String getAnonymousSearchResults(@RequestParam Double latitude, @RequestParam Double longitude,  
												Map<String, Object> model) {
		
	
		return "redirect: /anonmyousSearchResults";
	}
	@RequestMapping(path={"/anonmyousSearchResults"}, method=RequestMethod.GET)
	public String showAnonymousSearhResults(Map<String, Object> model) {
		//model.put("landmarks", landmarkDAO.getHotels(5));
	
		return "anonmyousSearchResults";
	}
	
}
