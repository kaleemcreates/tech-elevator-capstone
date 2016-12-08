 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

  <c:import url="/WEB-INF/jsp/header.jsp" />  


  	 <div id="map_canvas" style="width: 500px; height: 300px; position: static; background-color: rgb(229, 227, 223);">
</div>
	  <h1> WELCOME TO SUPER CHEFS </h1>
   
    <script>
      var map;
      function initMap() {
        map = new google.maps.Map(document.getElementById('map_canvas'), {
          center: {lat: 40.054411, lng: -82.885274},
			zoom: 20
        });
      } 
    
   
 </script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhbicUDjW_BD72V_mIN4qF2GNH9RViFaM&callback=initMap"></script>
 
		
<c:import url="/WEB-INF/jsp/footer.jsp" />
		