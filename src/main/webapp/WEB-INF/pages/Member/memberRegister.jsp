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

<style type="text/css">	
	.divbig {
		width:800px;
		font-size: 1.5em;
		padding: 10px 30px;
		margin: 25px auto;
		font-family:微軟正黑體; }
	.lab{font-size: 0.8em; }
	.ot{font-size: 0.85em;}
</style>

</head>
<body >
<jsp:include page="/HappytailHeader.jsp" />

<div class="divbig">
	<h4>會員註冊</h4>
	<form action="<c:url value="registerInsert" />" method="post" enctype="multipart/form-data">

		<label class="lab">Account :</label>
		<input type="text" name="account" placeholder="請輸入你的email" value="${param.account }"/>
		<font color='red' size="-1">${errorMsg.accountformatError}${errorMsg.accountIsExist}${errorMsg.accountError}</font>
	<br>			
		<label class="lab">Username :</label>
		<input type="text" name="username" value="${param.username }"/>
		<font color='red' size="-1">${errorMsg.usernameError}</font>
	<br>
		<label class="lab">Password :</label>
		<input type="password" name="password" value="${param.password }"/>
		<font color='red' size="-1">${errorMsg.passwordError}${errorMsg.passwordformatError}</font>				
		<small>密碼須同時包含小寫英文字母、大寫英文字母、數字和特殊符號</small>
	<br>												
		<label class="lab">Gender : </label>		
			<label class="lab"><input class="myradio" type="radio" name="gender" value="M" checked="checked"
			<c:if test="${gender == true}">checked="checked"</c:if>					
			/><span>Man</span></label>
					
			<label class="lab"><input class="myradio" type="radio" name="gender" value="F" 
			<c:if test="${gender == false}">checked="checked"</c:if>
			/><span>Woman</span></label>
		
	<br>
		<label class="lab">Birthday :</label>
		<input type="date" name="bday"  value="${param.bday }"/>
		<font color='red' size="-1">${errorMsg.mBbday}</font>
	<br>		
		<label class="lab">Age :</label>
		<input type="text" name="age"  value="${param.age }"/>
<%-- 	<td><font color='red' size="-1">${errorMsg.mAge}</font></td> --%>
	<br>		
		<label class="lab">Address :</label>
		<input type="text" name="address"  value="${param.address }"/>
	<br>
		<label class="lab">Phone :	</label>
		<input type="text" name="phone"  value="${param.phone }"/>
	<br>
		<label class="lab">MemberImage</label>
		<input class="ot" type="file" name="memberImage"  value="${param.memberImage }"/>
		<font color='red' size="-1">${errorMsg.noImage}</font>
	<br>		
		<input class="ot" type="submit" name="Submit" />
		
	</form>
</div>		
<jsp:include page="/HappytailFooter.jsp" />
	
</body>
</html>