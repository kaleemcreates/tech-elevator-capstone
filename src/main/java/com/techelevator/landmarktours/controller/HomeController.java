package com.techelevator.landmarktours.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;


import org.springframework.web.servlet.ModelAndView;

import com.gargoylesoftware.htmlunit.javascript.host.geo.Geolocation;
import com.techelevator.landmarktours.model.Hotels;
import com.techelevator.landmarktours.model.HotelsDAO;
import com.techelevator.landmarktours.model.LandmarksDAO;
import com.techelevator.landmarktours.model.Landmarks;

@Controller
public class HomeController {
	@Autowired
	private HotelsDAO hotelsDAO;
	
	@Autowired
	private LandmarksDAO landmarksDAO;

	@RequestMapping(path={"/", "/home"}, method=RequestMethod.GET)
	public String showHomePage(Map<String, Object> model, HttpServletRequest request) {
		//model.put("landmarks", landmarkDAO.getHotels(5));
		List <Landmarks>landmarkList= landmarksDAO.getLandmarks();
		List <Hotels> hotelList= hotelsDAO.getHotels();
		
		request.setAttribute("hotelList", hotelList);
		request.setAttribute("landmarkList", landmarkList);
	
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
	

//    @RequestMapping(value = "/map", method = RequestMethod.GET)
//    public ModelAndView getPages(HttpServletRequest request) {
//        //Geolocation geoloc = geolocDAO.get();
//    	//HotelsDAO geoloc = hotelsDAO.getHotelById();
//        ModelAndView model = new ModelAndView("map");
//       // List<Geolocation> listGeo = geolocDAO.list();
////        List<Geolocation> listGeo = getHotelById.list();
////        model.addObject("listGeo", listGeo);
//        return model;
//    }


}
