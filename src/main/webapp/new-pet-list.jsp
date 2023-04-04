<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a new Pet List</title>
<script>
	function validateForm(){
		if(document.owner.listName.value == ""){
			alert("Please provide a name for your list!");
			document.owner.listName.focus();
			return false;
		}
		if(document.owner.firstName.value == ""){
			alert("Please enter a first name!");
			document.owner.firstName.focus();
			return false;
		}
		if(document.owner.lastName.value == ""){
			alert("Please enter a last name!");
			document.owner.lastName.focus();
			return false;
		}
		return(true);
	}
</script>
</head>
<body>
<form action="createNewPetListServlet" name="owner" onsubmit="return(validateForm());" method="post">
List Name: <input type="text" name="listName"><br/>
Owner First Name: <input type="text" name="firstName"><br/>
Owner Last Name: <input type="text" name="lastName"><br/>

Available Pets:<br/>
<select name="allPetsToAdd" multiple size="6">
<c:forEach items="${requestScope.allPets}" var="currentitem">
	<option value="${currentitem.petId}">${currentitem.petName} | ${currentitem.petSpecies}</option>
</c:forEach>
</select>
<br/>
<input type="submit" value="Create Pet List and Add new Pet">
</form>
<a href="index.html">Go add new pets instead</a>
</body>
</html>