<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyReservation</title>
</head>
<body>


	
	
	<H2>${petMembers.username}的預約<br>
	帳號 : ${petMembers.email}</H2>
	<table border="1">
	 <tr style="text-align:center">
	 	<td>寵物名稱</td>
	 	<td>服務項目</td>
	 	<td>需求</td>
	 	<td>預約日期</td>
	 	<td>預約時間</td>
	 	<td>金額</td>
	 	<td>預約狀態</td>
	<c:forEach varStatus="star" var="View" items="${page.records}">
	 <tr style="text-align:center" class='datalist'>
			<td>${View.petName}</td>
			<td>${View.serviceItem}</td>
			<td>${View.require}</td>
			<td>${View.createDate}</td>
			<td>${View.availableDateTime}:00</td>
			<td>${View.amount}</td>
			<td class='statuss'>${View.statuss}</td>
			<td>${View.id}</td>
			<td>
				<form style='float:left' method='post' action='update'>
				<input type="hidden" name='reservationId' value='${View.reservationId}'>
				<input class="reservation" type="submit" name='statuss' value="取消預約">
				</form>
				
				<form style='float:left' method='post' action='queryReservation' >
				<input type="hidden" name="reservationId" value="${View.reservationId}">
				<input class="point" type='submit' value='評分'  >
				</form>
			</td>
	</tr>
	</c:forEach>
	</tr>
	</table>


<form method="get" action="queryMyReservaitionView" style='float: left;margin-right: 10px '>
	<td>
<%-- 		<input type='hidden' name='Id' value='${page.Id}'> --%>
		<input type='hidden' name='pageNum' value='${page.currentPage-1}'>
		<input type='submit' value='上一頁'>
	</td>
</form>

<span style='float: left;margin-right: 10px;'>第  ${page.currentPage} 頁</span>

<form method="get" action="queryMyReservaitionView" >
	<td>
<%-- 		<input type='hidden' name='Id' value='${page.Id}'> --%>
		<input type='hidden' name='pageNum' value='${page.currentPage+1}'>
		<input type='submit' value='下一頁'>
	</td>
</form>

<div> 共 ${page.totalNum}筆</div>



<script type="text/javascript">
var datalist = document.getElementsByClassName("datalist");
console.log(datalist);

for(var i = 0 ; i < datalist.length ; i++){
	var statuss = datalist[i].getElementsByClassName("statuss")[0].innerHTML;
	if(statuss == "取消預約"){
	datalist[i].getElementsByClassName("point")[0].setAttribute("type","hidden");
	datalist[i].getElementsByClassName("reservation")[0].setAttribute("type","hidden");
	}
}
</script>




	<a href="<c:url value='Evaluationlist' />">上一頁</a>



</body>
</html>