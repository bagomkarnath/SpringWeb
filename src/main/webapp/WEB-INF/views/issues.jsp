<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Issues List</title>
<style type="text/css">
.center {
  margin-left: auto;
  margin-right: auto;
}

table {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 60%;
}

table td, table th {
  border: 1px solid #ddd;
  padding: 8px;
}

table tr:nth-child(even){background-color: #f2f2f2;}

table tr:hover {background-color: #ddd;}

table th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}

button {
	background-color: #07AA8D;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}

button:hover {
	opacity: 0.8;
}

.form-content {
	background-color: #fefefe;
	margin: 5% auto 15% auto;
	width: 40%;
}

.alert {
  padding: 20px;
  background-color: #f44336;
  color: white;
  opacity: 1;
  transition: opacity 0.6s;
  margin-bottom: 15px;
  width: 40%;
  margin: auto;
}

.alert.success {background-color: #04AA6D;}
.alert.info {background-color: #2196F3;}
.alert.warning {background-color: #ff9800;}

.closebtn {
  margin-left: 15px;
  color: white;
  font-weight: bold;
  float: right;
  font-size: 22px;
  line-height: 20px;
  cursor: pointer;
  transition: 0.3s;
}

.closebtn:hover {
  color: black;
}
</style>
</head>
<body>
<c:if test="${message != null}">
	<div class="alert success">
  		<span class="closebtn">&times;</span>  
  		${message }
	</div>
</c:if>
<h2 align="center">Issue Dashboard</h2>
<table id="issuesTable" class="center">
<tr><th>ID</th><th>DESCRIPTION</th><th>STATUS</th><th>SEVERITY</th><th>Action</th></tr>
<c:forEach items="${issueList}" var="issue">
	<tr>
	<td>${issue.id }</td>
	<td>${issue.issueDescription }</td>
	<td>${issue.status }</td>
	<td>${issue.severity }</td>
	<td>
	<form action="close" method="post">
		<input type="hidden" value="${issue.id }" name="toBeDeletedIssueId"/>
		<button type="submit">Close</button>
	</form>
	<c:if test="${isAdmin}">
	<form action="resolve" method="post">
		<input type="hidden" value="${issue.id }" name="toBeResolvedIssueId"/>
		<button type="submit">Resolve</button>
	</form>
	</c:if>
	</td>
	</tr>
</c:forEach>
</table>
<form action="add-issue" method="post" class="form-content">
	<button type="submit">Raise a new Issue</button>
</form>
</body>
</html>