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
		<p><strong><c:out value="${landmark.streetAddress}" /></strong>
		</br>
		<strong><c:out value="${landmark.city}, ${landmark.state} ${landmark.zip}" /></strong></p>
		<c:out value="${landmark.description}" />
		
		</br>
		</br>
		
		<h3>Landmark Feedback</h3>
		
		<c:url var="formResult" value="/landmarkDetail" /></c>
		<form action="${formResult}" method="POST">
			<div class="radio">
				<label>
					<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
					Thumbs up?
				</label>
			</div>
			<div class="radio">
				<label>
					<input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
					Thumbs down?
				</label>
			</div>
			<div class="form-group">
				<label for="landmarkFeedback">Landmark Feedback</label>
				<textarea class="form-control" id="feedback"  placeholder="Feedback goes here!"></textarea>
				
			</div>
			<div class="form-group">
			<input class="btn btn-primary" type="submit" value="Submit!">
			</div>
		</form>
	</div>
</body>
</html>

<c:import url="/WEB-INF/jsp/footer.jsp" />