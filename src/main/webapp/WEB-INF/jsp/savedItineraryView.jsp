
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/header.jsp" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<c:url value="/css/landingPage.css" var="cssHref" />
<link rel="stylesheet" href="${cssHref}">

	<div>
	
	<center><h3> Your Confirmation Number is : <b>${itinerary.itineraryId }</b><br>
		Your Itinerary Name is: <b>${itinerary.itineraryName} </b><br></h3></center>
	
	<center><h1>Thank You For Saving Your Itinerary With Arch City Adventures!</h1></center>
	<br>

 	
	</div>

<c:import url="/WEB-INF/jsp/footer.jsp" />
		