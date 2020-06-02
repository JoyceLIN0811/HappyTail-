<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員登入</title>
</head>
<body>
<jsp:include page="/top.jsp"></jsp:include>

	<h2>會員登入</h2>
	<form action="<c:url value="loginCheck" />" method="post">
		<table>
			<tr>
				<td>Account :	</td>
				<td><input type="text" name="account"  value = "${param.account }"/></td>
				<td><font color='red' size="-1">${requestScope.ErrorMsg.accountError }</font></td>
				
			</tr>
			<tr>
				<td>Password : 	</td>
				<td><input type="password" name="password"  value = "${param.password }"/></td>
				<td><font color='red' size="-1">${requestScope.ErrorMsg.passwordError }</font></td>
				
			</tr>
			<tr><td colspan="3"><font color='red' size="-1">${requestScope.ErrorMsg.LoginError }</font></td></tr>
			<tr>
				<td>
					<a href="<c:url value='forgetPassword' />"><small>忘記密碼?</small></a><br>
					<a href="<c:url value='register' />"><small>還不是會員?</small></a>
				<td>
				
			</tr>
		</table>
		<button  type="submit" name="login">登入</button>
	</form>

	<hr>
	<a href="<c:url value='/index.jsp' />">回首頁</a>
<jsp:include page="/footer.jsp"></jsp:include>
<script>
	
</script>
</body>
</html>