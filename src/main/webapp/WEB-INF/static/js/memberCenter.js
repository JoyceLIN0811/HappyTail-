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