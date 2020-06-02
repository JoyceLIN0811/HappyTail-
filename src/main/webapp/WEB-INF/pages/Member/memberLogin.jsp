<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員登入</title>

<style type="text/css">	
	.divbig {
		width:800px;
		font-size: 1.5em;
		padding: 10px 30px;
		margin: 25px auto;
		font-family:微軟正黑體;}
	.lab{font-size: 0.8em;}	
	.ot{font-size: 0.85em;}
</style>

</head>
<body>
<jsp:include page="/top.jsp"></jsp:include>	
	
<div class="divbig">
	<h4>會員登入</h4>
	
		<form action="<c:url value="loginCheck" />" method="post">		
			<label class="lab">Account :</label>
				<input type="text" name="account"  value = "${param.account }"/>
				<font color='red' size="-1">${requestScope.ErrorMsg.accountError }</font>
			<br>
			<label class="lab">Password :</label> 	
				<input type="password" name="password"  value = "${param.password }"/>
				<font color='red' size="-1">${requestScope.ErrorMsg.passwordError }</font>			
				<font color='red' size="-1">${requestScope.ErrorMsg.LoginError }</font>
			<br>
			<a href="<c:url value='forgetPassword' />"><small>忘記密碼?</small></a><br>
			<a href="<c:url value='register' />"><small>還不是會員?</small></a><br><br>				
				
		<button class="ot" type="submit" name="login">登入</button>
	</form>
</div>

<jsp:include page="/footer.jsp"></jsp:include>

</body>
</html>