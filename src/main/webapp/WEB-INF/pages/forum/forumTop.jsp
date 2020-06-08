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

	<div id="topicContentDialog" class="modal vh-100" tabindex="-1" role="dialog">
		<div class="modal-dialog modal-xl" role="document">
			<div class="modal-content">
				<div class="modal-body" id="topicContent"></div>
				<div class="modal-body" id="replyContentList"></div>
				<div class="modal-body" id="addReply"></div>
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
							<i class="fas fa-times fa-2x" onclick="closeAddTopicDialog()"></i>
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
										placeholder="標題">
								</div>
							</div>
							<div class="row justify-content-md-center">
								<div class="col-12" style="margin-top: 15px;">
									 <div id="topicEditor"></div>
								</div>
							</div>
							<div class="row justify-content-md-center">
								<div class="col-12" style="margin-top: 15px;">
									<div class="form-check">
 										 <input class="form-check-input" type="checkbox" value="true" id="isCover" name="isCover">
  											<label class="form-check-label" for="isCover">是否顯示封面圖片
  											</label>
								</div>
							</div>
							</div>
							
        					  <input type="hidden" name="content"/>
        					  <input type="hidden" name="imgList"/>
         					  <input type="hidden" name="username" value="${petMembers.username}" />
         					  <input type="hidden" name="userId" value="${petMembers.id}" />

<!-- 							<div class="form-group" style="margin-top: 15px;"> -->
<!-- 								<label for="exampleFormControlTextarea1">Content:</label> -->
								
<!-- 								<textarea name="content" class="form-control" -->
<!-- 									id="exampleFormControlTextarea1" rows="20" cols="40" -->
<!-- 									required="required"></textarea> -->
<!-- 							</div> -->
						</div>
					</form>
					<div class="row">
						<div class="col-md-2 offset-md-5">
							<button type="button" class="btn btn-info" name="add" onclick="clickAddTopic()">發表</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div id="addReportDialog" class="modal" tabindex="-1" role="dialog">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-body" id="addReport">
					<div class="row justify-content-md-center">
						<div class="col-2">
							<blockquote class="flow-text">檢舉文章</blockquote>
						</div>
						<div class="col-9"></div>
						<div class="col-1">
							<i class="fas fa-times fa-2x" onclick="closeAddReportDialog()"></i>
						</div>
					</div>
					<form id="addReportForm">
						<div class="form-group">
						<div>
							<blockquote class="flow-text">檢舉這篇文章的原因？</blockquote>
						</div>
						

							<div class="custom-control custom-radio">
        						<input type="radio" class="custom-control-input" id="report1" name="categoryId" value="1">
       							 <label class="custom-control-label" for="report1">中傷、歧視、挑釁或謾罵他人</label>
   							 </div>

   							 <div class="custom-control custom-radio">
      							  <input type="radio" class="custom-control-input" id="report2" name="categoryId" value="2">
     							   <label class="custom-control-label" for="report2">惡意洗板、重複張貼</label>
   							 </div>

    						<div class="custom-control custom-radio">
      							  <input type="radio" class="custom-control-input" id="report3" name="categoryId" value="3">
      							  <label class="custom-control-label" for="report3">包含色情、露點、性騷擾或血腥恐怖等讓人不舒服之內容</label>
    						</div>
    						<div class="custom-control custom-radio">
        						<input type="radio" class="custom-control-input" id="report4" name="categoryId" value="4">
      							  <label class="custom-control-label" for="report4">包含鼓吹暴力、犯罪之內容</label>
						    </div>
						    <div class="custom-control custom-radio">
						        <input type="radio" class="custom-control-input" id="report5" name="categoryId" value="5">
						        <label class="custom-control-label" for="report5">包含廣告、商業宣傳之內容</label>
						    </div>
						    <div class="custom-control custom-radio">
						        <input type="radio" class="custom-control-input" id="report6" name="categoryId" value="6">
						        <label class="custom-control-label" for="report6">文章發表在不適當的看板</label>
						    </div>
						    <div class="custom-control custom-radio">
						        <input type="radio" class="custom-control-input" id="report7" name="categoryId" value="7">
						        <label class="custom-control-label" for="report7">使用者名稱內含不適當的字詞</label>
						    </div>
						    <div class="custom-control custom-radio">
						        <input type="radio" class="custom-control-input" id="report8" name="categoryId" value="8">
						        <label class="custom-control-label" for="report8">其他原因</label>
						    </div>
                         	  <input type="hidden" name="topicId"/>
          					  <input type="hidden" name="username" value="${petMembers.username}" />
          					  <input type="hidden" name="userId" value="${petMembers.id}" />
						</div>
					</form>
					<div class="row">
						<div class="col-md-2 offset-md-5">
							<button type="button" class="btn btn-info" name="add" onclick="clickAddReport()">送出</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div id="favorateCatgoryDialog" class="modal" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-body">
					<div class="row ml-3 mr-3 mt-3 mb-3">
						<div class="col-12">
							<div id="favorateCategoryList" class="list-group">
				                  <button type="button" class="text-center list-group-item list-group-item-action " onclick="toggleActive(this)" value="1"><h5>生活</h5></button>
				                  <button type="button" class="text-center list-group-item list-group-item-action " onclick="toggleActive(this)" value="2"><h5>資訊</h5></button>
				                  <button type="button" class="text-center list-group-item list-group-item-action " onclick="toggleActive(this)" value="3"><h5>新聞</h5></button>
				                  <button type="button" class="text-center list-group-item list-group-item-action " onclick="toggleActive(this)" value="4"><h5>發問</h5></button>
				                  <button type="button" class="text-center list-group-item list-group-item-action " onclick="toggleActive(this)" value="5"><h5>認養</h5></button>
				                  <button type="button" class="text-center list-group-item list-group-item-action " onclick="toggleActive(this)" value="6"><h5>其他</h5></button>
			                </div>
			                <button type="button" class="btn btn-primary btn-lg btn-block mt-3" onclick="updateFavorateCategory()">
			                 	 選擇喜好類別
			                </button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
	
	<script>
// 		var contextRoot = "/happytail";
		var topicListTemplate = "";
		var topicContentTemplate = "";
		var addTopicTemplate = "";
		var replyListTemplate = "";
		var topicListPageNum = 1; // start from page 1
		var replyListPageNum = 1; // start from page 1
		var isTopicListHasNextPage = true;
		var topicListIndexArray = [];
		var topicListLoadLock = false; 
		var categoryId = null;
		var tagType = null;
		var topicEditor = null;
		var replyEditor = null;
	    var replyTemplate = "";
	    var stageLinkTemplate = "";
	    var stageListTemplate = "";
	    
	    // TODO : check from API
	    var hasNotSetFavorateCategory = true;

		$(document).ready(function() {

			initTemplate();
			getTopicListData();

			initTopicCKEditor();

	        initTemplate();
	        
			if(location.href.indexOf("/topicPage/") != -1){
				var topicId = location.href.substring(location.href.indexOf("/topicPage/") + 11);
				openTopicContentDialog(topicId, null);
			}

	        $("#sendBtn").click(function(){
	                sendReply();
	         });
	        
	        if(($("#loginUserId").text() != "") && hasNotSetFavorateCategory){
	        	$("#favorateCatgoryDialog").modal('show');
	        }
	        
	        // for topic list pagination
	        $(window).scroll(function(){
// 	        	console.log("scrollTop = " + $(this).scrollTop());
// 	        	console.log("scroll bottom pos = " + ($(this).scrollTop() + $(this).height()));
// 	        	console.log("height = " + $("body").height());
	        	
	        	if(($("body").height() - ($(this).scrollTop() + $(this).height())) < 300 
	        			&& !topicListLoadLock // prevent duplicate loading 
	        			&& isTopicListHasNextPage
	        			){
	        		
	        		// prevent duplicate loading, lock when execute function
	        		topicListLoadLock = true;
	        		
	        		topicListPageNum++;
	        		
	        		getTopicListData();
	        		
	        		topicListLoadLock = false;
	        	}
	        });
	        
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
			console.log("isTopicListHasNextPage = " + isTopicListHasNextPage);
			if(isTopicListHasNextPage){
				$.ajax({
					url : url,
					type : "get",
					async : false,
					success : function(data) {
						console.log(data);
//	 					render(data);
						var resultData = Mustache.render(topicListTemplate, data);
						$("#topicListArea").append(resultData);
						

						$("#totalNum").text(data.totalNum);
						
						
						refreshTopicListIndexArray();
						
						// check whether has next page or not
						isTopicListHasNextPage = data.isHasNext;

					}
				});
			}
			
		}
		
		function refreshTopicList(){
			$("#topicListArea").html("");
			getTopicListData();
		}

		function render(jsonObj) {
			var data = Mustache.render(topicListTemplate, jsonObj);

			$("#topicListArea").html("");
			$("#topicListArea").append(data);
		}
		
		// data prepare for topicContentDialog get next or previous topic
		function refreshTopicListIndexArray(){
			topicListIndexArray = [];
			
			$("#topicListArea .topicId").each(function(index,element){
				topicListIndexArray.push({
						index: index, 
						topicId: $(element).text(),
						element: $(element)});
			});
			
// 			console.log(topicListIndexArray);
		}
		
		function getPreviousTopic(){
			var currentTopicId = $("#addReplyForm input[name='topicId']").val();
			var targetTopicListObj = null;
			
			for(let i=0 ; i<topicListIndexArray.length ; i++){
				
				if(topicListIndexArray[i].topicId == currentTopicId 
				   && i != 0){ // prevent first topic condition
					targetTopicListObj = topicListIndexArray[i-1];
				}
			}
			
			// check previous topic is found
			if(targetTopicListObj != null){
				openTopicContentDialog(targetTopicListObj.topicId,targetTopicListObj.element);
			}
			
		}
		
		function getNextTopic(){
			var currentTopicId = $("#addReplyForm input[name='topicId']").val();
			var targetTopicListObj = null;
			
			for(let i=0 ; i<topicListIndexArray.length ; i++){
				
				if(topicListIndexArray[i].topicId == currentTopicId 
				   && i != (topicListIndexArray.length - 1)){ // prevent last topic condition
					
					targetTopicListObj = topicListIndexArray[i+1];
				}
			}
			
			// check previous topic is found
			if(targetTopicListObj != null){
				openTopicContentDialog(targetTopicListObj.topicId,targetTopicListObj.element);
			}
			
		}

		function openTopicContentDialog(topicId, targetObj) {

			
			var likeNum = targetObj != null ? $(targetObj).parentsUntil(".card").find(".likeNum").text() : 0;
			var replyNum = targetObj != null ? $(targetObj).parentsUntil(".card").find(".replyNum").text() : 0;

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
					data.topicId = topicId;
					
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
						  data.records[i].stageValue = i + 1;
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
			initReplyCKEditor();
			
			history.pushState({foo: "Post"},"",contextRoot + "/forum/topicPage/" + topicId);

			$('#topicContentDialog').modal('show');
		}

		function openAddTopicDialog() {

			console.log("Hello!");

			$('#addTopicDialog').modal('show');
		}


        function initTopicCKEditor(){
            // topic CKEditor 初始化
//             ClassicEditor
            BalloonEditor
            .create( document.querySelector( '#topicEditor' ),{
                placeholder: '在此輸入內容...',
                ckfinder: {
			                uploadUrl: contextRoot + "/uploadTopicImg"
			              }
            } )
            .then( editorInstance => {
            	topicEditor = editorInstance;
                
                // 將輸入區綁定change事件(:data為僅限輸入值更動,不包含輸入區中工具列及滑鼠的任何操作)
//                 editor.model.document.on( 'change:data', () => {
                    // console.log( 'The Document has changed!' );

//                     let lastTagText = getLastOuterTagText($(editor.getData()));

//                     atSignCheck(lastTagText);

//                 } );
            })
            
            .catch( error => {
                console.error( error );
            });
        }

        function initReplyCKEditor(){
            // reply CKEditor 初始化
//             ClassicEditor
            BalloonEditor
            .create( document.querySelector( '#replyEditor' ),{
                placeholder: '在此輸入回覆...'
            } )
            .then( editorInstance => {
            	replyEditor = editorInstance;
                
                // 將輸入區綁定change事件(:data為僅限輸入值更動,不包含輸入區中工具列及滑鼠的任何操作)
//                 editor.model.document.on( 'change:data', () => {
                    // console.log( 'The Document has changed!' );

//                     let lastTagText = getLastOuterTagText($(editor.getData()));

//                     atSignCheck(lastTagText);

//                 } );
            })
            
            .catch( error => {
                console.error( error );
            });
        }



     // 檢查@是否出現於輸入區
        function atSignCheck(text){
            let strLen = text.length;
            /*
            * 1.檢查輸入字串的長度是否為零(避免裁切字串出問題)
            * 2.檢查輸入字串最後一個字母是否為 '@'
            * 3.檢查倒數第二個字母是否為空白 (需空格後方可使用@功能)
            * 4.檢查輸入字串是否只有一個字母 (解決直接輸入@的情況)
            * 5.第二點為必要條件,三四點則符合其一及可啟動 
            */
            if (strLen != 0) {
                let atCheck = (text.substring(strLen - 1) == "@");
                let emptyCheck = (text.substring(strLen - 2,strLen - 1) == " ");
                let leadCheck = (strLen == 1);

                if (atCheck && (emptyCheck || leadCheck)) {
                    showStageSelectDialog();
                    
                }
            }

        }

		function setCategoryId(catId, targetObj) {
			$(".list-group-item").removeClass("active");
			$(targetObj).addClass("active");

			categoryId = catId;
			topicListPageNum = 1;
			isTopicListHasNextPage = true;

			
			refreshTopicList();
		}

		function setTagType(tagTypeSrc) {
			tagType = tagTypeSrc;
			pageNum = 1;
			getTopicListData();
		}

		function clickAddTopic(){

			var content = topicEditor.getData();
			
			var imgListStr = "";
			$(content).find("img").each(function(index,element){
				console.log("index = " + index);// number of picture
				console.log("src = " + $(element).attr("src"));
				
				imgListStr += $(element).attr("src") + ",";
			});
			
			if(imgListStr.length != 0){
				imgListStr = imgListStr.substring(0,imgListStr.length - 1);//cut the ,
			}
			
			$("#addTopicForm input[name='imgList']").val(imgListStr);
			
			$("#addTopicForm input[name='content']").val(content);
			console.log($("#addTopicForm input[name='content']").val()); 
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

			$('#addTopicDialog').modal('hide')

			}

		function clickAddReply(){

			var content = replyEditor.getData();
			
			console.log($("#loginUsername"));
			console.log($("#loginUserId"));
			console.log("text = " + $("#loginUsername").text());
			console.log("text = " + $("#loginUserId").text());
			console.log("val = " + $("#loginUsername").val());
			console.log("val = " + $("#loginUserId").val());
			
			$("#addReplyForm input[name='username']").val($("#loginUsername").text());
			$("#addReplyForm input[name='userId']").val($("#loginUserId").text());
			$("#addReplyForm input[name='replyContent']").val(content);
			console.log($(addReplyForm).serialize());

			var url = contextRoot + "/replyPost";
			var form = $(addReplyForm);
			console.log($(addReplyForm).serialize());
			

			$.ajax({
				url : url,
				type : "POST",
				async : false,
				data: form.serialize(),
				success : function(data) {
										
						var maxStageValue = 0
					$(".stage-value").each(function(index, element){
						maxStageValue = parseInt($(element).text());
						})
						data.stageValue	= maxStageValue + 1;
						data.stage = "B" + (maxStageValue + 1);

						var replyListObj = {
								records : [data]
							};

						console.log(data);
							
					$("#replyContentList").append(Mustache.render(replyListTemplate, replyListObj));

				}

			});
			console.log("GoodBye!");
			}

		function clickTopicThumbsUp(topicId, targetObj){

			if($(targetObj).hasClass("checked")){

				var url = contextRoot + "/thumbsUp/topic/" + $("#loginUserId").text()+ "/" + topicId;
				
				console.log($(targetObj).hasClass("checked"));
				
				$.ajax({
					url : url,
					type : "DELETE",
					async : false,
					success : function(data) {
						$(targetObj).attr("class", "far fa-thumbs-up fa-2x");
						 var likeValue = parseInt($(targetObj).next().text());
						 likeValue--;
						 $(targetObj).next().text(likeValue);
					
						}
					});
				
			}else{
				
				var url = contextRoot + "/thumbsUpPost";
				var dataObj = {
							type : "topic",
							topicId : topicId, 
							replyId : null,
							userId : $("#loginUserId").text(),
							username : $("#loginUsername").text(),	
							categoryId :1
						}
				console.log(dataObj);
				console.log($(targetObj).hasClass("checked"));
				
				$.ajax({
					url : url,
					type : "POST",
					async : false,
					data : JSON.stringify(dataObj),
					contentType : "application/json",
					success : function(data) {
							$(targetObj).attr("class", "fas checked  fa-thumbs-up fa-2x");
							 var likeValue = parseInt($(targetObj).next().text());
							 likeValue++;
							 $(targetObj).next().text(likeValue);
					
						}
				});
				
			}
			
	}

		function clickReplyThumbsUp(topicId, replyId, targetObj){

			if($(targetObj).hasClass("checked")){

				var url = contextRoot + "/thumbsUp/reply/" + $("#loginUserId").text()+ "/" + replyId;
				
				console.log($(targetObj).hasClass("checked"));
				
				$.ajax({
					url : url,
					type : "DELETE",
					async : false,
					success : function(data) {
						$(targetObj).attr("class", "far fa-heart fa-3x");
						 var likeValue = parseInt($(targetObj).next().text());
						 likeValue--;
						 $(targetObj).next().text(likeValue);
					
						}
					});
				
			}else{
				
				var url = contextRoot + "/thumbsUpPost";
				var dataObj = {
							type : "reply",
							topicId : topicId, 
							replyId : replyId,
							userId : $("#loginUserId").text(),
							username : $("#loginUsername").text(),	
							categoryId :1
						}
				console.log(dataObj);
				console.log($(targetObj).hasClass("checked"));
				
				$.ajax({
					url : url,
					type : "POST",
					async : false,
					data : JSON.stringify(dataObj),
					contentType : "application/json",
					success : function(data) {
							$(targetObj).attr("class", "fas checked  fa-heart fa-3x");
							 var likeValue = parseInt($(targetObj).next().text());
							 likeValue++;
							 $(targetObj).next().text(likeValue);
					
						}
				});
				
			}
			
	}

		function clickTopicFollowed(topicId,targetObj){

			if($(targetObj).hasClass("checked")){

				var url = contextRoot + "/follow/" + $("#loginUserId").text()+ "/" + topicId;
				
				console.log($(targetObj).hasClass("checked"));
				
				$.ajax({
					url : url,
					type : "DELETE",
					async : false,
					success : function(data) {
						$(targetObj).attr("class", "far fa-bookmark fa-2x");
					
						}
					});
				}else{
					var url = contextRoot + "/followPost";
					var dataObj = {
							topicId : topicId, 
							userId : $("#loginUserId").text(),
							username :$("#loginUsername").text(),	
							}
					console.log(dataObj);
	
					console.log($(targetObj).hasClass("checked"));
			
					$.ajax({
						url : url,
						type : "POST",
						async : false,
						data : JSON.stringify(dataObj),
						contentType : "application/json",
						success : function(data) {
							$(targetObj).attr("class", "fas checked fa-bookmark fa-2x");
				
						}
				});
			}
				
		}


		function closeTopicContentDialog(topicId,targetObj){
			$('#topicContentDialog').modal('hide')
			}

		function closeAddTopicDialog(topicId,targetObj){
			$('#addTopicDialog').modal('hide')
			}

		function closeAddReportDialog(topicId,targetObj){
			$('#addReportDialog').modal('hide')
			}

		function shareLine(){
			var shareUrl = "https://social-plugins.line.me/lineit/share?url=" + location.href;
	        window.open(shareUrl,"_blank","left=400,top=200,width=750,height=500");
			}

		function openAddReportDialog(topicId) {

			console.log("Hello!");
			$("#addReportForm input[name='topicId']").val(topicId);
			

			$('#addReportDialog').modal('show');
		}

		function clickAddReport(){

			var url = contextRoot + "/reportPost";
			var form = $(addReportForm);
			
			console.log($(addReportForm).serialize());

			

			$.ajax({
				url : url,
				type : "POST",
				async : false,
				data: form.serialize(),
				success : function(data) {
					console.log(data);

				}

			});
			console.log("GoodBye!");

			$('#addReportDialog').modal('hide')

		}
		
		function toggleActive(targetObj){
		    $(targetObj).toggleClass("active");
		}
		
		function updateFavorateCategory(){
			var userId =  parseInt($("#loginUserId").text());
			var categoryList = [];
			
			$("#favorateCategoryList .active").each(function(index,element){
				categoryList.push({ userId: userId, categoryId: parseInt($(element).attr("value"))});
			});
			
			
			// TODO : need to defined
			var url = "";
			
			$.ajax({
				url: url,
			   type: "POST",
			   data: JSON.stringify(),
			success: function(data){
						alert("更新成功 !");
					}
			});
			
		}
	</script>

</body>

</html>