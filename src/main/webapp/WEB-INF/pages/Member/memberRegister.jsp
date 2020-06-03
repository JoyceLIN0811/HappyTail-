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

<link href="css/style28.css" rel="stylesheet">
</head>
<body >
<jsp:include page="/HappytailHeader.jsp" />

<div class="divbig">
	<h3>會員註冊</h3><br>
	<form class="form" action="<c:url value="registerInsert" />" method="post" enctype="multipart/form-data">

		<label class="lab">Account :</label>
		<input class="inpu" name="account" placeholder="請輸入你的email" value="${param.account }"/>
		<font color='red' size="-1">${errorMsg.accountformatError}${errorMsg.accountIsExist}${errorMsg.accountError}</font>
	<br><br>			
		<label class="lab">Username :</label>
		<input class="inpu" type="text" name="username" value="${param.username }"/>
		<font color='red' size="-1">${errorMsg.usernameError}</font>
	<br><br>
		<label class="lab">Password :</label>
		<input class="inpu" type="password" name="password" value="${param.password }"/>
		<font color='red' size="-1">${errorMsg.passwordError}${errorMsg.passwordformatError}</font>				
	<br><small style="font">*密碼須同時包含小寫英文字母、大寫英文字母、數字和特殊符號</small>
	<br><br>												
		<label class="lab">Gender : </label>		
			<label class="lab"><input type="radio" name="gender" value="M" checked="checked"
			<c:if test="${gender == true}">checked="checked"</c:if>					
			/><span>  Man  </span></label>
					
			<label class="lab"><input type="radio" name="gender" value="F" 
			<c:if test="${gender == false}">checked="checked"</c:if>
			/><span>  Woman  </span></label>
		
	<br><br>
		<label class="lab">Birthday :</label>
		<input class="inpu" type="date" name="bday"  value="${param.bday }"/>
		<font color='red' size="-1">${errorMsg.mBbday}</font>
	<br><br>		
		<label class="lab">Age :</label>
		<input class="inpu" type="text" name="age"  value="${param.age }"/>
<%-- 	<td><font color='red' size="-1">${errorMsg.mAge}</font></td> --%>
	<br><br>		
		<label class="lab">Address :</label>
		<input class="inpu" type="text" name="address"  value="${param.address }"/>
	<br><br>
		<label class="lab">Phone :	</label>
		<input class="inpu" type="text" name="phone"  value="${param.phone }"/>
	<br><br>
		<label class="lab">MemberImage</label>
		<input class="inpu" class="ot" type="file" name="memberImage"  value="${param.memberImage }"/>
		<font color='red' size="-1">${errorMsg.noImage}</font>
	<br><br>		
		<input class="btn btn-info" type="submit" name="Submit" />
		
	</form>
</div>		
<jsp:include page="/HappytailFooter.jsp" />
	
</body>
</html>