<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />




<c:url var="formAction" value="/adminUser" />
<form method="POST" action="${formAction}">

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
<%-- 				<c:if test="${currentUser.admin}}"> --%>
    			<select name="role">
					<c:forEach items="user-role" var="id">
					    <option value="cityuser">cityuser</option>
					    <option value="admin">admin</option>
					</c:forEach>
<%-- 				</c:if> --%>
			</div>
			<div>

			</div>
			<button type="submit" class="btn btn-default">Create User</button>
		</div>

	</div>
</form>
		
<c:import url="/WEB-INF/jsp/footer.jsp" />