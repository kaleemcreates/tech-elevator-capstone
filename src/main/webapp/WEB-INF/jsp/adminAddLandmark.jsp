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
				placeId : {
					required : true,
					maxlength : 64
				},
				landmarkId : {
					required : true, 
					maxlength : 3
				},
				type : {
					required : true, 
					maxlength : 13
				},
				latitude : {
					required : true
				}, 
				longitude : {
					required : true
				},
				streetAddress : {
					required : true, 
					maxlength : 256
				},
				city : {
					required : true,
					maxlength : 32
				},
				state : {
					required : true, 
					maxlength : 2
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
				},
				description: {
					required: "Description is required"
				}
			},
			
			errorClass : "error"
		});
	});
</script>


<h3>Suggest a Landmark</h3>
<c:url var="formAction" value="/adminAddLandmark" />
<form method="POST" action="${formAction}">
<input type="hidden" name="suggestionId" value="${landmarkSuggestion.suggestionId}">
<div class="form-group">
	<label for="name">Landmark Name</label>
	<input class="form-control" id= "name" name="name" value="${landmarkSuggestion.name}">
</div>

<div class="form-group">
	<label for="placeId">Place Id</label>
	<input class="form-control" id="placeId" name="placeId" placeholder="Place Id">
</div>
<div class="form-group">
	<label for="landmarkId">Place Id</label>
	<input class="form-control" id="landmarkId" name="landmarkId" placeholder="Landmark Id">
</div>

<div class="form-group">
	<label for="type">Landmark Type</label>
	<input class="form-control" id="type" name="type" value="${landmarkSuggestion.type}">
<!-- 		<option>Entertainment</option>
		<option>Government</option>
		<option>Museum</option>
		<option>Park</option>
		<option>Restaurant</option>
		<option>Shopping</option>
		<option>Sports</option>
		<option>Theater</option>
	</select> -->
</div>
<div class="form-group">
	<label for="latitude">Latitude</label>
	<input class="form-control" id="latitude" name="latitude" placeholder="Latitude">
</div>

<div class="form-group">
	<label for="longitude">Longitude</label>
	<input class="form-control" id="longitude" name="longitude" placeholder="Longitude">
</div>

<div class="form-group">
	<label for="streetAddress">Street Address</label>
	<input class="form-control" id="streetAddress" name="streetAddress" placeholder="Street Address">
</div>

<div class="form-group">
	<label for="city">City</label>
	<input class="form-control" id="city" name="city" placeholder="City">
</div>

<div class="form-group">
	<label for="state">State</label>
	<select class="form-control" id="state" name="state">
		<option value="AL">Alabama</option>
		<option value="AK">Alaska</option>
		<option value="AZ">Arizona</option>
		<option value="AR">Arkansas</option>
		<option value="CA">California</option>
		<option value="CO">Colorado</option>
		<option value="CT">Connecticut</option>
		<option value="DE">Delaware</option>
		<option value="DC">District Of Columbia</option>
		<option value="FL">Florida</option>
		<option value="GA">Georgia</option>
		<option value="HI">Hawaii</option>
		<option value="ID">Idaho</option>
		<option value="IL">Illinois</option>
		<option value="IN">Indiana</option>
		<option value="IA">Iowa</option>
		<option value="KS">Kansas</option>
		<option value="KY">Kentucky</option>
		<option value="LA">Louisiana</option>
		<option value="ME">Maine</option>
		<option value="MD">Maryland</option>
		<option value="MA">Massachusetts</option>
		<option value="MI">Michigan</option>
		<option value="MN">Minnesota</option>
		<option value="MS">Mississippi</option>
		<option value="MO">Missouri</option>
		<option value="MT">Montana</option>
		<option value="NE">Nebraska</option>
		<option value="NV">Nevada</option>
		<option value="NH">New Hampshire</option>
		<option value="NJ">New Jersey</option>
		<option value="NM">New Mexico</option>
		<option value="NY">New York</option>
		<option value="NC">North Carolina</option>
		<option value="ND">North Dakota</option>
		<option value="OH">Ohio</option>
		<option value="OK">Oklahoma</option>
		<option value="OR">Oregon</option>
		<option value="PA">Pennsylvania</option>
		<option value="RI">Rhode Island</option>
		<option value="SC">South Carolina</option>
		<option value="SD">South Dakota</option>
		<option value="TN">Tennessee</option>
		<option value="TX">Texas</option>
		<option value="UT">Utah</option>
		<option value="VT">Vermont</option>
		<option value="VA">Virginia</option>
		<option value="WA">Washington</option>
		<option value="WV">West Virginia</option>
		<option value="WI">Wisconsin</option>
		<option value="WY">Wyoming</option>
	</select>
</div>
<div class="form-group">
	<label for="zip">Landmark Zip Code</label>
	<input class="form-control" id="zip" name="zip" value="${landmarkSuggestion.zip}">
</div>
<div class="form-group">
	<label for="description">Landmark Description</label>
	<input class="form-control" id="description" name="description" value="${landmarkSuggestion.description}">
</div>

<div class="form-group">
	<input class="btn btn-primary" type="submit" value="Submit!">
</div>

</form>

<c:import url="/WEB-INF/jsp/footer.jsp" />