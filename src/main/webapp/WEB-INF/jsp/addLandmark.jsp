<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<!DOCTYPE html>
<html>
<head>
<title>Add a Landmark</title>
</head>
<body>
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
	<label for="description">Landmark Description</label>
	<textarea class="form-control" id="descriptionText" name="descriptionText" placeholder="Description goes here!"></textarea>
</div>
<div class="form-group">
	<label for="zip">Landmark Name</label>
	<input class="form-control" id="zip" placeholder="Landmark Zip Code">
</div>
<div class="form-group">
	<input class="btn btn-primary" type="submit" value="Submit!">
</div>


</body>
</html>
<c:import url="/WEB-INF/jsp/footer.jsp" />