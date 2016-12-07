<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<!DOCTYPE html>
<html>
<head>
<title>Landmark Detail</title>
</head>
<body>
	<div id="main-content">
		<h1>Landmark Detail</h1>
		<c:url var="imagehref" value="/img/${landmark.landmarkId}.jpg" />
		<img src="${imagehref}" class="img-responsive" alt="Responsive image">
		
		<h2><c:out value="${landmark.name}" /></h2>
		
		<h3><c:out value="${landmark.streetAddress}" /></h3>
		<h3><c:out value="${landmark.city}, ${landmark.state} ${landmark.zip}" /></h3>
		
		
		<c:out value="${landmark.description}" />
	
	
	</div>
</body>
</html>

<c:import url="/WEB-INF/jsp/footer.jsp" />