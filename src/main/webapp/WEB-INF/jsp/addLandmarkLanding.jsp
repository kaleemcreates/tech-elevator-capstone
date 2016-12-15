
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/header.jsp" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<c:url value="/css/landingPage.css" var="cssHref" />
<link rel="stylesheet" href="${cssHref}">


<img src="css/Columbus.jpg" alt="Columbus">

	<div>
	
<%-- 	<h3> You have suggested the following landmark: <b>${landmarkSuggesiton.name}</b></h3> --%>
	
	<center><h1>Thank You For Suggesting a Landmark With Arch City Adventures!</h1></center> 
	<br>

 	
	</div>

<c:import url="/WEB-INF/jsp/footer.jsp" />
		