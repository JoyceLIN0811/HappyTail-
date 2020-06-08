var myTopicTemplate = "";
var myTopicPage = 1;

var myFollowListTemplate = "";
var myFollowListPage = 1;

var myLikeTopicTemplate = "";
var myLikeTopicPage = 1;

var myReadHistoryTemplate = "";
var myReadHistoryPage = 1;

$(document).ready(function(){
	initTemplate();
	
	// TODO : all the function below
	getTopicListData();
//	getMyTopicData();
//	getMyFollowListData();
//	getMyLikeTopicData();
//	getMyReadHistoryData();
//	getFavorateCategory();
	
	// TODO : all the delete function and update function
	
});

function initTemplate() {
	$.ajax({
		url : contextRoot + "/template/memberCenterTemplate.mst",
		type : "get",
		async : false,
		success : function(template) {
						myTopicTemplate = $(template).filter("#myTopic").html();
						myFollowListTemplate = $(template).filter("#myFollowList").html();
						myLikeTopicTemplate = $(template).filter("#myLikeTopic").html();
						myReadHistoryTemplate = $(template).filter("#myReadHistory").html();
					}
	});
}

function setTagType(tagTypeSrc) {
	tagType = tagTypeSrc;
	pageNum = 1;
	getTopicListData();
}


function getTopicListData() {
	
	var url = contextRoot + "/myPage/topiclist?pageSize=10&pageNum="
	+ myTopicPage +  "&tagType=myTopiclist";	
	
	$.ajax({
		url : url,
		type : "get",
		async : false,
		success : function(data) {
			
			$("#topic").append(Mustache.render(myTopicTemplate, data));

			$("#totalNum").text(data.totalNum);
			// check whether has next page or not
			if (data.hasNext) {
				// to the next page
				myTopicPage++;
				}
			}
	
		});
	
	if (tagType != null) {
		
		if(tagType == "myTopiclist"){
		
		var url = contextRoot + "/myPage/topiclist?pageSize=10&pageNum="
		+ myTopicPage +  "&tagType=myTopiclist";	
		
		$.ajax({
			url : url,
			type : "get",
			async : false,
			success : function(data) {
				
				$("#topic").append(Mustache.render(myTopicTemplate, data));

				$("#totalNum").text(data.totalNum);
				// check whether has next page or not
				if (data.hasNext) {
					// to the next page
					myTopicPage++;
					}
				}
		
			});
		}else if(tagType == "myFollowlist"){
			var url = contextRoot + "/myPage/topiclist?pageSize=10&pageNum="
			+ myFollowListPage +  "&tagType=myFollowlist";	
			
			$.ajax({
				url : url,
				type : "get",
				async : false,
				success : function(data) {
					
					$("#follow").append(Mustache.render(myLikeTopicTemplate, data));

					$("#totalNum").text(data.totalNum);
					// check whether has next page or not
					if (data.hasNext) {
						// to the next page
						myFollowListPage++;
						}
					}
			
				});
		}else if(tagType == "myThumbsUplist"){
				var url = contextRoot + "/myPage/topiclist?pageSize=10&pageNum="
				+ myLikeTopicPage +  "&tagType=myThumbsUplist";	
				
				$.ajax({
					url : url,
					type : "get",
					async : false,
					success : function(data) {
						
						$("#like").append(Mustache.render(myFollowListTemplate, data));

						$("#totalNum").text(data.totalNum);
						// check whether has next page or not
						if (data.hasNext) {
							// to the next page
							myLikeTopicPage++;
							}
						}
				
					});
			
		}else if(tagType == "myReadHistorylist") {
			var url = contextRoot + "/myPage/topiclist?pageSize=10&pageNum="
			+ myReadHistoryPage +  "&tagType=myReadHistorylist";	
			
			$.ajax({
				url : url,
				type : "get",
				async : false,
				success : function(data) {
					
					$("#history").append(Mustache.render(myReadHistoryTemplate, data));

					$("#totalNum").text(data.totalNum);
					// check whether has next page or not
					if (data.hasNext) {
						// to the next page
						myReadHistoryPage++;
						}
					}
			
				});
		}else{
			$("#topicNum").addClass("d-none");
			
			
			
			
		}
	}
}
	
	






















function getMyTopicData(){
	// TODO : use myTopicTemplate and myTopicPage to render
	// target area : id="topic"
	
	var url = contextRoot + "/myPage/topiclist?pageSize=10&pageNum="
					+ myTopicPage + "&tagType=myTopiclist";
	
}

function getMyFollowListData(){
	// TODO : use myFollowListTemplate and  myFollowListPage to render
	// target area : id="follow"
}

function getMyLikeTopicData(){
	// TODO : use myLikeTopicTemplate and  myLikeTopicPage to render
	// target area : id="like"
}

function getMyReadHistoryData(){
	// TODO : use myReadHistoryTemplate and  myReadHistoryPage to render
	// target area : id="history"
}

function getFavorateCategory(){
	// TODO : get current user's favorate category 
	var codeMapList = null;
	var url = ""
	
//	$.ajax({
//		url: url,
//	   type: "GET",
//	success: function(data){
//				codeMapList = data;
//			}
//	});
	
	// fake data
	codeMapList = [
		{
			id : 1,
		module : "Forum",
		  type : "topicCategory",
		   key : 1,
		 value : "生活"
		},
		{
			id : 2,
			module : "Forum",
			type : "topicCategory",
			key : 2,
			value : "資訊"
		}
	];
	
	var categoryIdList = []; // need to get from API
	
	// get categoryId from codeMap JSON Object
	for(let codeMap of codeMapList){
		categoryIdList.push(codeMap.key);
	}
	
	$("#favorateCategoryList .list-group-item").each(function(index,element){
		for(let categoryId of categoryIdList){
			if($(element).attr("value") == categoryId){
				$(element).addClass("active");
			}
		}
	});
}

function deleteTopic(topicId){
	// TODO : get user id from Header
}

function deleteFollow(topicId){
	// TODO : get user id from Header
}

function deleteLike(topicId){
	// TODO : get user id from Header
}

function deleteHistory(topicId){
	// TODO : get user id from Header
}

// for favorate
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