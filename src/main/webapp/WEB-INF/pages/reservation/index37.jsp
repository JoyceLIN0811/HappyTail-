<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

   <jsp:include page="/HappytailHeader.jsp" />
   
	<div id="carouselExampleFade" class="carousel slide carousel-fade"
		data-ride="carousel" style='z-index: 0'>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="img/first.jpg" class="d-block w-100" alt="...">
				<div class="carousel-caption d-none d-md-block">
					<h1>
						Caring for <br>Your Furry <br>Friends
					</h1>
					<!-- <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p> -->
				</div>
			</div>
			<div class="carousel-item">
				<img src="img/second.jpg" class="d-block w-100" alt="...">
				<div class="carousel-caption d-none d-md-block">
					<h1>
						Caring for <br>Your Furry <br>Friends
					</h1>
					<!-- <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p> -->
				</div>
			</div>
			<div class="carousel-item">
				<img src="img/third.jpg" class="d-block w-100" alt="...">
				<div class="carousel-caption d-none d-md-block">
					<h1>
						Caring for <br>Your Furry <br>Friends
					</h1>
					<!-- <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p> -->
				</div>
			</div>
		</div>



					<span style='border:#0000FF 1px double;'>
					<iframe src="https://www.google.com/maps/embed?pb=!1m18!m12!1m3!1d3615.2719630701636!2d121.53986731495814!3d25.02484298397663!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3442aa29379b8db9%3A0x6c7f37e71cce4568!2z6LOH562W5pyD!5e0!3m2!1szh-TW!2stw!4v1589437355016!5m2!1szh-TW!2stw" 
					width="750" height="450" aria-hidden="false" tabindex="0" >
					</iframe>
					</span>
					
					
					<form method='post' action='insertSuccess' onSubmit="return CheckForm();" style='border:#0000FF 1px double'>
						選擇服務 : <input type="radio" name='sortId' value="1"> 
						剪髮 <input type="radio" name='sortId' value="2"> 
						洗髮 <input type="radio" name='sortId' value="3"> 
						洗剪 <input type="radio" name='sortId' value="4"> 
						SPA<br> <br>
						寵物品種 : <input type="text" name='breed' required="required"><br><br>
						 寵物名稱 : <input type="text" name='petName' required="required"><br><br> 
						 寵物性別 : 
						 <input type="radio" name='petGenger' value="man">公 
						 <input type="radio" name='petGenger' value="girl">母 <br><br> 
						 寵物年紀 : <input type="number" min="1" name='petAge' required="required"><br><br>
						  預約日期 : <input type='date' min="2020-06-12" 
						  max="2020-12-31" name='createDate' required="required"><br><br>
						時間 : <select name='availableDateTime'>
									<option value='13'>13:00</option>
									<option value='14'>14:00</option>
									<option value='15'>15:00</option>
									<option value='16'>16:00</option>
									<option value='17'>17:00</option>
									<option value='18'>18:00</option>
									<option value='19'>19:00</option>
									<option value='20'>20:00</option>
									<option value='21'>21:00</option>
							</select><br> <br> 需求 : <input type="text" name='require'><br>
										<br> <input type="hidden" name='done' value='N'>
										<input type='hidden' name='evaluationStatus' value='未完成'>
										<input type="submit" name='statuss' value="預約"
											style="margin-left: 140px">
									</form>
								
		<!-- ./experience -->
		<script>
			function CheckForm() {

				if (confirm("預約成功") == true)
					return true;
				else
					return false;
			}
		</script>
		<br>
		<div class="section" id="evaluation">
		<div class="container">
			<div class="col-md-12">
				<h1 class="size-50">Evaluation</h1><br>
			</div>
			</div>
	</div>
	
	
			<div style="margin-left:150px;margin-right:20px;float:left">
				<h2 id='score'>${scoreAvg}</h2>
			</div>

			
<script >

var score = document.getElementById("score").innerHTML;
if(score <=1.4){ 
document.write('<img src="img/StarCopy.gif">');
}else if ( score > 1.5 && 2.4 >= score){ 
for (i=1; i<=2; i++) {
document.write('<img src="img/StarCopy.gif">');
}
}else if ( score > 2.5 && 3.4 >= score){ 
for (i=1; i<=3; i++) {
document.write('<img src="img/StarCopy.gif">');
}
}else if ( score > 3.5 && 4.4 >= score){ 
for (i=1; i<=4; i++) {
document.write('<img src="img/StarCopy.gif">');
}
}else if ( score > 4.5  && 5 >= score){ 
for (i=1; i<=5; i++) {
document.write('<img src="img/StarCopy.gif">');
}
}

</script>



			
			
			<div style='height:350px;white-space: nowrap;text-align: center;margin-top:50px;'>
			<marquee  direction="right" width="800px" >
			<c:forEach var="View" items="${Evaluation}" >
				
					<div style='border:2px #C3EADF solid;height:200px;width:300px;text-align: center;
					display: inline-block;white-space:normal;
					padding:20px;margin-right:20px;'>
						<h2 id='score2'>${View.score}分</h2>
						<hr style="width:150px;">
						<p>${View.content}</p>
					</div> 				
			</c:forEach>
			</marquee>
			</div>
		
		
		<jsp:include page="/HappytailFooter.jsp" />
</body>
</html>