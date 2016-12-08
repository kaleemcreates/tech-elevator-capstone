<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<!DOCTYPE html>
<html>
<head>
<title>Landmark Reviews Results</title>
</head>
<body>

	<div>
		<h3>Landmark Feedback</h3>
			<div class="container">
				<c:forEach var="review" items="${reviewList}">
					<div>
					<ul class="list-inline">
						<li><h4><c:out value="${review.userName}" /></h4></li>
						<!-- DATE OUTPUT BELOW NOT WORKING -->
						<%-- <li><h4><c:out value="${formatter.format(review.createDate)}" /></h4></li> --%>
						<li><c:url var="imagehref" value="/img/${review.thumbsUp}.png" />
						<img src="${imagehref}" class="img-responsive" alt="Responsive image" width="40"></li>
					</ul>
					<ul>
						<li><c:out value="${review.reviewText}" /></li>
					</ul>
				
				</c:forEach>
					
		
		
			</div>


	</div>
</body>
</html>

<c:import url="/WEB-INF/jsp/footer.jsp" />