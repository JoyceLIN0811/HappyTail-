<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML>

<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>shoppingCart</title>
<!-- &mdash;  這個是斜線-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description"
	content="Free HTML5 Website Template by gettemplates.co" />
<meta name="keywords"
	content="free website templates, free html5, free template, free bootstrap, free website template, html5, css3, mobile first, responsive" />
<meta name="author" content="gettemplates.co" />




<!-- Animate.css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/shopCss/animate.css">
<!-- Icomoon Icon Fonts-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/shopCss/icomoon.css">
<!-- Bootstrap  -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/2018css/bootstrap.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/shopCss/bootstrap.css">

<!-- Flexslider  -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/shopCss/flexslider.css">


<!-- Owl Carousel  -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/shopCss/owl.carousel.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/shopCss/owl.theme.default.min.css">

<!-- MDBootstrap Datatables  -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/shopCss/addons/datatables.min.css">

<!-- Theme style  -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/shopCss/style.css">

<!-- Modernizr JS -->
<script
	src="${pageContext.request.contextPath}/shopJs/modernizr-2.6.2.min.js"></script>
<script
	src="${pageContext.request.contextPath}/shopJs/jquery-1.12.2.min.js"></script>
<script src="${pageContext.request.contextPath}/shopJs/jquery-3.4.1.js"></script>
<script
	src="${pageContext.request.contextPath}/shopJs/jquery.easing.1.3.js"></script>
<!-- Bootstrap -->
<script src="${pageContext.request.contextPath}/shopJs/bootstrap.min.js"></script>
<%-- <script src="${pageContext.request.contextPath}/shopJs/bootstrap.min.js"></script> --%>
<!-- Waypoints -->
<script
	src="${pageContext.request.contextPath}/shopJs/jquery.waypoints.min.js"></script>
<!-- Carousel -->
<script
	src="${pageContext.request.contextPath}/shopJs/owl.carousel.min.js"></script>
<!-- countTo -->
<script
	src="${pageContext.request.contextPath}/shopJs/jquery.countTo.js"></script>
<!-- Flexslider -->
<script
	src="${pageContext.request.contextPath}/shopJs/jquery.flexslider-min.js"></script>

<!-- MDBootstrap Datatables  -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/shopJs/addons/datatables.min.js"></script>

<!-- Main -->
<script src="${pageContext.request.contextPath}/shopJs/main.js"></script>
<!-- FOR IE9 below -->
<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->

<script>
function confirmDelete(n) {
	if (confirm("確定刪除此項商品 ? ") ) {
		document.forms[0].action="<c:url value='UpdateItem.do?cmd=DEL&PetId=" + n +"' />" ;
		document.forms[0].method="POST";
		document.forms[0].submit();
	} else {
	
	}
}

function modify(key, amount, index) {
	var x = "newAmount" + index;
	var newAmount = document.getElementById(x).value;
	if  (newAmount < 0 ) {
		window.alert ('數量不能小於 0');
		return ; 
	}
	if  (newAmount == 0 ) {
		window.alert ("請執行刪除功能來刪除此項商品");
		document.getElementById(x).value = amount;
		return ; 
	}
	if  (newAmount == amount ) {
		window.alert ("數量相同，不必修改");
		return ; 
	} 
	if (confirm("確定將此商品的數量由" + amount + " 改為 " + newAmount + " ? ") ) {
		document.forms[0].action="<c:url value='UpdateItem.do?cmd=MOD&PetId=" + key + "&newAmount=" + newAmount +"' />" ;
		document.forms[0].method="POST";
		document.forms[0].submit();
	} else {
		document.getElementById(x).value = amount;
	}
}

function isNumberKey(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode
   if (charCode > 31 && (charCode < 48 || charCode > 57)){
      return false;
   }
   return true;
}

</script>
</head>
<body>
	<div id="page">
		<jsp:include page="shopTop.jsp" />
		<header id="fh5co-header"
			class="fh5co-cover fh5co-cover-sm text-center" role="banner">
			<div class='fh5co-contact'>
				<div class="container">
					<div class="row">

						<div class="col-md-3 col-md-push-1 animate-box">

							<div class="fh5co-contact-info">
								<h3 id="PetProduct">Pet Product</h3>
								<ul>
									<li class="icon-cake"><a href="#" id='cate1'>寵物食品</a>
										<form id="myform1" method="post" action="url"></form></li>
									<li class="icon-image"><a href="#" id='cate2'>寵物衣服</a></li>
									<li class="icon-game-controller"><a href="#" id='cate3'>寵物玩具</a></li>
									<li class="icon-shopping-cart"><a
										href="<c:url value='/intoCart'/> ">購物車</a></li>
									<li class="icon-game-controller"><a href="<c:url value='/OrderSureForm'/>"  id='cate4'>下一頁</a></li>
								</ul>
							</div>

						</div>


						<div class="col-8">
							<div align="center">
								<table id='dtBasicExample'
									class='table table-striped table-bordered '
									style="text-align: center">

									<thead>
										<tr>
											<th class="th-sm">商品名稱</th>
											<th class="th-sm">商品價格</th>
											<th class="th-sm">商品數量</th>
											<th class="borderA">價格小記</th>
											<th class="th-sm">修改/刪除</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach varStatus="vs" var="anEntry"
											items="${cart.content}">

											<TR height='16'>
												<td style="text-align: center;">${anEntry.value.name}</td>
												<td style="text-align: center;">${anEntry.value.unitPrice}</td>
												<td style="text-align: center;"><Input
													id="newAmount${vs.index}"
													style="width: 28px; text-align: right" name="newAmount"
													type="text"
													value="<fmt:formatNumber value="${anEntry.value.quantity}" />"
													name="amount" onkeypress="return isNumberKey(event)" /></td>
												<td style="text-align: right;"><fmt:formatNumber
														value="${anEntry.value.unitPrice * anEntry.value.quantity }"
														pattern="#,###" />元</td>
												<td style="text-align: center;"><Input type="button"
													name="update" value="修改"
													onclick="modify(${anEntry.key}, ${anEntry.value.quantity}, ${vs.index})">
													<Input type="button" name="delete" value="刪除"
													onclick="confirmDelete(${anEntry.key})"></td>
											</TR>



										</c:forEach>
									</tbody>
									<tfoot>
										<TR height='16'>
											<TD colspan='4' align='right' class="th-sm">合計金額：</TD>
											<TD align='center' class="th-sm"><fmt:formatNumber
													value="${cart.subtotal}" pattern="#,###,###" />元</TD>
										</TR>

									</tfoot>

								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</header>

	</div>
</body>
</html>