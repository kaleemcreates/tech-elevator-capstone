<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<h2>Welcome to Landmark Tours</h2>

<h3> Please Select Your Hotel as a Starting point</h3>
<form method="POST" action="${formAction}">
	<div class="row">
		<div class="col-sm-6">	
			<div class="form-search">
				<label for="statingPoint">Hotel: </label></br>
					<input type="radio" id="Courtyard Columbus Downtown" name="startingPoint">Courtyard Columbus Downtown</input></br>
					<input type="radio" id="Homewood Suites by Hilton Polaris" name="startingPoint" />Homewood Suites by Hilton Polaris</input></br>
					<input type="radio" id="The Blackwell" name="startingPoint" />The Blackwell</input></br>
					<input type="radio" id="Hampton Inn & Suites University Area" name="startingPoint" />Hampton Inn & Suites University Area</input></br>
					<input type="radio" id="Drury Inn & Suites Columbus Convention Center" name="startingPoint" />Drury Inn & Suites Columbus Convention Center</input></br>
					</br>
			</div>
			
			<button type="submit" class="btn btn-default">Enter Starting Point</button>
			<p> Then Use google APi </p>
		</div>
		

</form>
		
<c:import url="/WEB-INF/jsp/footer.jsp" />
		