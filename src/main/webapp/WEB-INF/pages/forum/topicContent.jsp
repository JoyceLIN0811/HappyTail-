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
	<article id="topicContentArea" class="browser bg-transparent">

		<!--  <div class="card bg-transparent text-black" style="max-width: 80%; margin: auto;"> -->
		<!--         <div class=" card-body"> -->
		<!--             <div class="row justify-content-md-center"> -->
		<!--                 <div class="col col-lg-1" style="margin:auto;"> -->
		<!--                     <i class="fas fa-chevron-left fa-3x"></i> -->
		<!--                 </div> -->
		<!--                 <div class="col-md-10"> -->

		<!--                     <div class="row justify-content-md-center"> -->
		<!--                         <div class="col-md-11"> -->
		<!--                             <p class="card-text"><img src="image\foot.png" class="card-img" alt="..." -->
		<!--                                     style="height: 60px; width: 80px;"> -->
		<!--                                 <span>username</span></p> -->
		<!--                         </div> -->
		<!--                         <div class="col align-self-end"> -->
		<!--                             <i class="fas fa-times fa-2x"></i> -->
		<!--                         </div> -->
		<!--                     </div> -->

		<!--                     <div class="row justify-content-md-center" style="height: 100px; text-align:center;"> -->
		<!--                         <div class="col-md-12"> -->
		<!--                             <h2 class="card-title">Title</h2> -->
		<!--                         </div> -->
		<!--                     </div> -->

		<!--                     <div class="row justify-content-md-center"> -->
		<!--                         <div class="col-2 align-self-start"> -->
		<!--                             <span>Category</span> -->
		<!--                         </div> -->
		<!--                         <div class="col-2"> -->
		<!--                             <span>PostTime</span> -->
		<!--                         </div> -->
		<!--                         <div class="col-md-8"> -->
		<!--                         </div> -->
		<!--                     </div> -->

		<!--                     <div class="row justify-content-md-center" style="height: 800px; text-align:center;"> -->
		<!--                         <div class="col-md-12"> -->
		<!--                             Contnet -->
		<!--                         </div> -->
		<!--                     </div> -->

		<!--                     <div class="row justify-content-md-center" style="height: 80px"> -->
		<!--                         <div class=" col-md-4"> -->
		<!--                             <i class="fas fa-thumbs-up fa-2x"></i> -->
		<!--                             <i class="far fa-laugh-squint fa-2x"></i> -->
		<!--                             <i class="far fa-sad-cry fa-2x"></i> -->
		<!--                             <i class="far fa-surprise fa-2x"></i> -->
		<!--                             <i class="fas fa-heart fa-2x"></i> -->
		<!--                             <i class="far fa-angry fa-2x"></i> -->
		<!--                             <span>ThumbsNum</span> -->
		<!--                         </div> -->



		<!--                         <div class="col-md-4"> -->
		<!--                             <i class="far fa-comment-dots fa-2x"></i> -->
		<!--                             <span>ReplyNum</span> -->
		<!--                         </div> -->

		<!--                         <div class="col-md-1"> -->
		<!--                             <i class="far fa-heart fa-2x"></i> -->
		<!--                             <i class="fas fa-heart fa-2x"></i> -->
		<!--                         </div> -->

		<!--                         <div class="col-md-1"> -->
		<!--                             <i class="far fa-bookmark fa-2x"></i> -->
		<!--                             <i class="fas fa-bookmark fa-2x"></i> -->
		<!--                         </div> -->

		<!--                         <div class="col-md-1"> -->
		<!--                             <i class="fas fa-share fa-2x"></i> -->
		<!--                         </div> -->

		<!--                         <div class="col-md-1"> -->
		<!--                             <i class="fas fa-exclamation-triangle fa-2x"></i> -->
		<!--                         </div> -->
		<!--                     </div> -->

		<!--                     <div class="row justify-content-md-center"> -->
		<!--                         <div class="col-md-1"> -->
		<!--                             <i class="fas fa-paw fa-2x"></i> -->
		<!--                         </div> -->

		<!--                         <div class="col-md-11"> -->
		<!--                             <input type="reply" class="form-control" id="inputReply" placeholder="Reply Here....."> -->
		<!--                         </div> -->

		<!--                     </div> -->

		<!--                 </div> -->
		<!--                 <div class="col col-lg-1" style="margin:auto;"> -->
		<!--                     <i class="fas fa-chevron-right fa-3x"></i> -->
		<!--                 </div> -->
		<!--             </div> -->
		<!--         </div> -->
		<!--     </div> -->
	</article>
	<%@include file="/HappytailFooter.jsp"%>

	<script>
		

// 		var contextRoot = "/happytail";
// 		var topicContentTemplate = "";
// 		var pageNum = 1; // start from page 1

// 		$(document).ready(function() {

// 			initTemplate();

// 			console.log(topicContentTemplate);

// 			openContentDiaglog(topicId)

// 			// 		getTopicContentData(topicId);

// 		});

// 		function initTemplate() {
// 			$.ajax({
// 				url : contextRoot + "/template/topicTemplate.mst",
// 				type : "get",
// 				async : false,
// 				success : function(template) {
// 					topicContentTemplate = $(template).filter("#topicContent")
// 							.html();
// 				}
// 			});
// 		}

// 		function getTopicContentData(topicId) {
// 			var url = contextRoot + "/topic/" + topicId;

// 			$.ajax({
// 				url : url,
// 				type : "get",
// 				async : false,
// 				success : function(data) {
// 					render(data);
// 				}

// 			});
// 		}
// 		function render(jsonObj) {
// 			var data = Mustache.render(topicContentTemplate, jsonObj);
// 			$("#topicContentArea").append(data);
// 		}
	</script> 

</body>
</html>