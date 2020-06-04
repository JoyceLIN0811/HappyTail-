<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pet Forum</title>
<%@include file="/WEB-INF/pages/include/coreLibrary.jsp"%>

<link href="<c:url value="/css/Forum.css"/> " rel="stylesheet">

</head>
<body>

	<%@include file="/HappytailHeader.jsp"%>

	<div class="container">

		<div class="row">
			<div class="col-sm-2" style="margin-top: 60px;">
				<div class="list-group" id="list-tab" role="tablist">
					<a class="list-group-item list-group-item-action active"
						data-toggle="list" href="<c:url value='/topic/topiclist'/>"
						role="tab" aria-controls="home">所有文章</a> <a
						class="list-group-item list-group-item-action" data-toggle="list"
						href="<c:url value='/forum/topiclist?categoryId=1'/>" role="tab"
						aria-controls="profile">生活</a> <a
						class="list-group-item list-group-item-action" data-toggle="list"
						href="<c:url value='/forum/topiclist?categoryId=2'/>" role="tab"
						aria-controls="messages">資訊</a> <a
						class="list-group-item list-group-item-action" data-toggle="list"
						href="<c:url value='/forum/topiclist?categoryId=3'/>" role="tab"
						aria-controls="settings">新聞</a> <a
						class="list-group-item list-group-item-action" data-toggle="list"
						href="<c:url value='/forum/topiclist?categoryId=4'/>" role="tab"
						aria-controls="settings">發問</a> <a
						class="list-group-item list-group-item-action" data-toggle="list"
						href="<c:url value='/forum/topiclist?categoryId=5'/>" role="tab"
						aria-controls="settings">認養</a> <a
						class="list-group-item list-group-item-action" data-toggle="list"
						href="<c:url value='/forum/topiclist?categoryId=6'/>" role="tab"
						aria-controls="settings">其他</a>
				</div>
			</div>
			<div class="col-sm-10" style="margin-top: 60px;">
				<div class="row">

					<div class="col-sm-2">
						<blockquote class="blockquote">
							<span class="mb-0">總文章數量：<span id="totalNum"></span></span>

						</blockquote>
					</div>

					<div class="col-sm-8"></div>

					<div class="col-sm-2">
						<ul class="nav nav-pills">
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
								role="button" aria-haspopup="true" aria-expanded="false">文章排序</a>
								<div class="dropdown-menu">
									<a class="dropdown-item" href="#">熱門</a>
									<div class="dropdown-divider"></div>
									<a class="dropdown-item" href="#">最新</a>
								</div></li>
						</ul>
					</div>
				</div>

				<div class="row justify-content-around">

					<div class=" col-md-2">
						<img src="<c:url value='/img/story2.png'/>" class="card-img"
							alt="...">
					</div>
					<div class="col-md-2">
						<img src="<c:url value='/img/story2.png'/>" class="card-img"
							alt="...">
					</div>
					<div class="col-md-2">
						<img src="<c:url value='/img/story2.png'/>" class="card-img"
							alt="...">
					</div>
					<div class="col-md-2">
						<img src="<c:url value='/img/story2.png'/>" class="card-img"
							alt="...">
					</div>
					<div class="col-md-2">
						<img src="<c:url value='/img/story2.png'/>" class="card-img"
							alt="...">
					</div>
					<div class="col-md-2">
						<img src="<c:url value='/img/story2.png'/>" class="card-img"
							alt="...">
					</div>
				</div>
				<article class="all-browsers">
					<article id="topicListArea" class="browser bg-transparent">
					</article>
				</article>
			</div>
		</div>

	</div>


	<%@include file="/HappytailFooter.jsp"%>
	
			<div id="topicContentDialog" class="modal" tabindex="-1" role="dialog">
				<div class="modal-dialog" role="document">
				    <div class="modal-content">
          <div class="modal-body" id="topicContent">
				</div>
			</div>
			</div>
			</div>

	<script>
		var contextRoot = "/happytail";
		var topicListTemplate = "";
		var topicContentTemplate = "";
		var pageNum = 1; // start from page 1
		var categoryId = ${categoryId};
		var tagType = ${tagType};

		$(document).ready(function() {

			initTemplate();

			console.log(topicListTemplate);

			var fakeData = {
				'records' : [ {
					"userId" : 2,
					"username" : "915",
					"categoryId" : 1,
					"topicId" : 18,
					"title" : "01062020",
					"createDate" : "2020-06-01 02:47",
					"imageUrl" : null,
					"replyNum" : 0,
					"count" : 0,
					"likeNum" : 0,
					"category" : "生活",
					"isThumbsUp" : null,
					"isFollowed" : null,
					"isReported" : null
				} ]
			};

			// 		render(fakeData);

			getTopicListData();

		});

		function initTemplate() {
			$.ajax({
						url : contextRoot + "/template/topicTemplate.mst",
						type : "get",
						async : false,
						success : function(template) {
							topicListTemplate = $(template).filter("#topicList").html();
							topicContentTemplate = $(template).filter("#topicContent").html();
							console.log(topicContentTemplate);

						}
					});
		}

		function getTopicListData() {
			var url = contextRoot + "/topic/topiclist?pageSize=10&pageNum="+ pageNum;
			if (tagType != null) {
				url += "&tagType=" + tagType;
			}

			if (categoryId != null) {
				url += "&categoryId=" + categoryId;
			}

			$.ajax({
				url : url,
				type : "get",
				async : false,
				success : function(data) {

					render(data);

					$("#totalNum").text(data.totalNum);
					// check whether has next page or not
					if (data.hasNext) {
						// to the next page
						pageNum++;
					}

				}
			});
		}

		function render(jsonObj) {
			var data = Mustache.render(topicListTemplate, jsonObj);

			$("#topicListArea").append(data);
		}

		function openContentDialog(topicId) {

						console.log("topicId = " + topicId);

						var url = contextRoot + "/topic/" + topicId;

						$.ajax({
							url : url,
							type : "get",
							async : false,
							success : function(data) {
								$("#topicContent").html(Mustache.render(topicContentTemplate, data));
								console.log(data);
								
							}

						});
		console.log("Hello!");

			$('#topicContentDialog').modal('show');
		}
	</script>

</body>

</html>