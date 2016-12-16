<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<c:url value="/css/firstPage.css" var="cssHref" />
<link rel="stylesheet" href="${cssHref}">

<body class="jumbotron" id="landing" class="img-responsive">
	<div class="container" class="img-responsive">




  <h1>ARCH CITY ADVENTURES</h1>
  <p></p>
  <c:url value="/home" var="home" />
  <p><a class="btn btn-primary btn-lg" href="${home}" role="button" class="img-responsive">Tour With Us</a></p>


</div>
</body>

		