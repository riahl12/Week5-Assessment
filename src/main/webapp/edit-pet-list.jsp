<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit An Existing Pet List</title>
</head>
<body>
<form action="editOwnerListDetailsServlet" method="post">
<input type="hidden" name="id" value="${listToEdit.id}">
List Name: <input type="text" name="listName" value="${listToEdit.listName}"><br/>

Owner First Name: <input type="text" name="firstName" value="${listToEdit.owner.firstName}">
Owner Last Name: <input type="text" name="lastName" value="${listToEdit.owner.lastName}"><br/>

Available Pets:<br/>

<select name="allItemsToAdd" multiple size="6">
<c:forEach items="${requestScope.allPets}" var="currentitem">
	<option value="${currentitem.petId}">${currentitem.petName} | ${currentitem.petSpecies}</option>
</c:forEach>
</select>
<br/>
<input type="submit" value="Edit Pet List and Add Pet">
</form>
<a href="index.html">Go add a new pet instead</a>
</body>
</html>