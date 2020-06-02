<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員臨時登入頁面</title>
</head>
<body style="background-color: lightblue">

<jsp:include page="/top.jsp"></jsp:include>

<h2>會員臨時登入</h2>
	<form action="<c:url value="sendTemporaryPassword" />" method="post">
		<h3>請輸入您的 HappyTail 會員帳號 (您的email)</h3>
		<table>
			<tr>
				<td>Account :	</td>
				<td><input type="text" name="temporaryPasswordAccount"  value = "${param.temporaryPasswordAccount }"/></td>
				<td><font color='red' size="-1">${errorMsg.temporaryPasswordAccountError }</font></td>
				
			</tr>
			
		</table>
		<button  type="submit" name="sendTemporaryPassword">寄送臨時密碼</button>
	</form>

	<hr>
	<a href="<c:url value='/index.jsp' />">回首頁</a>
	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>