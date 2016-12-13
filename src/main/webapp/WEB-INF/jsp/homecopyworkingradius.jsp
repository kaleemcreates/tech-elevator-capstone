
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/header.jsp" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAHnTrqf_-ymPuHiz1UhbRUJCblHG2X3a8&callback&libraries=geometry"></script>
<!-- <script type="text/javascript">
        google.load("maps", "3",{other_params:"sensor=false&libraries=geometry"});
      </script> -->



<h3> Please Select Your Hotel as a Starting point</h3>

 <select id="address" name="address" placeholder="Columbus OH">
 <c:forEach var="hotelList" items="${hotelList}">
    	 	<option value="${hotelList.latitude}, ${hotelList.longitude}">${hotelList.name}</option>
 	   </c:forEach>
 </select>
<!--  <select id="type" onchange="filterMarkers(this.value);">
 	 <option value="">Please select category</option>
	 <option value="Sports">Sports</option>
	 <option value="Entertainment">Entertainment</option>
	 <option value="Shopping">Shopping</option>
	 <option value="Restaurant">Restaurant</option>
 </select> -->
<div ng-app="myApp">
    <div ng-controller="MapCtrl" ng-init="find()">
<div id="map_canvas" style="width-min: 300px; height: 350px; position: relative; background-color: rgb(229, 227, 223);">
    </div>
	<div>
        <select id="type" onchange="filterMarkers(this.value);">
            <option value="shopping">Please select category</option>
            <option value="Sports">Sports</option>
	 		<option value="Entertainment">Entertainment</option>
	 		<option value="Shopping">Shopping</option>
	 		<option value="Restaurant">Restaurant</option>
        </select>
    </div>
    </div>
    </div>
  <%-- <form method="POST" action="${formAction}">
 	
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
    </div> --%>
       <script>
/*         angular.module('myApp', [])
       .controller('MapCtrl', [
       '$scope', '$http', '$compile', 

    function ($scope, $http, $compile) {  */
       <c:set var="count" value="0" scope="page" />
    	  // $scope.find = function () {

           var gmarkers1 = [];
           var markers1 = [];
           var infowindow = new google.maps.InfoWindow({
               content: ''
           });

    	   // Our markers
    	   markers1 = [
    	       /* ['0', 'Madivala', 12.914494, 77.560381, 'car','as12'], */
			
    	       <c:forEach var="landmarkList" items="${landmarks}">
    	       <c:set var="count" value="${count + 1}" scope="page"/>
    	       [${count},'${landmarkList.name}', ${landmarkList.latitude}, ${landmarkList.longitude}, '${landmarkList.type}' ],
    	       </c:forEach>
    	   ];
    	   /**
            * Function to init map
            */

           function initialize() {
               var center = new google.maps.LatLng(12.9667, 77.5667);
               var mapOptions = {
                   zoom: 12,
                   center: center,
                   mapTypeId: google.maps.MapTypeId.TERRAIN
               };

               map = new google.maps.Map(document.getElementById('map_canvas'), mapOptions);
               for (i = 0; i < markers1.length; i++) {
                   addMarker(markers1[i]);
               }
           }

           /**
            * Function to add marker to map
            */

           function addMarker(marker) {
               var category = marker[4];
               var title = marker[1];
               var pos = new google.maps.LatLng(marker[2], marker[3]);
               var content = marker[1];
               var fullContent = marker.slice(1, 6).join();

               var marker1 = new google.maps.Marker({
                   title: title,
                   position: pos,
                   category: category,
                   map: map
               });

               gmarkers1.push(marker1);

               // Marker click listener
               google.maps.event.addListener(marker1, 'click', (function (marker1, idx, markers1) {
                   return function () {
                       console.log('Gmarker 1 gets pushed');
                       var compiled = '<div><div>' + markers1[idx][0] + ' </div><div>' + markers1[idx][1] + ' </div><div>' + markers1[idx][2] + ' </div><div><button id="' + markers1[idx][5] + '">Get</button></div></div>';
                       var infowindow = new google.maps.InfoWindow({
                           content: compiled
                       });
                       infowindow.open(map, marker1);
                       map.panTo(this.getPosition());
                       map.setZoom(11);
                   }
               })(marker1, i, markers1));
           }
           $(document.body).on('click', 'button', function () {
               console.log(this.id);
           });
           /**
            * Function to filter markers by category
            */

           filterMarkers = function (category) {
               for (i = 0; i < markers1.length; i++) {
                   marker = gmarkers1[i];
                   // If is same category or category not picked
                   if (marker.category.toLowerCase().indexOf(category.toLowerCase()) > -1 || category.length === 0) {
                       marker.setVisible(true);
                   }
                   // Categories don't match 
                   else {
                       marker.setVisible(false);
                   }
               }
               // Init map
               initialize();

        	   
    	   };
          
   
       </script>
<!-- <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAr5ShZL1BRiM_fdvx6wHIKpe48McMYqb8&callback=initMap">
 </script> -->

<c:import url="/WEB-INF/jsp/footer.jsp" />
		