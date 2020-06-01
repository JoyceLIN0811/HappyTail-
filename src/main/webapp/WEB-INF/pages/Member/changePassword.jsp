<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>變更密碼</title>
</head>
<body style="background-color: lightblue">

<h2>請重新設定您的密碼</h2>
	<form action="<c:url value="changePassword" />" method="post">
		<input type="hidden" name="id" value = "${sessionScope.LoginOK.id }" />		
		<table>
			<tr>
				<td>Password :	</td>
				<td><input type="text" name="password"  value = "${param.password }"/></td>
				<td><font color='red' size="-1">${errorMsg.password}</font></td>
				
			</tr>
			
		</table>
		<button  type="submit" name="changePassword">變更密碼</button>
	</form>	
	
</body>
</html>