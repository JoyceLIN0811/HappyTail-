package com.happytail.forum.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.happytail.forum.model.Favorate;
import com.happytail.forum.model.Follow;
import com.happytail.forum.model.Reply;
import com.happytail.forum.model.ReplylistView;
import com.happytail.forum.model.Report;
import com.happytail.forum.model.ThumbsUp;
import com.happytail.forum.model.ThumbsUpView;
import com.happytail.forum.model.Topic;
import com.happytail.forum.model.TopiclistView;
import com.happytail.forum.model.service.ForumService;
import com.happytail.forum.model.service.FourmMemberService;
import com.happytail.forum.model.service.LimitPostService;
import com.happytail.general.model.CodeMap;
import com.happytail.general.model.Notice;
import com.happytail.general.util.Page;
import com.happytail.general.util.PageInfo;
import com.happytail.member.model.PetMembers;

@RestController
public class TestController {

	@Autowired
	private ForumService forumService;

	@Autowired
	private FourmMemberService fourmMemberService;

	@Autowired
	private LimitPostService limitPostService;

	@GetMapping("/topic/category")
	public List<CodeMap> CategoryList() {
		return forumService.getCategoryList();
	}

	@PostMapping("/insertFavorateCategory")
	public Map<String, String> insertFavorateCategory(@SessionAttribute(required = false) PetMembers petMembers, @RequestBody List<Favorate> list) {
		Map<String, String> map = new HashMap<String, String>();
		forumService.addFavorate(list);
		map.put("insert", "success");
		return map;
	}

	@GetMapping("/topic/topiclist")
	public Page<TopiclistView> getTopicList(@SessionAttribute(required = false) PetMembers petMembers,
			@RequestParam(required = false) Integer categoryId, @RequestParam Integer pageSize,
			@RequestParam Integer pageNum, @RequestParam(name = "tagType") String tagType) {
		if ("hit".equals(tagType)) {
			return forumService.getHitTopicList(categoryId, new PageInfo(pageSize, pageNum));
		} else {
			return forumService.getTopicList(petMembers, categoryId, new PageInfo(pageSize, pageNum));
		}
	}

//	@GetMapping("/topic/hitTopiclist")
//	public Page<TopiclistView> getHitTopicList(@SessionAttribute PetMembers petMembers
//											, @RequestParam(required = false) Integer categoryId
//											, @RequestParam Integer pageSize
//											, @RequestParam Integer pageNum){
//		
//		return forumService.getHitTopicList(categoryId, new PageInfo(pageSize, pageNum));
//
//	}

	@GetMapping("/topic/{topicId}")
	public Topic TopicContent(@SessionAttribute(required = false) PetMembers petMembers,
			@PathVariable Integer topicId) {
		return forumService.getTopicContent(petMembers, topicId);
	}

	@GetMapping("/reply")
	public Page<ReplylistView> ReplyList(@SessionAttribute(required = false) PetMembers petMembers,
			@RequestParam Integer topicId, @RequestParam Integer pageSize, @RequestParam Integer pageNum) {

		return forumService.getReplyList(petMembers, topicId, new PageInfo(pageSize, pageNum));
	}

	@GetMapping("/thumbsUp")
	public List<ThumbsUpView> ThumbsUpList(@RequestParam Integer topicId) {
		return forumService.getThumbsUpList(topicId);
	}

	@PostMapping("/topic")
	public Topic addTopic(@ModelAttribute Topic topic) {
		return forumService.addTopic(topic);
	}

	@PostMapping("/reply")
	public Reply addReply(@ModelAttribute Reply reply) {
		return forumService.addReply(reply);
	}

	@PostMapping("/thumbsUp")
	public ThumbsUp addThumbsUp(@ModelAttribute ThumbsUp thumbsUp, @RequestParam(required = false) Integer replyId) {
		return forumService.addThumbsUp(thumbsUp, replyId);
	}

	@PostMapping("/follow")
	public Follow addFollowTopic(@ModelAttribute Follow follow) {
		return forumService.addFollowTopic(follow);
	}

	@PostMapping("/report")
	public Report addReport(@ModelAttribute Report report) {
		return forumService.addReport(report);
	}

	@DeleteMapping("/thumbsUp/{type}/{userId}/{targetId}")
	public Boolean removeThumbsUp(@SessionAttribute(required = false) PetMembers petMembers,
			@PathVariable Integer targetId, @PathVariable String type, @PathVariable Integer userId) {
		forumService.removeThumbsUp(type, targetId, userId);
		return true;
	}

	@DeleteMapping("/follow/{userId}/{topicId}")
	public Boolean removeFollow(@SessionAttribute(required = false) PetMembers petMembers,
			@PathVariable Integer topicId, @PathVariable Integer userId) {
		forumService.removeFollow(topicId, userId);
		return true;
	}

	@PutMapping("/notice/{noticeId}")
	public Boolean updateIsReadStatus(@PathVariable Integer noticeId) {
		forumService.updateIsReadStatus(noticeId);
		return true;

	}

	@GetMapping("/myPage/topiclist")
	public Page<TopiclistView> getMyTopiclist(@SessionAttribute(required = false) PetMembers petMembers,
			@RequestParam Integer userId, @RequestParam Integer pageSize, @RequestParam Integer pageNum,
			@RequestParam(required = false) String type, @RequestParam(name = "tagType") String tagType) {

		if ("myTopiclist".equals(tagType)) {

			return fourmMemberService.getMemberIdTopiclist(userId, new PageInfo(pageSize, pageNum));

		} else if ("myFollowlist".equals(tagType)) {

			return fourmMemberService.getMyFollowlist(userId, new PageInfo(pageSize, pageNum));

		} else if ("myThumbsUplist".equals(tagType)) {

			return fourmMemberService.getMyThumbsUplist(userId, type, new PageInfo(pageSize, pageNum));

		} else if ("myReadHistorylist".equals(tagType)) {
			return fourmMemberService.getMyReadHistorylist(userId, new PageInfo(pageSize, pageNum));
		}

		return new Page<TopiclistView>();
	}

	@GetMapping("/myPage/favorateCategorylist")
	public List<CodeMap> getFavorateCategory(@SessionAttribute(required = false) PetMembers petMembers,
			@RequestParam Integer userId) {

		return fourmMemberService.getMyFavorateCategory(userId);
	}

	@GetMapping("/myPage/forumNotice/{userId}")
	public Page<Notice> getMyForumNotice(@SessionAttribute(required = false) PetMembers petMembers,
			@RequestParam String module, @PathVariable Integer userId, @RequestParam Integer pageSize,
			@RequestParam Integer pageNum) {

		return fourmMemberService.getAllMyForumNotice(module, userId, new PageInfo(pageSize, pageNum));
	}
	
	@GetMapping("/myPage/topicContent/{topicId}")
	public Topic getTopicContent(@SessionAttribute(required = false) PetMembers petMembers
							, @PathVariable Integer topicId) {
		return fourmMemberService.getTopicContent(petMembers, topicId);
	}
	
	@PutMapping("/myPage/UpdateOrDeleteTopic/{topicId}")
	public void UpdateOrDeleteTopic(@SessionAttribute(required = false) PetMembers petMembers
							,  @PathVariable Integer topicId
							, @RequestParam(name = "action") String action
							, @ModelAttribute Topic topic) {
		

		if("delete".equals(action)){
			fourmMemberService.deleteTopic(topicId);
		}else if("update".equals(action)){

			fourmMemberService.updateTopic(topic, topicId);
		}
	}
	
	@PutMapping("/myPage/UpdateFavorateCategory/{userId}")
	public void UpdateFavorateCategory(@SessionAttribute(required = false) PetMembers petMembers
			, @RequestBody List<Favorate> list, @PathVariable Integer userId) {
		fourmMemberService.refereshFavorateCategory(list, petMembers, userId);
	}
	
	@DeleteMapping("/myPage/removeThumbsUp/{type}/{userId}/{topicId}")
	public void removeThumbsUpViaMyPage(@SessionAttribute(required = false) PetMembers petMembers,
			@PathVariable Integer topicId, @PathVariable String type, @PathVariable Integer userId) {
		fourmMemberService.removeThumbsUp(type, topicId, petMembers, userId);
	}
	
	@DeleteMapping("/myPage/removeHistory/{topicId}")
	public void removeThumbsUpViaMyPage(@SessionAttribute(required = false) PetMembers petMembers,
			@PathVariable Integer topicId, @RequestParam Integer userId) {
		fourmMemberService.removeHistory(petMembers, topicId, userId);
	}
	
	@DeleteMapping("/myPage/removeFollow/{topicId}")
	public void removeFollowViaMyPage(@SessionAttribute(required = false) PetMembers petMembers,
			@PathVariable Integer topicId, @RequestParam Integer userId) {
	fourmMemberService.removeFollow(topicId, petMembers, userId);
	}
	
	@PutMapping("/myPage/notice/{noticeId}")
	public void updateIsReadStatusViaMyPage(@SessionAttribute(required = false) PetMembers petMembers, @PathVariable Integer noticeId) {
		fourmMemberService.updateIsReadStatus(noticeId);

	}
	
	@PutMapping("/myPage/notice")
	public void updateAllIsReadStatusViaMyPage(@SessionAttribute(required = false) PetMembers petMembers,  @RequestParam Integer userId) {
		fourmMemberService.updateAllIsReadStatus(petMembers, userId);

	}
	
	
}
