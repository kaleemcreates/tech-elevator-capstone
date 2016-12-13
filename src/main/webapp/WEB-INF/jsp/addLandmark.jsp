<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />


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
			messages: {
				name: {
					required: "Name is required",
					maxlength: "Name cannot be more that 64 characters"
				}, 
				type: {
					required: "Type is required"
				},
				zip: {
					required: "Zip code is required",
					maxlength: "Zip code cannot be more than 5 digits"
				}
				description: {
					required: "Description is required"
				}
			},
			
			errorClass : "error"
		});
	});
</script>


<h3>Suggest a Landmark</h3>
<c:url var="formAction" value="/addLandmark" />
<form method="POST" action="${formAction}">
<div class="form-group">
	<label for="name">Landmark Name</label>
	<input class="form-control" id= "name" name="name" placeholder="Landmark Name">
</div>
<div class="form-group">
	<label for="type">Landmark Type</label>
	<select class="form-control" name="type" id="type">
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
	<input class="form-control" id="zip" name="zip" placeholder="Landmark Zip Code">
</div>
<div class="form-group">
	<label for="description">Landmark Description</label>
	<textarea class="form-control" id="description" name="description" placeholder="Description goes here!"></textarea>
</div>

<div class="form-group">
	<input class="btn btn-primary" type="submit" value="Submit!">
</div>

</form>

<c:import url="/WEB-INF/jsp/footer.jsp" />