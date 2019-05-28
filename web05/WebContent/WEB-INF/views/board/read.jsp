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
  <h3>Read Page</h3>
  <style>
  li { list-style: none; }
  
  form {
    font-size: 2em;
  }
  
  input {
    border: 5px solid blue;
    width:20em;
    border-radius: 10px;
    padding: .5em;
  }
  textarea {
  	border: 5px solid blue;
  	width:20em;
  	border-radius: 10px;
  }
  </style>
  
  
  <ul>
    <li><input name="bno" readonly="readonly" value="${vo.bno }"></li>
    <li><input name="title" readonly="readonly" value='<c:out value="${vo.title}"></c:out>'></li>
    <li><textarea  rows="5" name="content"><c:out value="${vo.content}"></c:out></textarea></li>
    <li><input name="writer" value='<c:out value="${vo.writer}"></c:out>'></li>
  </ul>
  <a href="/board/list?page=${param.page}">목록으로</a>
  <a href="/board/modify?bno=${vo.bno}&page=${param.page} ">수정/삭제</a>
  
  
</body>
</html>




