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

	<h1>modify/delete page</h1>
	<style>
li {list - style :none;	}
from {font - size :3em;}

input {
	border: 5px solid red; width 20em;
	border-radius: 10px;
	padding: .5em;
}
textarea {
	border: 5px solid orange; width 20em;
	border-radius: 10px;
}
</style>
	<ul>
		<li><input name="bno" readonly="readonly" value="${vo.bno }"></li>
		<li><input name="title" readonly="readonly" value='<c:out value = "${vo.title }"></c:out>'></li>
		<li><textarea rows="5" cols="30" name="content"> <c:out value="${vo.content }"></c:out> </textarea></li>
		<li><input name="writer" value='<c:out value = "${vo.writer }"></c:out>'></li>
	</ul>
	
	<form action="/board/remove" method = "post" target="zeroFrame">
		<input type = "hidden" name ="bno" value="${vo.bno}">
		<input type = "hidden" name ="page" value="${param.page}">
		<button>REMOVE</button> 
	</form>
	
	<iframe name ="zeroFrame" width = "0px" height ="0px"></iframe>

</body>
</html>