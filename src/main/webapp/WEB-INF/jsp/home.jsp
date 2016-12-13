

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/header.jsp" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAHnTrqf_-ymPuHiz1UhbRUJCblHG2X3a8&callback=initMap&libraries=geometry"></script>
<!-- <script type="text/javascript">
        google.load("maps", "3",{other_params:"sensor=false&libraries=geometry"});
      </script> -->



<h3> Please Select Your Hotel as a Starting point</h3>

 <select id="address" name="address" placeholder="Columbus OH">
 <c:forEach var="hotelList" items="${hotelList}">
    	 	<option value="${hotelList.latitude}, ${hotelList.longitude}">${hotelList.name}</option>
 	   </c:forEach>
 </select>
 <select id="radius_km">
	 <option value=1>1 mile</option>
	 <option value=2>2 miles</option>
	 <option value=5>5 miles</option>
	 <option value=30>30 miles</option>
 </select>
     <b>Waypoints:</b> <br>
    <i>(Ctrl+Click or Cmd+Click for multiple selection)</i> <br>
<%--     <select multiple id="waypoints" name="landmarkId">
    <c:forEach var="landmarkList" items="${landmarks}">
    	 	<option value="${landmarkList.landmarkId}">${landmarkList.name}</option>
 	 </c:forEach>
    <select multiple id="waypoints" name="type">
    <c:forEach var="landmarkType" items="${landmarks}">
    	 	<option value="${landmarkType.type}">"${landmarkType.type}"</option>
 	 </c:forEach>
    </select> --%>
    <br>
 <button onClick="showCloseLocations()">Show Locations In Radius</button>

<div id="map_canvas" style="width: 500px; height: 350px; position: relative; background-color: rgb(229, 227, 223);">
    </div>
    <div>
  <form method="POST" action="${formAction}">
 	
   <div id="save Itinerary" style="float: left;" >
    <div>
    <div>
    	<b>Enter Name To Save Itinerary:</b><br>
    	 <input name="itineraryName" >
    </div>
    <b>Waypoints:</b> <br>
    <i>(Ctrl+Click or Cmd+Click for multiple selection)</i> <br>
    <select multiple id="waypoints" name="landmarkId">
    <c:forEach var="landmarkList" items="${landmarks}">
    	 	<option value="${landmarkList.landmarkId}">${landmarkList.name}</option>
 	 </c:forEach>
    </select>
    <br>
      <input type="submit" id="submit" value="Save Itinerary" >
    </div>      
	
    </div>
    </form>
    </div>
       <script>
       var map = null;
       var radius_circle = null;
       var markers_on_map = [];
       var geocoder = null;
       var infowindow = null;
       
       //all_locations is just a sample, you will probably load those from database
/*        var all_locations = [
     	  {type: "Restaurant", name: "Restaurant 1", lat: 40.723080, lng: -73.984340},
     	  {type: "School", name: "School 1", lat: 40.724705, lng: -73.986611},
     	  {type: "School", name: "School 2", lat: 40.724165, lng: -73.983883},
     	  {type: "Restaurant", name: "Restaurant 2", lat: 40.721819, lng: -73.991358},
     	  {type: "School", name: "School 3", lat: 40.732056, lng: -73.998683}
       ]; */
       //all_locations is just a sample, you will probably load those from database
       var z;
       var all_locations = [
     	 <c:forEach var="landmarkList" items="${landmarks}">
			{type: '${landmarkList.type}', name: '${landmarkList.name}', lat: ${landmarkList.latitude}, lng: ${landmarkList.longitude} },
		</c:forEach>
       ];



       //initialize map on document ready
       $(document).ready(function(){
           var latlng = new google.maps.LatLng(39.965741, -83.002793); 
           var myOptions = {
             zoom: 10,
             center: latlng,
             mapTypeControl: true,
             mapTypeControlOptions: {style: google.maps.MapTypeControlStyle.DROPDOWN_MENU},
             navigationControl: true,
             mapTypeId: google.maps.MapTypeId.ROADMAP
           };
           map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
     	  geocoder = new google.maps.Geocoder();
           google.maps.event.addListener(map, 'click', function(){
                if(infowindow){
                  infowindow.setMap(null);
                  infowindow = null;
                }
           });
       });
       
       function showCloseLocations() {
       	var i;
       	var radius_km = $('#radius_km').val();
       	var address = $('#address').val();

       	//remove all radii and markers from map before displaying new ones
       	if (radius_circle) {
       		radius_circle.setMap(null);
       		radius_circle = null;
       	}
       	for (i = 0; i < markers_on_map.length; i++) {
       		if (markers_on_map[i]) {
       			markers_on_map[i].setMap(null);
       			markers_on_map[i] = null;
       		}
       	}

       	if (geocoder) {
       		geocoder.geocode({'address': address}, function (results, status) {
       			if (status == google.maps.GeocoderStatus.OK) {
       				if (status != google.maps.GeocoderStatus.ZERO_RESULTS) {
       					var address_lat_lng = results[0].geometry.location;
       					radius_circle = new google.maps.Circle({
       						center: address_lat_lng,
       						radius: radius_km * 1000,
       						clickable: false,
     						map: map
       					});
                         if (radius_circle) map.fitBounds(radius_circle.getBounds());
       					for (var j = 0; j < all_locations.length; j++) {
       						(function (location) {
       							var marker_lat_lng = new google.maps.LatLng(location.lat, location.lng);
       							var distance_from_location = google.maps.geometry.spherical.computeDistanceBetween(address_lat_lng, marker_lat_lng); //distance in meters between your location and the marker
       							if (distance_from_location <= radius_km * 1000) {
       								var new_marker = new google.maps.Marker({
       									position: marker_lat_lng,
       									map: map,
       									title: location.name
       								});      								google.maps.event.addListener(new_marker, 'click', function () {
                                         if(infowindow){
                  infowindow.setMap(null);
                  infowindow = null;
                }
       									infowindow = new google.maps.InfoWindow(
                 { content: '<div style="color:red">'+location.name +'</div>' + " is " + distance_from_location + " meters from my location",
                   size: new google.maps.Size(150,50),
                   pixelOffset: new google.maps.Size(0, -30)
                 , position: marker_lat_lng, map: map});
       								});
       								markers_on_map.push(new_marker);
       							}
       						})(all_locations[j]);
       					}
       				} else {
       					alert("No results found while geocoding!");
       				}
       			} else {
       				alert("Geocode was not successful: " + status);
       			}
       		});
       	}
       }
       </script>
<!--  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAr5ShZL1BRiM_fdvx6wHIKpe48McMYqb8&callback=initMap">
 </script> -->

<c:import url="/WEB-INF/jsp/footer.jsp" />
		