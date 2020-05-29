package com.happytail.forum.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.happytail.forum.model.Favorate;
import com.happytail.forum.model.Follow;
import com.happytail.forum.model.Reply;
import com.happytail.forum.model.Report;
import com.happytail.forum.model.ThumbsUp;
import com.happytail.forum.model.ThumbsUpView;
import com.happytail.forum.model.Topic;
import com.happytail.forum.model.TopiclistView;
import com.happytail.forum.model.dao.FavorateDAO;
import com.happytail.forum.model.dao.FollowDAO;
import com.happytail.forum.model.dao.HitDAO;
import com.happytail.forum.model.dao.ReplyDAO;
import com.happytail.forum.model.dao.ReplylistViewDAO;
import com.happytail.forum.model.dao.ReportDAO;
import com.happytail.forum.model.dao.ThumbsUpDAO;
import com.happytail.forum.model.dao.ThumbsUpViewDAO;
import com.happytail.forum.model.dao.TopicDAO;
import com.happytail.forum.model.dao.TopicImageDAO;
import com.happytail.forum.model.dao.TopiclistViewDAO;
import com.happytail.general.model.CodeMap;
import com.happytail.general.model.dao.CodeMapDAO;
import com.happytail.general.util.Const;
import com.happytail.general.util.Page;
import com.happytail.general.util.PageInfo;
import com.happytail.member.model.PetMembers;
import com.happytail.member.model.dao.PetMembersDAO;

@Service
@Transactional
public class ForumService {

	@Autowired
	private PetMembersDAO petMembersDAO;

	@Autowired
	private TopicDAO topicDAO;

	@Autowired
	private TopicImageDAO topicImageDAO;

	@Autowired
	private TopiclistViewDAO topiclistViewDAO;

	@Autowired
	private HitDAO hitDAO;

	@Autowired
	private CodeMapDAO codeMapDAO;
	
	@Autowired
	private	FavorateDAO favorateDAO;

	@Autowired
	private ThumbsUpDAO thumbsUpDAO;

	@Autowired
	private ThumbsUpViewDAO thumbsUpViewDAO;

	@Autowired
	private FollowDAO followDAO;

	@Autowired
	private ReportDAO reportDAO;

	@Autowired
	private ReplylistViewDAO replylistViewDAO;

	@Autowired
	private ReplyDAO replyDAO;

	// Forum Top

	//get category
	public List<CodeMap> getCategoryList() {
		String module = Const.ModuleType.Forum;
		String type = Const.CategoryType.topicCategory;

		return codeMapDAO.selectValueList(module, type);
	}
	
	//insert favorate category
	public void addFavorate(PetMembers petMembers) {
		Favorate favorate = favorateDAO.selectByUserId(petMembers.getId());
		if(petMembers != null && favorate == null) {
			favorateDAO.insert(favorate);
			System.out.println("insert favorate");
		}
		System.out.println("insert fail");
	}

	public Page<TopiclistView> getTopicList(PageInfo pageInfo, Integer categoryId) {

		if (categoryId != null) {
			return topiclistViewDAO.getCategoryTopiclist(pageInfo, categoryId);
		}
		return topiclistViewDAO.getAllTopiclist(pageInfo);
	}

	public Page<TopiclistView> getHitTopicList(PageInfo pageInfo, Integer categoryId) {

		if (categoryId != null) {
			return topiclistViewDAO.getHitCategoryTopiclist(pageInfo, categoryId);
		}

		return topiclistViewDAO.getHitAllTopiclist(pageInfo);
	}

	public Topic getTopicContent(PetMembers petMembers, Integer id) {

		if (petMembers == null) {
			return topicDAO.select(id);
		} else {
			Topic topic = topicDAO.select(id);

			ThumbsUp thumbsUp = thumbsUpDAO.selectByTopic(topic.getId(), petMembers.getId());
			topic.setIsThumbsUp(thumbsUp != null);

			Follow follow = followDAO.select(topic.getId(), petMembers.getId());
			topic.setIsFollowed(follow != null);

			Report report = reportDAO.select(topic.getId(), petMembers.getId());
			topic.setIsReported(report != null);

			return topic;
		}
	}

	public Map<String, Object> getTopic(PetMembers petMembers, Integer id) {
		Map<String, Object> map = new HashMap<>();
		if (petMembers == null) {
			Topic topic = topicDAO.select(id);
			map.put("topicData", topic);
		} else {

			Topic topic = topicDAO.select(id);
			map.put("topicData", topic);
			ThumbsUp thumbsUp = thumbsUpDAO.selectByTopic(topic.getId(), petMembers.getId());
			map.put("isThumbsUp", thumbsUp != null);

			Follow follow = followDAO.select(topic.getId(), petMembers.getId());
			map.put("isFollowed", follow != null);

			Report report = reportDAO.select(topic.getId(), petMembers.getId());
			map.put("isReported", report != null);
		}
		return map;
	}

	public Map<String, Object> getReplyList(PetMembers petMembers, Integer topicId, PageInfo pageInfo) {
		Map<String, Object> map = new HashMap<>();
		if (petMembers == null) {
			Reply reply = replyDAO.selectByTopicId(topicId);
			map.put("replyData", reply);
		} else {
			Reply reply = replyDAO.selectByTopicId(topicId);
			map.put("replyData", reply);
			ThumbsUp thumbsUp = thumbsUpDAO.selectByReply(topicId, reply.getId(), petMembers.getId());
			map.put("isThumbsUp", thumbsUp != null);
		}
		return map;
	}

	public List<String> getBriefThumbsUpList(Integer topicId, String type) {
		return thumbsUpViewDAO.selectBriefThumbsUp(topicId, type);
	}

	// TODO how to group by the ThumbsUp value?
	public List<ThumbsUpView> getThumbsUpList(Integer topicId) {
		return thumbsUpViewDAO.selectByTopicId(topicId);
	}

	public Reply addReply(Reply reply) {
		return replyDAO.insert(reply);
	}

	public ThumbsUp addThumbsUp(ThumbsUp thumbsUp) {
		return thumbsUpDAO.insert(thumbsUp);
	}

	public Boolean removeThumbsUp(Integer id) {
		return thumbsUpDAO.delete(id);
	}

	public Follow addFollowTopic(Follow follow) {
		return followDAO.insert(follow);
	}

	public void removeFollow(Integer topicId, PetMembers petmembers) {

		Follow follow = followDAO.select(topicId, petmembers.getId());
		if (follow != null) {
			follow.setStatus(false);
			followDAO.update(follow);
			System.out.println("Update follow status");
		}

		System.out.println("Update fail");
	}

	public Report addReport(Report report) {
		return reportDAO.insert(report);
	}

//	public Boolean removeReport(Integer id) {
//		return reportDAO.delete(id);
//	}

}
