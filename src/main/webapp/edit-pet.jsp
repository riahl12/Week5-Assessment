<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit a Pet</title>
<script>
	function validatePetForm(){
		if(document.pet.petName.value == ""){
			alert("Please enter the pets name!");
			document.pet.petName.focus();
			return false;
		}
		if(document.pet.petSpecies.value == ""){
			alert("Please enter the pets species!");
			document.pet.petSpecies.focus();
			return false;
		}
		return(true);
	}
</script>
</head>
<body>
<h1>Please enter a new name or species:</h1>
	<form action="editPetServlet" name="pet" onsubmit="return(validatePetForm());" method="post">
	Pet Name:<input type="text" name="petName" value="${petToEdit.petName}">
	Pet Species:<input type="text" name="petSpecies" value="${petToEdit.petSpecies}">
	<input type="hidden" name="id" value="${petToEdit.petId}">
	<input type="submit" value="Save Edited Pet">
	</form>
</body>
</html>