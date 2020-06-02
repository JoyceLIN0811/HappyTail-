<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員註冊</title>

</head>
<body >
<%-- <jsp:include page="/top.jsp"></jsp:include> --%>

<h2>會員註冊</h2>

<div style="margin: 20px auto">
	<form action="<c:url value="registerInsert" />" method="post" enctype="multipart/form-data">

			<table>
				<tr>
					<td>Account :	</td>
					<td><input type="text" name="account" placeholder="請輸入你的email" value="${param.account }"/></td>
					<td><font color='red' size="-1">${errorMsg.accountformatError}${errorMsg.accountIsExist}${errorMsg.accountError}</font></td>
				</tr>					
				<tr>
					<td>Username :	</td>
					<td><input type="text" name="username" value="${param.username }"/></td>
					<td><font color='red' size="-1">${errorMsg.usernameError}</font></td>

				</tr>
				<tr>
					<td>Password :	</td>
					<td><input type="password" name="password" value="${param.password }"/></td>
					<td><font color='red' size="-1">${errorMsg.passwordError}${errorMsg.passwordformatError}</font></td>
				</tr>
				<tr><td></td><td colspan="3"><small>密碼須同時包含小寫英文字母、大寫英文字母、數字和特殊符號</small></td></tr>
				<tr>									
					<td>Gender</td>
					<td>
						<input type="radio" name="gender" value="M" checked="checked"
							<c:if test="${gender == true}">checked="checked"</c:if>					
						/>Man 
					
						<input type="radio" name="gender" value="F" 
							<c:if test="${gender == false}">checked="checked"</c:if>
						/>Woman
					</td>		
							
				</tr>
				<tr>
					<td>Birthday :	</td>
					<td><input type="date" name="bday"  value="${param.bday }"/></td>
					<td><font color='red' size="-1">${errorMsg.mBbday}</font></td>
				</tr>
				<tr>
					<td>Age :	</td>
					<td><input type="text" name="age"  value="${param.age }"/></td>
<%-- 					<td><font color='red' size="-1">${errorMsg.mAge}</font></td> --%>
				</tr>
				<tr>
					<td>Address :	</td>
					<td><input type="text" name="address"  value="${param.address }"/></td>

				</tr>
				<tr>
					<td>Phone :	</td>
					<td><input type="text" name="phone"  value="${param.phone }"/></td>

				</tr>
<!-- 				<tr> -->
<!-- 					<td>PetType :	</td> -->
<%-- 					<td><input type="text" name="petType"  value="${param.petType }"/></td> --%>

<!-- 				</tr> -->
				<tr>
					<td>MemberImage</td>
					<td><input type="file" name="memberImage"  value="${param.memberImage }"/></td>
					<td><font color='red' size="-1">${errorMsg.noImage}</font></td>
				</tr>
				<tr>
					<td><input type="submit" name="Submit" /></td>
				</tr>

			</table>
	</form>
	<hr>

	<a href="<c:url value='/index.jsp' />" >回首頁</a>

</div>
<%-- <jsp:include page="/footer.jsp"></jsp:include> --%>
	
<script type="text/javascript">
	
</script>	
	
</body>
</html>