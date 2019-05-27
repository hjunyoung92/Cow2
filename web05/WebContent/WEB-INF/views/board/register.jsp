<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Register page</h1>
	
	<form action="/board/register" method="post">
	<ul>
		<li><input name="title"></li>
		<li><input name="content"></li>
		<li><input name="writer"></li>
		
	</ul>
	<button>Save</button>
	</form>

</body>
</html>