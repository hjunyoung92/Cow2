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
	<style>
li {list - style :none;
	
}
from {
font - size : 3em;
}
input {
	border: 5px solid red;
	width 20em;
	border-radius : 10px;
	padding : .5em;
}

textarea {
	border: 5px solid orange;
	width 20em;
	border-radius : 10px;
}
</style>
	<form action="/board/register" method="post">
		<ul>
			<li><input name="title" placeholder="제목을 입력하세요"></li>
			<li><textarea rows="5" cols="30" name="content"></textarea></li>
			<li><input name="writer"></li>

		</ul>
		<button>Save</button>
	</form>

</body>
</html>