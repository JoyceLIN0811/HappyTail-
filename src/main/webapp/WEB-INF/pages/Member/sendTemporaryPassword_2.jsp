<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員臨時登入頁面</title>

<link href="css/style28.css" rel="stylesheet">
</head>
<body>

<jsp:include page="/HappytailHeader.jsp" />
<div class="divbig">
<h3>會員臨時登入頁面</h3>	
	<form action="<c:url value="temporaryPasswordloginCheck" />" method="post">
	<br><br>
		<h5>請輸入您收到的臨時密碼 : </h5>
			<label class="lab">TemporaryPassword :</label>
			<input class="inpu" type="text" name="temporaryPassword"  value = "${param.temporaryPassword }"/>
			<br>
			<font color='red' size="-1">${requestScope.ErrorMsg.temporaryPasswordError }</font>
		<br><br>				
		<button class="btn btn-info" type="submit" name="sendTemporaryPassword">登入</button>
	</form>
</div>
<jsp:include page="/HappytailFooter.jsp" />
</body>
</html>