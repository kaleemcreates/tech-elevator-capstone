<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>


<h1>Your Itinerary: ${list[0].itineraryName}</h1>

<ul>
<c:forEach var="item" items="${list}">
		<li>${item.landmarkName}</li>
</c:forEach>
</ul>







<c:import url="/WEB-INF/jsp/footer.jsp" />
