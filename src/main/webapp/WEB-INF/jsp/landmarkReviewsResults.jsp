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
			<div>
				<c:forEach var="landmarkReview" items="${reviewList}">
					<div>
					<h4><c:out value="${landmarkReview.userName} /></h4>
					</div>
				</c:forEach>
		
		
			</div>










	</div>
</body>
</html>

<c:import url="/WEB-INF/jsp/footer.jsp" />