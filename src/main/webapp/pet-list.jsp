<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pet List</title>
</head>
<body>
<h1>Current Pets in the list:</h1>
<form method="post" action="navigationServlet">
	<table>
	<c:forEach items="${allPets}" var="currentpet">
	<tr>
		<td><input type="radio" name="id" value="${currentpet.petId}"></td>
		<td>${currentpet.petName}</td>
		<td>${currentpet.petSpecies}</td>
	</tr>
	</c:forEach>
	</table>
	<input type="submit" value="Edit" name="doThisToItem">
	<input type="submit" value="Delete" name="doThisToItem">
	<input type="submit" value="Add" name="doThisToItem">
</form>
</body>
</html>