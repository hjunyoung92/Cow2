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

	<a href="/board/register"><h5>새글등록</h5></a>
	<style>
li {
	list-style: none;
	margin-top: 0.5em;
	border: 1px dotted green;
}

a {
	text-decoration: none
}
</style>
	<u1> <c:forEach items="${list}" var="board">
		<li>${board.bno }<a href='/board/read?bno=${board.bno }'><c:out
					value="${board.title }"></c:out></a></li>
	</c:forEach> </u1>

	<hr>
	<style>
.paging {
	display: flex;
}

.paging li {
	margin: 0.5em;
	background-color: orange;
	width: 3em;
	align-content: center;
	text-align: center;
	border-radius: 5px;
	font-weight: bold;
}
</style>

	<ul class="paging">
		<c:if test="${pm.prev }">
			<li>${pm.start - 1 }이전</li>
		</c:if>
		<c:forEach begin="${pm.start}" end="${pm.end }" var="step">
			<li>${step}</li>
		</c:forEach>
		<c:if test="${pm.next }">
			<li>${pm.start + 1 }다음</li>
		</c:if>
	</ul>
</body>
</html>