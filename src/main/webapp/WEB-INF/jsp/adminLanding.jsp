<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />
<c:url var="pwValidationSrc" value="/passwordValidation.js" />
<script src="${pwValidationSrc}"></script>

<script type="text/javascript">
	$(document).ready(function () {
	
		$("form").validate({
			rules : {
				password : {
					required : true,
					minlength : 10,
					maxlength : 128,
					complexPassword : true,
					noMoreThan2Duplicates : true
				},
				userName : {
					required : true
				},
				confirmPassword : {
					required : true,		
					equalTo : "#password"  
				}
			},
			messages : {			
				confirmPassword : {
					equalTo : "Passwords do not match"
				}
			},
			errorClass : "error"
		});
		
	});
</script>

<c:url var="formAction" value="/users" />
<head>
	<title>Create a New Administrator</title>
</head>
<body>
<h3>Create a New Administrator or City Visitor</h3>
<form method="POST" action="${formAction}">
	<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
	<div class="row">
		<div class="col-sm-6">	
			<div class="form-group">
				<label for="userName">User Name: </label>
				<input type="text" id="userName" name="userName" placeHolder="User Name" class="form-control" />
			</div>
			<div class="form-group">
				<label for="password">Password: </label>
				<input type="password" id="password" name="password" placeHolder="Password" class="form-control" />
			</div>
			<div class="form-group">
				<label for="confirmPassword">Confirm Password: </label>
				<input type="password" id="confirmPassword" name="confirmPassword" placeHolder="Re-Type Password" class="form-control" />	
			</div>
			<div class="form-group">
				<label for="role">User Role: </label>
				<select class="form-control" id="role">	
					<option>cityuser</option>
					<option>admin</option>
				</select>
			</div>
			<button type="submit" class="btn btn-default">Create User</button>
		</div>
		<div class="col-sm-6">
			<strong>Password Rules:</strong>
			<ul>
				<li>Must be at least 10 characters long</li>
				<li>Must contain at least 3 of the following 4 types of characters:
					<ol>
						<li>Uppercase letter (A-Z)</li>
						<li>Lowercase letter (a-z)</li>
						<li>Number (0-9)</li>
						<li>A "special" character (#, $, space, etc)</li>
					</ol>
				</li>
				<li>No more than two identical characters in a row</li>
			</ul>
		</div>
	</div>
</form>
<h3>Landmarks to Approve</h3>
<div>
Landmark Name: <c:out value="${landmarkSuggestion.name}" />
Landmark Type:<c:out value="${landmarkSuggestion.type}" />
Landmark Zip Code: <c:out value="${landmarkSuggestion.zip}" />
Landmark Description: <c:out value="${landmarkSuggestion.description}" />
<form action="http://localhost:8080/capstone/users/${currentUser.userName}/adminAddLandmark">
	<input type="submit" class="btn btn-primary" value="Click here to add this landmark to the database">
</form>
</div>
</body>
</html>
<c:import url="/WEB-INF/jsp/footer.jsp" />