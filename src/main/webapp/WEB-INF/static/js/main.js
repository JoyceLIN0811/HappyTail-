var contextRoot = "/happytail";
var noticeListTemplate = "";

$(document).ready(function(){
	initMainTemplate();
	initNotice();
});


function initMainTemplate(){
	$.ajax({
		url : contextRoot + "/template/mainTemplate.mst",
		type : "get",
		async : false,
		success : function(template) {
					noticeListTemplate = $(template).filter("#notice-list").html();
				}
	});
}

function initNotice(){
	
	// TODO : get unread notice , template in /template/mainTemplate.mst
	
	if($("#loginUserId").text() != ""){
		var url = contextRoot + "/topNotice/"+ $("#loginUserId").text();

//	var noticeList = {
//		noticeList : [
//			{
//				id : 1 , 
//				link: "/forum/topiclist?isForumArea=isForumArea",
//				message: "replyusername 回覆了你的文章 title"
//			},
//			{
//				id : 2 , 
//				link: "/forum/topiclist?isForumArea=isForumArea",
//				message: "thumbsUpusername 對你的文章title 按了value 表示心情"
//			},
//			{
//				id : 3 , 
//				link: "/forum/topiclist?isForumArea=isForumArea",
//				message: "thumbsUpusername 對你的回覆按了讚"
//			},
//			{
//				id : 4 , 
//				link: "",
//				message: "追蹤的文章 title 更新了，快去看看吧！"
//			}
//		]	
//	};
	
	$.ajax({
		url : url,
		type : "get",
		async : false,
		success : function(data) {
			console.log(data);

			$("#notice-list").html(Mustache.render(noticeListTemplate, {noticeList: data}));
	
			$(".notice-dropdown .counter").text($("#notice-list .dropdown-item").length);
		}
	
	});
	}
}

function forwardNoticeLink(id,link){
	
	// TODO : set notice isRead = true
	
	var url = contextRoot + "/notice/"+ id;

	$.ajax({
		url : url,
		type : "PUT",
		async : false,
		success : function(data) {
			console.log(data);	
		}
	
	});
	window.location.href = contextRoot + link;
}

//for side nav area
function openNav() {
			document.getElementById("mySidenav").style.width = "250px";
}

function closeNav() {
	document.getElementById("mySidenav").style.width = "0";
}