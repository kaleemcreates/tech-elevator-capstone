
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/header.jsp" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>


<h3> Your Itinerary </h3>
	<div>
    <c:forEach var="itinerary" items="${itinerary}">
    	 	<ul>
    	 		<li>${itinerary.itineraryName}</li>
    	 	</ul>
 	</c:forEach>
 	   <c:forEach var="landmarks" items="${savedLandmarks}">
    	 	<ul>
    	 		<li>${landmarks.landmarkName}</li>
    	 		<li><img src="/img/${landmarks.landmarkId}.png"></li>
    	 		<li>${landmarks.descrtiption}</li>
    	 	</ul>
 	</c:forEach>
 	
	</div>
<c:import url="/WEB-INF/jsp/footer.jsp" />
		