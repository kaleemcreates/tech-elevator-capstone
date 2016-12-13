<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />



<!DOCTYPE html>
<html>

<script type="text/javascript">
	$(document).ready(function () {
	
		$("form").validate({
			rules : {
				name : {
					required : true,
					maxlength: 64
				},
				type : {
					required : true
				},
				zip : {
					required : true,		
					maxlength : 5  
				},
				description : {
					required: true
				}
			},
			
			errorClass : "error"
		});
	});
</script>
<head>
<title>Add a Landmark</title>
</head>
<body>
<h3>Suggest a Landmark</h3>
<c:url var="formAction" value="/addLandmark" />
<form method="POST" action="${formAction}">
<div class="form-group">
	<label for="name">Landmark Name</label>
	<input class="form-control" id="name" placeholder="Landmark Name">
</div>
<div class="form-group">
	<label for="type">Landmark Type</label>
	<select class="form-control" id="type">
		<option>Entertainment</option>
		<option>Government</option>
		<option>Museum</option>
		<option>Park</option>
		<option>Restaurant</option>
		<option>Shopping</option>
		<option>Sports</option>
		<option>Theater</option>
	</select>
</div>
<div class="form-group">
	<label for="zip">Landmark Zip Code</label>
	<input class="form-control" id="zip" placeholder="Landmark Zip Code">
</div>
<div class="form-group">
	<label for="description">Landmark Description</label>
	<textarea class="form-control" id="descriptionText" name="descriptionText" placeholder="Description goes here!"></textarea>
</div>

<div class="form-group">
	<input class="btn btn-primary" type="submit" value="Submit!">
</div>

</form>
</body>
</html>
<c:import url="/WEB-INF/jsp/footer.jsp" />