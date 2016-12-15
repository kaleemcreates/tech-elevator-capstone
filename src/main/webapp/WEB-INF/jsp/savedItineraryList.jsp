<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>


<h1>Your Itinerary:</h1> ${itineraryName}
<c:forEach var="list" items="${list}">
	<ul>
		
		<li>${list.landmarkName}</li>
	
	</ul>

</c:forEach>






<c:import url="/WEB-INF/jsp/footer.jsp" />
