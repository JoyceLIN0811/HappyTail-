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
<h2>會員臨時登入</h2>
	<form action="<c:url value="temporaryPasswordloginCheck" />" method="post">
		<h3>臨時密碼已寄出，請輸入您收到臨時密碼</h3>
		<table>
			<tr>
				<td>TemporaryPassword :	</td>
				<td><input type="text" name="temporaryPassword"  value = "${param.temporaryPassword }"/></td>
				<td><font color='red' size="-1">${errorMsg.temporaryPasswordError }</font></td>
				
			</tr>
			
		</table>
		<button  type="submit" name="getTemporaryPassword">登入</button>
	</form>

	<hr>
	<a href="<c:url value='/index.jsp' />">回首頁</a>
</body>
</html>