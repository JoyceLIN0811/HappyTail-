<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pet Forum</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link href="css/Forum.css" rel="stylesheet">

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/mustache.js/3.1.0/mustache.min.js"></script>
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


</head>
<body>

	<jsp:include page="/HappytailHeader.jsp" />


<div class="container">
		<div class="row">
			<div class="col-sm-2" style="margin-top: 60px;">
				<div class="list-group" id="list-tab" role="tablist">
					<a class="list-group-item list-group-item-action active"
						data-toggle="list" href="<c:url value='/topic/topiclist'/>" role="tab"
						aria-controls="home">所有文章</a> 
					<a class="list-group-item list-group-item-action" data-toggle="list"
						href="<c:url value='/forum/topiclist?categoryId=1'/>" role="tab" aria-controls="profile">生活</a> 
					<a class="list-group-item list-group-item-action" data-toggle="list"
						href="<c:url value='/forum/topiclist?categoryId=2'/>" role="tab" aria-controls="messages">資訊</a> 
					<a class="list-group-item list-group-item-action" data-toggle="list"
						href="<c:url value='/forum/topiclist?categoryId=3'/>" role="tab" aria-controls="settings">新聞</a> 
					<a class="list-group-item list-group-item-action" data-toggle="list"
						href="<c:url value='/forum/topiclist?categoryId=4'/>" role="tab" aria-controls="settings">發問</a> 
					<a class="list-group-item list-group-item-action" data-toggle="list"
						href="<c:url value='/forum/topiclist?categoryId=5'/>" role="tab" aria-controls="settings">認養</a> 
					<a class="list-group-item list-group-item-action" data-toggle="list"
						href="<c:url value='/forum/topiclist?categoryId=6'/>" role="tab" aria-controls="settings">其他</a>
				</div>
			</div>
			<div class="col-sm-10">
				<blockquote class="blockquote" style="margin-top: 60px;">
					<p class="mb-0">總文章數量：<c:out value="${topiclist.totalCount}" default="0"></c:out></p>
				</blockquote>

				<div style="float: right;">
					<ul class="nav nav-pills">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
							role="button" aria-haspopup="true" aria-expanded="false">文章排序</a>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="<c:url value='/forum/topiclist?tagType=hit'/>">熱門</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="<c:url value='/forum/topiclist?tagType=createDate'/>">最新</a>
							</div></li>
					</ul>
				</div>
				
                <div class="card bg-dark text-white" style="max-width: 100%;">
                    <div class=" card-body">
                        <div class="row justify-content-around">

                            <div class="col-md-2"> <img src="<c:url value='/img/story2.png'/>" class="card-img" alt="..."></div>
                            <div class="col-md-2"> <img src="<c:url value='/img/story2.png'/>" class="card-img" alt="..."></div>
                            <div class="col-md-2"> <img src="img/story2.png" class="card-img" alt="..."></div>
                            <div class="col-md-2"> <img src="img/story2.png" class="card-img" alt="..."></div>
                            <div class="col-md-2"> <img src="img/story2.png" class="card-img" alt="..."></div>
                            <div class="col-md-2"> <img src="img/story2.png" class="card-img" alt="..."></div>
                        </div>
                    </div>
                </div>

				<article class="all-browsers">
					<article class="browser bg-transparent">
						<div class="card mb-3" style="max-width: 100%;">
						<c:forEach varStatus="star" var="aTopicBean"
								items="${topiclist.records}">
							<div class="card-body">
								<div class="row no-gutters">

									<div class="col-md-4">
										<p class="card-text">
											<img src="<c:url value='/img/foot.png'/>" class="card-img" alt="..."
												style="height: 30px; width: 40px;"> <span>${aTopicBean.username}</span>
										</p>
									</div>

									<div class="col-md-4">
										<p class="card-text">${aTopicBean.createDate}</p>
									</div>

									<div class="col-md-4">
										<p class="card-text">${aTopicBean.category}</p>
									</div>

								</div>
								<div class="row no-gutters">
									<div class="col-md-10">

										<div class="row no-gutters">
											<div class="col-md-12" style="height: 100px;">
												<h2 class="card-title">${aTopicBean.title}</h2>
											</div>
										</div>
										<div class="row no-gutters">
											<div class="col-md-3">
												<i class="far fa-thumbs-up fa-2x"></i> <span
													class="card-text">${aTopicBean.likeNum}</span>
											</div>
											<div class="col-md-3">
												<i class="far fa-comment-dots fa-2x"></i> <span
													class="card-text">${aTopicBean.replyNum}</span>
											</div>
											<div class="col-md-3">
												<i class="far fa-hand-point-up"></i><span
													class="card-text">${aTopicBean.count}</span>
											</div>
											<div class="col-md-3">
												<!-- <i class="fas fa-bookmark"></i> -->
												<i class="far fa-bookmark fa-2x"></i> <span
													class="card-text">FollowBtn</span>
											</div>

										</div>
									</div>
									<div class="col-md-2">
									<img src="${aTopicBean.imageUrl}" class="card-img" alt="...">
										<img src="<c:url value='/img/story2.png'/>" class="card-img" alt="...">
									</div>
								</div>
							</div>
						</c:forEach>
						</div>
					</article>
				</article>
			</div>
		</div>

	</div>
	<jsp:include page="/HappytailFooter.jsp" />

</body>

</html>