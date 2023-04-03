<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rendering Books</title>
</head>
<body>
	<p>Here is the book title: 
		<c:out value="${book.title}"/>
	</p>
	<p>
		<c:out value="${book.description}"/>
	</p>
	<p>
		<c:out value="${book.language}"/>
	</p>
	<p>
		<c:out value="${book.numberOfPages}"/>
	</p>
	
	

</body>
</html>