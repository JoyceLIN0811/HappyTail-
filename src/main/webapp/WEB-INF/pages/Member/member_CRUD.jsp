<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員專區</title>
</head>
<body>

<jsp:include page="/HappytailHeader.jsp" />
<div class="divbig">
	<h3>會員資料</h3><br>
	
	<form action="<c:url value="memberUpdate" />" method="post" enctype="multipart/form-data">
		<input type="hidden" name="id" value = "${petMember.id }" /></td></tr>
				
			<label class="lab">Username :</label>
			<input　class="inpu" type="text" name="username" value = "${petMember.username }${param.username }" />
			<font color='red' size="-1">${errorMsg.usernameError}</font>

				
			<label class="lab">Passwor :</label>
			<input　class="inpu" type="text" name="password" value= "${petMember.password }${param.password }" />
			<font color='red' size="-1">${errorMsg.passwordError}</font>
				
<!-- 				<tr> -->
<!-- 					<td>Email :	</td> -->
<%-- 					<td><input type="text" name="email"  value= ${petMember.email } /></td> --%>

<!-- 				</tr> -->
			
			<label class="lab">Gender</label>				
				<input type="radio" name="gender" value="M" 
							<c:if test="${gender == true}">checked="checked"</c:if>					
						/>Man 					
						<input type="radio" name="gender" value="F" 
							<c:if test="${gender == false}">checked="checked"</c:if>
						/>Woman
				
			<label class="lab">Birthday :</label>	
					<input type="date" name="bday"  value= "${petMember.bday }${param.bday  }" />
					<font color='red' size="-1">${errorMsg.mBbday}</font></td>
			
			<label class="lab">Age :</label>
					<input type="text" name="age"  value= "${petMember.age }${param.age }" />
<%-- 					<td><font color='red' size="-1">${errorMsg.mAge}</font></td> --%>
				
			<label class="lab">Address :</label>
					<input type="text" name="address" value= "${petMember.address }${param.address }" />

			<label class="lab">Phone :</label>
					<input type="text" name="phone" value="${petMember.phone }${param.phone }" />

			<label class="lab">MemberImage</label>
					<input type="file" name="memberImage" /></td>

		<input class="btn btn-info"　type="submit" name="modify" value="修改會員資料">
	</form>
</div>
	
<jsp:include page="/HappytailFooter.jsp" />
</body>
</html>