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
					<button type="button"
						class="list-group-item list-group-item-action active"
						onclick="setCategoryId(null,this)">所有文章</button>
					<button type="button"
						class="list-group-item list-group-item-action"
						onclick="setCategoryId(1,this)">生活</button>
					<button type="button"
						class="list-group-item list-group-item-action"
						onclick="setCategoryId(2,this)">資訊</button>
					<button type="button"
						class="list-group-item list-group-item-action"
						onclick="setCategoryId(3,this)">新聞</button>
					<button type="button"
						class="list-group-item list-group-item-action"
						onclick="setCategoryId(4,this)">發問</button>
					<button type="button"
						class="list-group-item list-group-item-action"
						onclick="setCategoryId(5,this)">認養</button>
					<button type="button"
						class="list-group-item list-group-item-action"
						onclick="setCategoryId(6,this)">其他</button>
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
									<button type="button" class="dropdown-item"
										onclick="setTagType(null)">最新</button>
									<div class="dropdown-divider"></div>
									<button type="button" class="dropdown-item"
										onclick="setTagType('hit')">熱門</button>
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
		<div class="modal-dialog modal-xl" role="document">
			<div class="modal-content">
				<div class="modal-body" id="topicContent"></div>
				<div class="modal-body" id="replyContentList"></div>
			</div>
		</div>
	</div>

	<div id="addTopicDialog" class="modal" tabindex="-1" role="dialog">
		<div class="modal-dialog modal-xl" role="document">
			<div class="modal-content">
				<div class="modal-body" id="addTopic">
					<div class="row justify-content-md-center">
						<div class="col-2">
							<blockquote class="flow-text left">發表文章</blockquote>
						</div>
						<div class="col-9"></div>
						<div class="col-1">
							<i class="fas fa-times fa-2x"></i>
						</div>
					</div>
					<form id="addTopicForm">
						<div class="form-group">

							<div class="row justify-content-md-center">
								<div class="col-12">
									<div class="form-check" style="margin-top: 15px;">
										<input class="form-check-input" type="radio" name="categoryId"
											id="life" value="1" required="required"> <label
											class="form-check-label" for="life"> 生活 </label>
									</div>
									<div class="form-check">
										<input class="form-check-input" type="radio" name="categoryId"
											id="knowledge" value="2"> <label
											class="form-check-label" for="knowledge"> 資訊 </label>
									</div>
									<div class="form-check">
										<input class="form-check-input" type="radio" name="categoryId"
											id="news" value="3"> <label class="form-check-label"
											for="news"> 新聞 </label>
									</div>
									<div class="form-check">
										<input class="form-check-input" type="radio" name="categoryId"
											id="question" value="4"> <label
											class="form-check-label" for="question"> 發問 </label>
									</div>
									<div class="form-check">
										<input class="form-check-input" type="radio" name="categoryId"
											id="adopt" value="5"> <label class="form-check-label"
											for="adopt"> 認養 </label>
									</div>
									<div class="form-check">
										<input class="form-check-input" type="radio" name="categoryId"
											id="other" value="6"> <label
											class="form-check-label" for="other"> 其他 </label>
									</div>
								</div>
							</div>

							<div class="row justify-content-md-center">
								<div class="col-12" style="margin-top: 15px;">
									<input name="title" class="form-control form-control-lg" type="text"
										placeholder="Title">
								</div>
							</div>
          					  <input type="hidden" name="username" value="${petMembers.username}" />
          					  <input type="hidden" name="userId" value="${petMembers.id}" />

							<div class="form-group" style="margin-top: 15px;">
								<label for="exampleFormControlTextarea1">Content:</label>
								<textarea name="content" class="form-control"
									id="exampleFormControlTextarea1" rows="20" cols="40"
									required="required"></textarea>
							</div>
						</div>
					</form>
					<div class="row">
						<div class="col-md-2 offset-md-6">
							<button type="button" class="btn btn-info" name="add" onclick="clickAddTopic()">發表</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script>
		var contextRoot = "/happytail";
		var topicListTemplate = "";
		var topicContentTemplate = "";
		var addTopicTemplate = "";
		var replyListTemplate = "";
		var topicListPageNum = 1; // start from page 1
		var replyListPageNum = 1; // start from page 1
		var categoryId = null;
		var tagType = null;

		$(document).ready(function() {

			initTemplate();

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
						replyListTemplate = $(template).filter("#replyContentList").html();

						}
					});
		}

		function getTopicListData() {
			var url = contextRoot + "/topic/topiclist?pageSize=10&pageNum="
					+ topicListPageNum;
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
						topicListPageNum++;
					}

				}
			});
		}

		function render(jsonObj) {
			var data = Mustache.render(topicListTemplate, jsonObj);

			$("#topicListArea").html("");
			$("#topicListArea").append(data);
		}

		function openTopicContentDialog(topicId,likeNum, replyNum) {

			console.log("topicId = " + topicId);

			var topicurl = contextRoot + "/topic/" + topicId;

			var replyurl = contextRoot + "/reply?pageSize=10&pageNum="
			+ replyListPageNum +"&topicId=" + topicId;

			var stageListObj = { stageList : [] };

			$.ajax({
				url : topicurl,
				type : "get",
				async : false,
				success : function(data) {
					data.likeNum = likeNum;
					data.replyNum = replyNum;
					
					$("#topicContent").html(
							Mustache.render(topicContentTemplate, data));
					console.log(data);
				}

			});

			$.ajax({
				url : replyurl,
				type: "get",
				async : false,
				success : function(data){

					for(let i=0 ; i<data.records.length ; i++){
						  data.records[i].stage = 'B' + (i + 1);
						}					
					$("#replyContentList").html("");
					$("#replyContentList").append(Mustache.render(replyListTemplate, data));

					// check whether has next page or not
					if (data.hasNext) {
						// to the next page
						replyListPageNum++;
					}
				}

				});
			console.log("Hello!");

			$('#topicContentDialog').modal('show');
		}

		function openAddTopicDialog() {

			console.log("Hello!");

			$('#addTopicDialog').modal('show');
		}

		function setCategoryId(catId, targetObj) {
			$(".list-group-item").removeClass("active");
			$(targetObj).addClass("active");

			categoryId = catId;
			pageNum = 1;
			getTopicListData();
		}

		function setTagType(tagTypeSrc) {
			tagType = tagTypeSrc;
			pageNum = 1;
			getTopicListData();
		}

		function clickAddTopic(){

			
			console.log($(addTopicForm).serialize());

			var url = contextRoot + "/topicPost";
			var form = $(addTopicForm);

			$.ajax({
				url : url,
				type : "POST",
				async : false,
				data: form.serialize(),
				success : function(data) {
// 					$("#addTopic")
// 							.html(Mustache.render(addTopicTemplate, data));
					console.log(data);

				}

			});
			console.log("GoodBye!");

			$('#addTopic').modal('hide')

			}
	</script>

</body>

</html>