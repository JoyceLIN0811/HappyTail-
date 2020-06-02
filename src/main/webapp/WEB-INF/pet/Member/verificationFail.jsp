<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>驗證失敗</title>
</head>
<body>
<h1>驗證失敗，請重新註冊會員</h1>

	<hr>

	<a href="<c:url value='/index.jsp' />" >回首頁</a>
</body>
</html>