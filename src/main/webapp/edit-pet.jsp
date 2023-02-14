<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit a Pet</title>
</head>
<body>
<h1>Please enter a new name or species:</h1>
	<form action="editPetServlet" method="post">
	Pet Name:<input type="text" name="petName" value="${petToEdit.petName}">
	Pet Species:<input type="text" name="petSpecies" value="${petToEdit.petSpecies}">
	<input type="hidden" name="id" value="${petToEdit.petId}">
	<input type="submit" value="Save Edited Pet">
	</form>
</body>
</html>