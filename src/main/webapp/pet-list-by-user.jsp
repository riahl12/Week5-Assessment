<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pet Lists</title>
</head>
<body>
<form method="post" action="listNavigationServlet">
	<table>
		<c:forEach items="${requestScope.allLists}" var="currentlist">
		<tr>
			<td><input type="radio" name="id" value="${currentlist.id}"></td>
			<td><h2>${currentlist.listName}</h2></td></tr>
			<tr><td colspan="3">Owner: ${currentlist.owner.firstName}, ${currentlist.owner.lastName}</td></tr>
			<c:forEach var="petVal" items = "${currentlist.listOfPets}">
				<tr><td></td><td colspan="3"> ${petVal.petName}, ${petVal.petSpecies}</td></tr>
			</c:forEach>
		</c:forEach>
	</table>
	<input type="submit" value="Edit" name="doThisToList">
	<input type="submit" value="Delete" name="doThisToList">
	<input type="submit" value="Add" name="doThisToList">
</form>
<a href="addItemsForListServlet">Create a new Pet List</a><br/>
<a href="index.html">Insert a new Pet</a>
</body>
</html>