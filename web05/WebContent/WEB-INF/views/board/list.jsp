<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>List Page</h1>

<a href="/board/register"><h5>새글등록</h5> </a>
<style>
li { 
	list-style: none;
	margin-top: 0.5em;
	border: 1px dotted green;
	  
}
a { text-decoration:none } 

</style>
<ul>
<c:forEach items="${list}" var="board">
  <li>${board.bno}  <a href='/board/read?bno=${board.bno}&page=${pm.current}'><c:out value="${board.title}"></c:out>  </a> </li>
</c:forEach>
</ul>

<hr>

<style>
.paging { 
	display: flex;
	  
}
.paging li {
   margin: 0.5em;
   
   width: 3em;
   align-content: center;
   text-align: center;
   border-radius: 0.5em;
   font-weight: bold; 
   border: 0px;
 }
 
 .paging li.now {
   background-color: red;
 }
 
</style>
<img alt="" src="/img/test2.jpg">
<ul class='paging'>
  <c:if test="${pm.prev}">
  <li><a href='/board/list?page=${pm.start -1}'>이전</a></li>  
  </c:if>
  
  <c:forEach begin="${pm.start}" end="${pm.end}" var="step">
  <li class='${pm.current == step?"now":""}'>
    <a href='/board/list?page=${step}'>
    ${step}
    </a>
    </li>
  </c:forEach>
  
  <c:if test="${pm.next}">
  <li><a href='/board/list?page=${pm.end + 1 }'> 다음</a> </li>  
  </c:if>
</ul>

</body>
</html>