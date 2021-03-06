<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Landmark Tours</title>
		<meta name="viewport" content="width=device-width">
		<meta name="description" content="Ca">
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	    <script src="http://cdn.jsdelivr.net/jquery.validation/1.15.0/jquery.validate.min.js"></script>
	    <script src="http://cdn.jsdelivr.net/jquery.validation/1.15.0/additional-methods.js "></script>
	    <script src="https://cdn.jsdelivr.net/jquery.timeago/1.4.1/jquery.timeago.min.js"></script>
	    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	    <c:url var="cssHref" value="/site.css" />
		<link rel="stylesheet" type="text/css" href="${cssHref}">
		
		<script type="text/javascript">
			$(document).ready(function() {
				$("time.timeago").timeago();
				
				$("#logoutLink").click(function(event){
					$("#logoutForm").submit();
				});
				
				var pathname = window.location.pathname;
				$("nav a[href='"+pathname+"']").parent().addClass("active");
				
			});
			
			
		</script>
		
		<script type="text/javascript">
    		$(document).ready(function() {
        		var newUrl = "";
        		$("#picksite").change(function() {
            		$newUrl = $("#picksite option:selected").val();
        		});
        		$("#executelink").click(function() {
            		location = $newUrl ;
        		});
    		});
		</script>
		
	</head>
	<body>
		<header class="header-site">
			<div class="row">
				<div class="col-md-9">
					<c:url var="homePageHref" value="/" />
					<c:url var="imgSrc" value="/img/landmarkTours.png" />
					<a href="${homePageHref}"><img src="${imgSrc}" class="img-responsive" /></a>
				</div>
				<div class="col-md-3">
				<form action="http://localhost:8080/capstone/addLandmark">
					<input type="submit" class="btn btn-primary" value="Select here to suggest a landmark!">
				</form>
				<br>
					<div class="dropdown">
			 				<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Select a landmark to view its page!<span class="caret"></span></button>
			 				<ul class="dropdown-menu">
				   				<li>
				   					<c:forEach var="landmark" items="${landmarks}">
				    					<a href="/capstone/landmarkDetail?landmark_id=${landmark.landmarkId}">${landmark.name}</a>
				    				</c:forEach>
				   				</li>
			 				</ul>
					</div>
				</div>
			</div>
			

			
		</header>
		<nav class="navbar navbar-default">
			<div class="container-fluid">	
				<ul class="nav nav-pills">
					<c:url var="homePageHref" value="/home" />
					<li role="presentation" class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="${homePageHref}" role="button" aria-haspopup="true" aria-expanded="false">Home
					<span class="caret"></span></a>
						<ul class="dropdown-menu">
						<c:url var="radiusSearchHref" value="/searchLandmarksByRadius" />
						<li><a href="${radiusSearchHref}">Search Landmarks by Radius</a></li>
						<c:url var="typeSearchHref" value="/searchLandmarksByType" />
						<li><a href="${typeSearchHref}">Search Landmarks by Type</a></li>
						</ul>
					</li>
					<c:url var="typeSearchHref" value="/searchLandmarksByType" />
 					<li><a href="${typeSearchHref}">Search Landmarks by Type</a></li>
					<c:choose>
						<c:when test="${ currentUser.admin}">
							<c:url var="dashboardHref" value="/users/${currentUser.userName}" />
							<li role="presentation"><a href="${dashboardHref}">Admin Account</a></li>
							<c:url var="newAdminHref" value="/users/${currentUser.userName}/adminLanding" />
							<li role="presentation"><a href="${newAdminHref}">Create/Edit Users</a></li>
							<c:url var="adminAddLandmarksHref" value="/users/${currentUser.userName}/adminAddLandmark" />
							<li role="presentation"><a href="${adminAddLandmarksHref}">Add Landmarks</a></li>
							<c:url var="changePasswordHref" value="/users/${currentUser.userName}/changePassword" />
							<li role="presentation"><a href="${changePasswordHref}">Change Password</a></li>

						</c:when>
						<c:when test="${not empty currentUser}">
							<c:url var="dashboardHref" value="/users/${currentUser.userName}" />
							<li role="presentation"><a href="${dashboardHref}">My Account</a></li>

							<c:url var="itinerary" value="/users/${currentUser.userName}/savedItineraryList" />
							<li role="presentation"><a href="${itinerary}">Saved Itinerary </a></li>
							<c:url var="sentMessagesHref" value="/users/${currentUser.userName}/search" />
							<li role="presentation"><a href="${searchLandmarks}">Search Landmarks</a></li>
							<c:url var="changePasswordHref" value="/users/${currentUser.userName}/changePassword" />
							<li role="presentation"><a href="${changePasswordHref}">Change Password</a></li>

							<!-- <li><a id="logoutLink" href="#">Log Out</a></li> -->
						</c:when>
					</c:choose>
				
				
				<ul class="nav navbar-nav navbar-right">
					
					<c:choose>
						<c:when test="${empty currentUser}">
							<c:url var="newUserHref" value="/users/new" />
							<li role="presentation"><a href="${newUserHref}">Sign Up</a></li>
							<c:url var="loginHref" value="/login" />
							<li role="presentation"><a href="${loginHref}">Log In</a></li>
						</c:when>
						<c:otherwise>
							<c:url var="logoutAction" value="/logout" />
							<li role="presentation"><a id="logoutLink" href="${logoutAction}">Log Out</a></li>
						</c:otherwise>
					</c:choose>
					</ul>

				</ul>
			</div>
		</nav>
		<div class="page">
 				<div class="row">
			<div class="col-md-4"></div>
				<div class="col-md-8"><c:if test="${not empty currentUser}">
					<p id="currentUser">Current User: ${currentUser.userName}</p>
				</c:if>
				</div>
		</div>
		</div>

		
		<div class="container">