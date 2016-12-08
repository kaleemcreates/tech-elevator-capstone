<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<script type="text/javascript">
	$(document).ready(function() {
		$("form").validate({
			debug: true,
			rules: {
				thumbsUp: {
					required: true
				}
			},
			messages: {
				thumbsUp: "Please choose thumbs up or thumbs down."
			},
			errorClass: "error",
			validClass: "valid"
		});	
	});
</script>

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
						<li><h4><c:out value="${review.thumbsUp}" /></h4></li>
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