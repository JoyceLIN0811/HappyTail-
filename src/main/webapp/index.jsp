<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Happy Tail</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
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

	<%@ include file="top.jsp"%>
	<%-- 	<jsp:include page="top.jsp" /> --%>
	<section>
		<div id="carouselExampleCaptions" class="carousel slide"
			data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#carouselExampleCaptions" data-slide-to="0"
					class="active"></li>
				<li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
				<li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
			</ol>
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img <c:url value='/img/first.jpg'/> class="d-block w-100"
						alt="...">
					<div class="carousel-caption d-none d-md-block"
						style="margin-bottom: 130px; font-family: monospace;">
						<h1>
							Caring for <br>Your Furry <br>Friends
						</h1>

					</div>
				</div>
				<div class="carousel-item">
					<img <c:url value='/img/second.jpg'/> class="d-block w-100"
						alt="...">
					<div class="carousel-caption d-none d-md-block"
						style="margin-bottom: 130px; font-family: monospace;">
						<h1>
							Caring for <br>Your Furry <br>Friends
						</h1>
					</div>
				</div>
				<div class="carousel-item">
					<img <c:url value='/img/third.jpg'/> class="d-block w-100"
						alt="...">
					<div class="carousel-caption d-none d-md-block"
						style="margin-bottom: 130px; font-family: monospace;">
						<h1>
							Caring for <br>Your Furry <br>Friends
						</h1>
					</div>
				</div>
			</div>
			<a class="carousel-control-prev" href="#carouselExampleCaptions"
				role="button" data-slide="prev"> <span
				class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#carouselExampleCaptions"
				role="button" data-slide="next"> <span
				class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</section>
	<%@ include file="footer.jsp"%>

	<%-- 	<jsp:include page="footer.jsp" /> --%>


</body>
</html>