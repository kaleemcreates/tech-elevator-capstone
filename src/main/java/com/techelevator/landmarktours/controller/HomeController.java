package com.techelevator.landmarktours.controller;

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.gargoylesoftware.htmlunit.javascript.host.geo.Geolocation;
import com.techelevator.landmarktours.model.Hotels;
import com.techelevator.landmarktours.model.HotelsDAO;
import com.techelevator.landmarktours.model.LandmarksDAO;
import com.techelevator.landmarktours.model.Landmarks;

@Controller
@SessionAttributes("landmarks")
public class HomeController {
	@Autowired
	private HotelsDAO hotelsDAO;
	
	@Autowired
	private LandmarksDAO landmarksDAO;

	@RequestMapping(path={"/", "/home"}, method=RequestMethod.GET)
	public String showHomePage(Map<String, Object> model, HttpServletRequest request) {
		model.put("landmarks", landmarksDAO.getLandmarks());
		List <Hotels> hotelList= hotelsDAO.getHotels();
		request.setAttribute("hotelList", hotelList);
	
		return "home";
	}
	
	@RequestMapping(path={"/", "/home"}, method=RequestMethod.POST)
	public String getSavedItinerary(Map<String, Object> model) {
		
	
		return "redirect: SavedItineraryView";
	}
	
	@RequestMapping(path={"/SavedItineraryView"}, method=RequestMethod.GET)
	public String showSavedItineraryView( HttpServletRequest request, @RequestParam String hotelStart,
												@RequestParam String landmarks,
												@RequestParam String hotelEnd) {
		List <String> list = new ArrayList<String>();
		
		String startPoint=request.getParameter("hotelStart");
		String[] landmarkStops= request.getParameterValues("landmarks");
		String endPoint= request.getParameter("hotelEnd");
			
		
		request.setAttribute("hotelStart", startPoint);
		request.setAttribute("landmarks", landmarks);
		request.setAttribute("hotelEnd", hotelEnd);
	
		return "SavedItineraryView";
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
