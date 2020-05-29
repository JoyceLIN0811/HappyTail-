<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<table border="1">
	<tr style="text-align:center">
		<td>序號</td>
		<td>預約人</td>
	 	<td>品種</td>
	 	<td>預約時間</td>
	 	<td>服務</td>
	 	<td>需求</td>
	 	<td>金額</td>
	 	<td>狀態</td>
	 	<td>完成</td>
	 	<td>評分</td>
	 	<td>評論</td>
	<c:forEach varStatus="star" var="View" items="${backView}">
	<tr style="text-align:center">
			<td>${View.reservationId}</td>
			<td>${View.username}</td>
			<td>${View.breed}</td>
			<td>${View.createDate}<br>${View.availableDateTime}:00</td>
			<td>${View.serviceItem}</td>
			<td>${View.require}</td>
			<td>${View.amount}</td>
			<td>${View.statuss}</td>
			<td>${View.done}</td>
			<td>${View.score}</td>
			<td>${View.content}</td>
	</tr>
	</c:forEach>
	</tr>
</table><br>

<a href="<c:url value='queryback' />"><input type="button" value='查詢全部'></a><br><br>

<form action="queryByDate" method="post">
選擇月份: <select name='createMonth'>
			<option value='2020-01'>1月</option>
			<option value='2020-02'>2月</option>
			<option value='2020-03'>3月</option>
			<option value='2020-04'>4月</option>
			<option value='2020-05'>5月</option>
			<option value='2020-06'>6月</option>
			<option value='2020-07'>7月</option>
			<option value='2020-08'>8月</option>
			<option value='2020-09'>9月</option>
			<option value='2020-10'>10月</option>
			<option value='2020-11'>11月</option>
			<option value='2020-12'>12月</option>
	    </select>
	    <input type="submit" value='查詢'>
</form>




</body>
</html>