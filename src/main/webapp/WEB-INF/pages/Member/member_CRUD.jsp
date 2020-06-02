<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員專區</title>
</head>
<body style="background-color: lightblue">

<jsp:include page="/top.jsp"></jsp:include>

<h2>會員專區</h2>

<h3>會員資料</h3>

<div style="border: 1px solid black; padding: 10px">
	
	<form action="<c:url value="memberUpdate" />" method="post" enctype="multipart/form-data">
		<table>
			<tr><td><input type="hidden" name="id" value = "${petMember.id }" /></td></tr>
				<tr>
					<td>Username :	</td>
					<td><input type="text" name="username" value = "${petMember.username }${param.username }" /></td>
					<td><font color='red' size="-1">${errorMsg.usernameError}</font></td>

				</tr>
				<tr>
					<td>Password :	</td>
					<td><input type="text" name="password" value= "${petMember.password }${param.password }" /></td>
					<td><font color='red' size="-1">${errorMsg.passwordError}</font></td>
				</tr>
<!-- 				<tr> -->
<!-- 					<td>Email :	</td> -->
<%-- 					<td><input type="text" name="email"  value= ${petMember.email } /></td> --%>

<!-- 				</tr> -->
				<tr>
					<td>Gender</td>
					<td>
						<input type="radio" name="gender" value="M" 
							<c:if test="${gender == true}">checked="checked"</c:if>					
						/>Man 					
						<input type="radio" name="gender" value="F" 
							<c:if test="${gender == false}">checked="checked"</c:if>
						/>Woman
					</td>
				</tr>
				<tr>
					<td>Birthday :	</td>
					<td><input type="date" name="bday"  value= "${petMember.bday }${param.bday  }" /></td>
					<td><font color='red' size="-1">${errorMsg.mBbday}</font></td>
				</tr>
				<tr>
					<td>Age :	</td>
					<td><input type="text" name="age"  value= "${petMember.age }${param.age }" /></td>
<%-- 					<td><font color='red' size="-1">${errorMsg.mAge}</font></td> --%>
				</tr>
				<tr>
					<td>Address :	</td>
					<td><input type="text" name="address" value= "${petMember.address }${param.address }" /></td>

				</tr>
				<tr>
					<td>Phone :	</td>
					<td><input type="text" name="phone" value="${petMember.phone }${param.phone }" /></td>

				</tr>
				<tr>
					<td>MemberImage</td>
					<td><input type="file" name="memberImage" /></td>


				</tr>				
			</table>
		<input type="submit" name="modify" value="修改會員資料">
	</form>
</div>
	<br>
<hr>
<a href="<c:url value='/index.jsp' />" >回首頁</a>
<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>