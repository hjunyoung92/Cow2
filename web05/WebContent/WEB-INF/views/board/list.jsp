<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>List page</h1>
	
	<a href="/board/register" ><h2>새글등록</h2></a>
	
	<u1>
	<c:forEach items="${list }" var="board">
	<li>${board.bno } ${board.title }</li>
	</c:forEach>
	</u1>
	
</body>
</html>