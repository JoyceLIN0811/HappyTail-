<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員專區</title>
<link href="css/style28.css" rel="stylesheet">
</head>
<body>

<jsp:include page="/HappytailHeader.jsp" />
<div class="divbig">
	<h3>會員資料</h3><br>
	
	<form class="form" action="<c:url value="memberUpdate" />" method="post" enctype="multipart/form-data">
		<input type="hidden" name="id" value = "${petMember.id }" />				
		
		<label class="lab">Username :</label>
		<input class="inpu" type="text" name="username" value = "${petMember.username }${param.username }" />
		<font color='red' size="-1">${errorMsg.usernameError}</font>
<br><br>
		<label class="lab">Passwor :</label>
		<input class="inpu" type="text" name="password" value= "${petMember.password }${param.password }" />
		<font color='red' size="-1">${errorMsg.passwordError}${errorMsg.passwordformatError}</font>
		<br><small style="font">*密碼須同時包含小寫英文字母、大寫英文字母、數字和特殊符號</small>		
<!-- 				<tr> -->
<!-- 					<td>Email :	</td> -->
<%-- 					<td><input type="text" name="email"  value= ${petMember.email } /></td> --%>

<!-- 				</tr> -->
<br><br>			
		<label class="lab">Gender</label>				
		<input type="radio" name="gender" value="M" 
			<c:if test="${gender == true}">checked="checked"</c:if>					
			/>Man 					
		<input type="radio" name="gender" value="F" 
			<c:if test="${gender == false}">checked="checked"</c:if>
			/>Woman
<br><br>				
		<label class="lab">Birthday :</label>	
		<input class="inpu" type="date" name="bday"  value= "${petMember.bday }${param.bday  }" />
		<font color='red' size="-1">${errorMsg.mBbday}</font>
<br><br>			
		<label class="lab">Age :</label>
		<input class="inpu" type="text" name="age"  value= "${petMember.age }${param.age }" />
<%-- 		<td><font color='red' size="-1">${errorMsg.mAge}</font></td> --%>
<br><br>				
		<label class="lab">Address :</label>
		<input class="inpu" type="text" name="address" value= "${petMember.address }${param.address }" />
<br><br>
		<label class="lab">Phone :</label>
		<input class="inpu" type="text" name="phone" value="${petMember.phone }${param.phone }" />
<br><br>
		<label class="lab">MemberImage</label>
		<input class="inpu" type="file" name="memberImage" />
<br><br>
		<input class="btn btn-info" type="submit" name="modify" value="修改會員資料">
	</form>
</div>
	
<jsp:include page="/HappytailFooter.jsp" />
</body>
</html>