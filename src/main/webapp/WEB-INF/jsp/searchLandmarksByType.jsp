<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAHnTrqf_-ymPuHiz1UhbRUJCblHG2X3a8&cv=3.0&callback=initialize"></script> -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<!-- <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAHnTrqf_-ymPuHiz1UhbRUJCblHG2X3a8&callback=initMap">
</script> -->

<c:import url="/WEB-INF/jsp/header.jsp" /> 
       <script>
       var gmarkers1 = [];
       var markers1 = [];
       var infowindow = null;

       // Our markers
       markers1 = [
           ['0', 'Goodale Park', 39.975383, -83.004769, 'park'],
           <c:forEach var="landmarkList" items="${landmarks}">
  			['${landmarkList.type}', '${landmarkList.name}', ${landmarkList.latitude}, ${landmarkList.longitude}, '${landmarkList.type}' ],
  			</c:forEach>
       ];

       /**
        * Function to init map
        {
            content: ''
        }
        */

       function initialize() {
           var center = new google.maps.LatLng(39.965741, -83.002793);
           var mapOptions = {
               zoom: 11,
               center: center,
               mapTypeId: google.maps.MapTypeId.TERRAIN
           };
           
           map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
           for (i = 0; i < markers1.length; i++) {
               addMarker(markers1[i]);
           }
       }

       /**
        * Function to add marker to map
        */
       /*  var all_locations = [
        	 <c:forEach var="landmarkList" items="${landmarks}">
   			{type: '${landmarkList.type}', name: '${landmarkList.name}', lat: ${landmarkList.latitude}, lng: ${landmarkList.longitude} },
   			</c:forEach>
          ]; */

       function addMarker(marker) {
           var category = marker[4];
           var name = marker[1];
           var pos = new google.maps.LatLng(marker[2], marker[3]);
           var content = marker[1];

           marker1 = new google.maps.Marker({
               position: pos,
               category: category,
               map: map,
               title: name
           });

           gmarkers1.push(marker1);

           // Marker click listener
          // google.maps.event.addListener(marker1, 'click', (function (marker1, content) {
          google.maps.event.addListener(marker1, 'click', (function (marker1, content) {
                if(infowindow){
                  infowindow.setMap(null);
                  infowindow = null;
                }    
        	  return function () {
                   console.log('Gmarker 1 gets pushed');
                   infowindow = new google.maps.InfoWindow(
                      {content: '<div>'+marker1.name +'</div>' ,
                      category: marker1.category.category}),
                   infowindow.setContent(content);
                   infowindow.open(map, marker1);
                   map.panTo(this.getPosition());
                   map.setZoom(11);
               }
           })(marker1, content));
       }

       /**
        * Function to filter markers by category
        */

       filterMarkers = function (category) {
           for (i = 0; i < markers1.length; i++) {
               marker = gmarkers1[i];
               // If is same category or category not picked
               if (marker.category == category || category.length === 0) {
                   marker.setVisible(true);
               }
               // Categories don't match 
               else {
                   marker.setVisible(false);
               }
           }
       }

       // Init map
     //  initialize();
       </script>
<div>
<div id="map-canvas" style="width: 70%; height: 350px; position: relative; background-color: rgb(229, 227, 223);"></div>
<select id="type" onchange="filterMarkers(this.value);">
    <option value="">Please select category</option>
    <option value="Sports">sports</option>
    <option value="Museum">Museum</option>
    <option value="Theater">Theater</option>
    <option value="Shopping">Shopping</option>
    <option value="Entertainment">Entertainment</option>
	 <option value="Shopping">Shopping</option>
	 <option value="Restaurant">Restaurant</option>
</select>
</div>

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAHnTrqf_-ymPuHiz1UhbRUJCblHG2X3a8&cv=3.0&callback=initialize" async defer></script>
<c:import url="/WEB-INF/jsp/footer.jsp" />
