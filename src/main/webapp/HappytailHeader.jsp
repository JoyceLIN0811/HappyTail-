<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link href="css/style39.css" rel="stylesheet">



</head>
<body>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>
	<script src='https://kit.fontawesome.com/a076d05399.js'></script>

	<script>
		function openNav() {
			document.getElementById("mySidenav").style.width = "250px";
		}

		function closeNav() {
			document.getElementById("mySidenav").style.width = "0";
		}
	</script>


	<nav class="navbar navbar-expand-lg navbar-light bg-white">
		<a class="navbar-brand" href="<c:url value='/HappyTailIndex.jsp'/> " style="display: block; margin: auto;">
			<img src="img/logo210_1905.png" width="210" height="210"
			style="display: block;margin-left: 110px">
		</a>
		<!-- <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
            aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button> -->
		<ul class="nav navbar-nav navbar-right navbar-top">
			<li>
				<c:if test="${empty LoginOK}">
				<a  href="<c:url value='login' />" title="登入"><i class='fas fa-user'
					style="font-size: 24px; color: rgba(0, 0, 0, 0.54); padding: 10px; margin-bottom: 170px;"></i></a>
				</c:if>
				<c:if test="${ !empty LoginOK}">
				<a  href="<c:url value='logoutCheck' />" title="登出"><i class='fas fa-user'
					style="font-size: 24px; color: rgba(0, 0, 0, 0.54); padding: 10px; margin-bottom: 170px;"></i></a>
				</c:if>
			</li>
			<li><a data-toggle="tab" href="#"><i class='fas fa-bell'
					style='font-size: 24px; color: rgba(0, 0, 0, 0.54); padding: 10px; margin-bottom: 170px;'></i>
			</a></li>
			<li><a class="right sidenav-trigger show-on-medium-and-up"
				data-target="side-nav" href="#"><i class="fa fa-align-justify"
					style="font-size: 24px; color: rgba(0, 0, 0, 0.54); padding: 10px; margin-bottom: 170px;"
					onclick="openNav()"></i> </a></li>


		</ul>
	</nav>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">

		<div class="collapse navbar-collapse" id="navbarNavDropdown">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link" href="<c:url value='/HappyTailIndex.jsp'/> " >Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#">About us</a>
				</li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#"
					id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"> Our Services </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
						<a class="dropdown-item" href="#">Online Shop</a> 
						<a class='dropdown-item' href="<c:url value='/Evaluationlist' />">Reservation Service</a> 
						<a class="dropdown-item" href="<c:url value='/forum/topiclist?pageSize=10&pageNum=1' />">Pet Forum</a>
					</div></li>
				<li class="nav-item"><a class="nav-link" href="#">Contact
						Us</a></li>
			</ul>
		</div>
		<form class="form-inline">
			<input class="form-control mr-sm-2" type="search"
				placeholder="Search" aria-label="Search">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		</form>
	</nav>

	<div id="mySidenav" class="sidenav">
		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
		<!-- <a href="#">About</a>
        <a href="#">Services</a>
        <a href="#">Clients</a>
        <a href="#">Contact</a> -->

		<span style="color: white; font-family: fantasy; font-size: 18px;"><img
			src="img/logo_white3.png">Happy Tail</span> 
			<a href="#home">Home</a>
			<a href="#notice">Notice</a>
		<c:if test="${!empty LoginOK}"> 
			<a href="<c:url value='memberCenter'/>">Personal Profile</a>
		</c:if>
		<c:if test="${empty LoginOK}"> 
			<a href="<c:url value='login'/>">Personal Profile</a>
		</c:if>
			<a href="#Online Shop">Online Shop</a> 
			<a href="#Reservation Service">Reservation	Service</a> 
			<a href="#Pet Forum">Pet Forum</a> 
			<a class="subheader">Learn About Us</a>

	</div>




</body>
</html>