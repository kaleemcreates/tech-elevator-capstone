<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/header.jsp" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<!--  <script type="text/javascript" src="http://www.google.com/jsapi"></script> -->
<!--       <script type="text/javascript">
        google.load("maps", "3", {other_params:"sensor=false&libraries=geometry&key='AIzaSyAr5ShZL1BRiM_fdvx6wHIKpe48McMYqb8'"});
      </script> -->
		  


<!--        <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhbicUDjW_BD72V_mIN4qF2GNH9RViFaM&callback=initMap" async defer>
       </script> -->

    


<h2>Welcome to Landmark Tours</h2>

<h3> Please Select Your Hotel as a Starting point</h3>

	

<!-- <div class="map_container">
  <div id="map" class="gmaps4rails_map"> -->
    <div id="map_canvas" style="width: 500px; height: 300px; position: static; background-color: rgb(229, 227, 223);">
    </div>
      

<!--   </div> 
</div> -->
<div>
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
				<select id="radius_km">
					 <option value=1>1km</option>
					 <option value=2>2km</option>
					 <option value=5>5km</option>
					 <option value=30>30km</option>
			 	</select>
			 	</div>
			 </div>
			</div>

		

</form>
 
			
			<button type="submit" class="btn btn-default">Enter Starting Point</button>
			<p> Then Use google APi </p>
		</div>
<!-- <div>
	<p> Stuff we need to implement
	origin: New York, NY
	destination: Boston, MA
	waypoints: optimize:true|Providence, RI|Hartford, CT
	mode: driving
	key: AIzaSyAr5ShZL1BRiM_fdvx6wHIKpe48McMYqb8
	</p>
</div> -->
<div>
	<form NAME="roundtrip" METHOD="get" ACTION="http://gebweb.net/optimap/index.php">
		<input NAME="loc0" TYPE="text" VALUE="39.965741,	-83.002793"/>
		<input NAME="loc1" TYPE="text" VALUE="39.965849,	-82.953303" />
		<input NAME="loc2" TYPE="text" VALUE="39.956723,	-83.003568" />
		<input NAME="loc3" TYPE="text" VALUE="39.969817,	-83.010041" />
		<input TYPE="submit" TYPE="text" VALUE="Submit" />
	</form>
</div>
<div>
	<form NAME="address" >
		<input NAME="address" TYPE="text" VALUE="Columbus, OH"/>
		<input TYPE="submit" TYPE="text" VALUE="Submit" />
	</form>
</div>

       <script>
       var map;
	       function initMap() {
	       map = new google.maps.Map(document.getElementById('map_canvas'), {
	       center: {lat: 39.9612, lng: -82.9988},
	       zoom: 10
	       });
       }
       </script>
 <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhbicUDjW_BD72V_mIN4qF2GNH9RViFaM&callback=initMap"></script>		
<c:import url="/WEB-INF/jsp/footer.jsp" />
		