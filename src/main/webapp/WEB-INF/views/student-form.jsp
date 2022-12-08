<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Form</title>
</head>
<body>
<sf:form action="process-student" modelAttribute="formStudent">
	First name: <sf:input path="firstName"/>
	Last name: <sf:input path="lastName"/><br>
	Email: <sf:input path="email" type="email"/>
	Date of Birth: <sf:input path="dateOfBirth" type="date"/><br>
	Gender: 
	<sf:radiobutton path="gender" value="Male" /> Male
	<sf:radiobutton path="gender" value="Female"/> Female
	<sf:button type="submit" value="Submit">Submit</sf:button>
	
	
</sf:form>
</body>
</html>