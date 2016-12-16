package com.techelevator.landmarktours.controller;

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.gargoylesoftware.htmlunit.javascript.host.geo.Geolocation;
import com.techelevator.landmarktours.model.Hotels;
import com.techelevator.landmarktours.model.HotelsDAO;
import com.techelevator.landmarktours.model.Itinerary;
import com.techelevator.landmarktours.model.ItineraryDAO;
import com.techelevator.landmarktours.model.ItineraryLandmarks;
import com.techelevator.landmarktours.model.JDBCItineraryLandmarksDAO;
import com.techelevator.landmarktours.model.LandmarksDAO;
import com.techelevator.landmarktours.model.Landmarks;

@Controller
@SessionAttributes({"landmarks", "landmarkListByItineraryId"})
public class HomeController {
	@Autowired
	private HotelsDAO hotelsDAO;
	@Autowired
	private LandmarksDAO landmarksDAO;
	@Autowired
	private ItineraryDAO itineraryDAO;

	
	public HomeController (HotelsDAO hotelsDAO, LandmarksDAO landmarksDAO, ItineraryDAO itineraryDAO) {
		this.landmarksDAO= landmarksDAO;
		this.hotelsDAO= hotelsDAO;
		this.itineraryDAO= itineraryDAO;
	}
	@RequestMapping(path={"/", "/landing"}, method=RequestMethod.GET)
	public String landingPage() {
		
		return "landing";
	}

	@RequestMapping(path={ "/home"}, method=RequestMethod.GET)
	public String showHomePage(Map<String, Object> model, HttpServletRequest request) {
		model.put("landmarks", landmarksDAO.getLandmarks());
		List <Hotels> hotelList= hotelsDAO.getHotels();
		request.setAttribute("hotelList", hotelList);
	
		return "home";
	}
	@RequestMapping(path={"/searchLandmarksByType"}, method=RequestMethod.GET)
	public String searchByType(Map<String, Object> model, HttpServletRequest request) {
		model.put("landmarks", landmarksDAO.getLandmarks());
		List <Hotels> hotelList= hotelsDAO.getHotels();
		request.setAttribute("hotelList", hotelList);
	
		return "searchLandmarksByType";
	}
	@RequestMapping(path={"/searchLandmarksByRadius"}, method=RequestMethod.GET)
	public String showHomePageCopy(Map<String, Object> model, HttpServletRequest request) {
		model.put("landmarks", landmarksDAO.getLandmarks());
		List <Hotels> hotelList= hotelsDAO.getHotels();
		request.setAttribute("hotelList", hotelList);
	
		return "searchLandmarksByRadius";
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
