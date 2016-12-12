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
		Thumbs up: ${thumbsUpCount}
		</br>
		Thumbs down: ${thumbsDownCount}
		
		<c:url var="imagehref" value="/img/${landmark.landmarkId}.jpg" />
		<img src="${imagehref}" class="img-responsive" alt="Responsive image">
		<h2><c:out value="${landmark.name}" /></h2>
		<p><strong><c:out value="${landmark.streetAddress}" /></strong>
		</br>
		<strong><c:out value="${landmark.city}, ${landmark.state} ${landmark.zip}" /></strong></p>
		<c:out value="${landmark.description}" />
		
		</br>
		</br>
		
		<c:if test="${not empty currentUser}">
		
		<h3>Landmark Feedback</h3>
		
		<c:url var="formResult" value="/landmarkDetail" /></c>
		<form action="${formResult}" method="POST">
		<input type="hidden" name="landmark_id" value="${param.landmark_id}" />
		<input type="hidden" name="userName" value="${currentUser.userName}" />
		
			<div class="radio">
				<label>
					<input type="radio" name="thumbsUp" id="optionsRadios1" value="true" checked>
					Thumbs up?
				</label>
			</div>
			<div class="radio">
				<label>
					<input type="radio" name="thumbsUp" id="optionsRadios2" value="false">
					Thumbs down?
				</label>
			</div>
			<div class="form-group">
				<label for="landmarkFeedback">Landmark Feedback</label>
				<textarea class="form-control" id="reviewText" name="reviewText" placeholder="Feedback goes here!"></textarea>
				
			</div>
			<div class="form-group">
			<input class="btn btn-primary" type="submit" value="Submit!">
			</div>
		</form>
		
		</c:if>
	</div>
	
	
	<c:if test="${not empty currentUser}">
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
					</div>
				</c:forEach>
					
		
		
			</div>
	</c:if>
	
</body>
</html>

<c:import url="/WEB-INF/jsp/footer.jsp" />