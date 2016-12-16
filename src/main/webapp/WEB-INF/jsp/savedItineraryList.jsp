<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>





<ul class="list-group" style="list-style-type:none">
  	
   <li class="list-group-item">Your Itinerary Name: <b>${list[0].itineraryName.toUpperCase()}</b> <li>
  	<c:forEach var="item" items="${list}">
  	<li class="list-group-item"><b><em>${item.landmarkName.toUpperCase()}</em></b><li>  	
	</c:forEach>

</ul>





<c:import url="/WEB-INF/jsp/footer.jsp" />
