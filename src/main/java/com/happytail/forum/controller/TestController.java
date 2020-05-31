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
	public List<CodeMap> CategoryList(){
		return forumService.getCategoryList();
	}
	
	@PostMapping("/insertFavorateCategory")
	public Map<String, String> insertFavorateCategory(@RequestBody List<Favorate> list) {
		Map<String, String> map = new HashMap<String, String>();
		forumService.addFavorate(list);
		map.put("insert", "success");
		return map;
	}
	
	@GetMapping("/topic/topiclist")
	public Page<TopiclistView> getTopicList(@SessionAttribute(required = false) PetMembers petMembers
											, @RequestParam(required = false) Integer categoryId
											, @RequestParam Integer pageSize
											, @RequestParam Integer pageNum
											, @RequestParam(name = "tagType") String tagType){
		if("hit".equals(tagType)){
			return forumService.getHitTopicList(categoryId, new PageInfo(pageSize, pageNum));
		}else {
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
	public Topic TopicContent(@SessionAttribute(required = false) PetMembers petMembers, @PathVariable Integer topicId) {
		return forumService.getTopicContent(petMembers, topicId);
	}
	
	@GetMapping("/reply")
	public Page<ReplylistView> ReplyList(@SessionAttribute(required = false) PetMembers petMembers
										, @RequestParam Integer topicId
										, @RequestParam Integer pageSize
										, @RequestParam Integer pageNum){
		
		return forumService.getReplyList(petMembers, topicId, new PageInfo(pageSize, pageNum));
	}

	@GetMapping("/thumbsUp")
	public List<ThumbsUpView> ThumbsUpList(@RequestParam Integer topicId){
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
	public ThumbsUp addThumbsUp(@ModelAttribute ThumbsUp thumbsUp, @RequestParam(required = false)  Integer replyId) {
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
	
//	@DeleteMapping("/thumbsUp/{userId}/{topicId}/{REPLYiD}")
	
	
//	@GetMapping("/topic/topiclist1")
//	public Page<TopiclistView> getTopicList1(@SessionAttribute PetMembers petMembers
//			, @RequestParam Map<String,Object> paramMap){
//		
//		Integer.valueOf(String.valueOf(paramMap.get("categoryId")));
//		
//		return null;
//	}
	
	
	

	
	

}
