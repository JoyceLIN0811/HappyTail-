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
	getMyTopicData();
	getMyFollowListData();
	getMyLikeTopicData();
	getMyReadHistoryData();
	getFavorateCategory();
	
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

function getMyTopicData(){
	// TODO : use myTopicTemplate and myTopicPage to render
	// target area : id="topic"
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