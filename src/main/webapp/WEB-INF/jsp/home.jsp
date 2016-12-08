<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/header.jsp" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>


<h2>Welcome to Landmark Tours</h2>

<h3> Please Select Your Hotel as a Starting point</h3>

<div id="map_canvas" style="width-min: 300px; height: 350px; position: relative; background-color: rgb(229, 227, 223);">
    </div>
    <div id="directions-panel"></div>
    <div id="right-panel" >
    <div>
    <b>Start:</b>
    <select id="start">
      <option value="39.965741,	-83.002793">Courtyard Columbus Downtown</option>
      <option value="40.143805,	-82.9618">Homewood Suites by Hilton Polaris</option>
      <option value="40.004871,	-83.016261">The Blackwell</option>
      <option value="40.025428,	-83.024906">Hampton Inn & Suites University Area</option>
    </select>
    <br>
    <b>Waypoints:</b> <br>
    <i>(Ctrl+Click or Cmd+Click for multiple selection)</i> <br>
    <select multiple id="waypoints">
      <option value="39.959651,	-83.00659">COSI</option>
      <option value="40.155399,	-83.109278">Columbus ZooT</option>
      <option value="40.157562,	-83.120654">Zoombezi Bay</option>
      <option value="39.941737,	-82.992176">Schiller Park</option>
      <option value="39.975383,	-83.004769">Goodale Park</option>
      <option value="39.962509,	-83.00198">LeVeque Tower</option>
      <option value="40.14147,	-82.978953">Polaris Fashion Place</option>
    </select>
    <br>
    <b>End:</b>
    <select id="end">
      <option value="39.965741,	-83.002793">Courtyard Columbus Downtown</option>
      <option value="40.143805,	-82.9618">Homewood Suites by Hilton Polaris</option>
      <option value="40.004871,	-83.016261">The Blackwell</option>
      <option value="40.025428,	-83.024906">Hampton Inn & Suites University Area</option>
    </select>
    <br>
      <input type="submit" id="submit">
    </div>      

    </div>
<!--   </div> 
</div> -->
<%-- <div>
<form method="POST" action="${formAction}">
	<div class="row">
		<div class="col-sm-6">	
			<div class="form-search">
<!-- 				<label for="statingPoint">Hotel: </label></br>
					<input type="radio" id="Courtyard Columbus Downtown" name="startingPoint">Courtyard Columbus Downtown</input></br>
					<input type="radio" id="Homewood Suites by Hilton Polaris" name="startingPoint" />Homewood Suites by Hilton Polaris</input></br>
					<input type="radio" id="The Blackwell" name="startingPoint" />The Blackwell</input></br>
					<input type="radio" id="Hampton Inn & Suites University Area" name="startingPoint" />Hampton Inn & Suites University Area</input></br>
					<input type="radio" id="Drury Inn & Suites Columbus Convention Center" name="startingPoint" />Drury Inn & Suites Columbus Convention Center</input></br>
					</br> -->
 
				<script type="text/javascript">
    				var miles = ['1 mile','2 mile','10 mile','25 mile'];
   					var types = ['Sports', 'Museum', 'Entertainment', 'Park', 'Shopping', 'Theater', 'Government', 'Restaurant'];
    					function setSelect(v) {
       						var x = document.getElementById("mile");
        						for (i = 0; i < x.length; ) { 
            						x.remove(x.length -1);
        						}
       						var a;
						        if (v=='milesdd'){
						            a = miles;
						        } else if (v=='typesdd'){
						            a = types
						        }
						        for (i = 0; i < a.length; ++i) {
						            var option = document.createElement("option");
						            option.text = a[i];
						            x.add(option);
						        }
						    }
						    function load() {
						        setSelect('milesdd');
						    }
						    window.onload = load;
						
						</script>
					<input type="radio" name="bb" value="milesearch"   onclick="setSelect('milesdd')" checked > Radius Search <br>
					<input type="radio" name="bb" value="typesearch" onclick="setSelect('typesdd')" > Type Search <br>
					<label>Search Option</label>
				<select name="mile" id="mile" style="color: #8E9092; /*height: 38px;width: 228px;*/"  >
				</select>
				<select id="radius_m">
					 <option value=1>1 mile</option>
					 <option value=2>2 mile</option>
					 <option value=5>5 mile</option>
					 <option value=25>25 mile</option>
			 	</select>
			 	</div>
			 </div>
			</div>

		

</form>
 
			
			<button type="submit" class="btn btn-default">Enter Starting Point</button>
			<p> Then Use google APi </p>
		</div> --%>
<!-- <div>
	<p> Stuff we need to implement
	origin: New York, NY
	destination: Boston, MA
	waypoints: optimize:true|Providence, RI|Hartford, CT
	mode: driving
	key: AIzaSyAr5ShZL1BRiM_fdvx6wHIKpe48McMYqb8
	</p>
</div> -->


       <script>
       function initMap() {
         var directionsService = new google.maps.DirectionsService;
         var directionsDisplay = new google.maps.DirectionsRenderer;
         var map = new google.maps.Map(document.getElementById('map_canvas'), {
           zoom: 10,
           center: {lat: 39.965741, lng: -83.002793}
         });
         directionsDisplay.setMap(map);

         document.getElementById('submit').addEventListener('click', function() {
           calculateAndDisplayRoute(directionsService, directionsDisplay);
         });
       }
       var widgetDiv = document.getElementById('save-widget');
       map.controls[google.maps.ControlPosition.TOP_LEFT].push(widgetDiv);

       // Append a Save Control to the existing save-widget div.
       var saveWidget = new google.maps.SaveWidget(widgetDiv, {
         place: {
           // ChIJN1t_tDeuEmsRUsoyG83frY4 is the place Id for CourtYard.
           placeId: 'ChIJyY9c6S-POIgRlMVLdUiH6Cc',
           location: {lat: -33.866647, lng: 151.195886}
         },
         attribution: {
           source: 'Google Maps JavaScript API',
           webUrl: 'https://developers.google.com/maps/'
         }
       });

       var marker = new google.maps.Marker({
         map: map,
         position: saveWidget.getPlace().location
       });
       function calculateAndDisplayRoute(directionsService, directionsDisplay) {
         var waypts = [];
         var checkboxArray = document.getElementById('waypoints');
         for (var i = 0; i < checkboxArray.length; i++) {
           if (checkboxArray.options[i].selected) {
             waypts.push({
               location: checkboxArray[i].value,
               stopover: true
             });
           }
         }

         directionsService.route({
           origin: document.getElementById('start').value,
           destination: document.getElementById('end').value,
           waypoints: waypts,
           optimizeWaypoints: true,
           travelMode: 'DRIVING'
         }, function(response, status) {
           if (status === 'OK') {
             directionsDisplay.setDirections(response);
             var route = response.routes[0];
             var summaryPanel = document.getElementById('directions-panel');
             summaryPanel.innerHTML = '';
             // For each route, display summary information.
             for (var i = 0; i < route.legs.length; i++) {
               var routeSegment = i + 1;
               summaryPanel.innerHTML += '<b>Route Segment: ' + routeSegment +
                   '</b><br>';
               summaryPanel.innerHTML += route.legs[i].start_address + ' to ';
               summaryPanel.innerHTML += route.legs[i].end_address + '<br>';
               summaryPanel.innerHTML += route.legs[i].distance.text + '<br><br>';
             }
           } else {
             window.alert('Directions request failed due to ' + status);
           }
         });

       }
       </script>
 <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAr5ShZL1BRiM_fdvx6wHIKpe48McMYqb8&callback=initMap">
 </script>
<c:import url="/WEB-INF/jsp/footer.jsp" />
		