<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to URL Shortner</title>
</head>
<body>
	<h1 align="center">Tiny URL</h1>

	<form:form  modelAttribute="data" action="save-url" method="POST">
	<label>Enter your url</label>
	<form:input path="url"></form:input>
	</form:form>
</body>
</html>