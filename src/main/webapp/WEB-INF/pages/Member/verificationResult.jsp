<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Refresh" content="2; url= http://localhost:8080/happytail/">
<title>驗證結果通知</title>
</head>
<body>
<jsp:include page="/HappytailHeader.jsp" />
	<c:if test="${verificationResult == true}">
		<h1>驗證成功，會員帳號已啟用</h1>
	</c:if>	
	<c:if test="${verificationResult == false}">
		<h1>驗證失敗，請重新註冊會員</h1>
	</c:if>	

	<hr>

	<a href="<c:url value='/index.jsp' />" >回首頁</a>
	
<jsp:include page="/HappytailFooter.jsp" />
<script>
	
</script>

</body>
</html>