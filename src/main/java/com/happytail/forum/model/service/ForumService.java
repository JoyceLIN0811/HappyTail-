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
import com.happytail.forum.model.ReplylistView;
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
import com.happytail.general.model.Notice;
import com.happytail.general.model.dao.CodeMapDAO;
import com.happytail.general.model.dao.NoticeDAO;
import com.happytail.general.util.Const;
import com.happytail.general.util.Const.ThumbsUpType;
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
	private FavorateDAO favorateDAO;

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

	@Autowired
	private NoticeDAO noticeDAO;

	// Forum Top

	// get category
	public List<CodeMap> getCategoryList() {
		String module = Const.ModuleType.Forum;
		String type = Const.CategoryType.topicCategory;

		return codeMapDAO.selectValueList(module, type);
	}

	// insert favorate category
	public void addFavorate(List<Favorate> list) {

		for (Favorate favorate : list) {
			favorateDAO.insert(favorate);
			System.out.println("insert favorate success");

		}

		System.out.println("insert favorate fail");
	}

	// get topiclist
	public Page<TopiclistView> getTopicList(PetMembers petMembers, Integer categoryId, PageInfo pageInfo) {

		if (categoryId != null) {

			if (petMembers == null) {
				return topiclistViewDAO.getCategoryTopiclist(categoryId, pageInfo);
			} else {
				Page<TopiclistView> result = topiclistViewDAO.getCategoryTopiclist(categoryId, pageInfo);
				
				setExtraColumn(result.getRecords(), petMembers.getId());

//				for (TopiclistView topicView : result.getRecords()) {
//
//					ThumbsUp thumbsUp = thumbsUpDAO.selectByTopic(topicView.getTopicId(), petMembers.getId());
//					topicView.setIsThumbsUp(thumbsUp != null);
//
//					Follow follow = followDAO.select(topicView.getTopicId(), petMembers.getId());
//					topicView.setIsFollowed(follow != null);
//
//					Report report = reportDAO.select(topicView.getTopicId(), petMembers.getId());
//					topicView.setIsReported(report != null);
//				}
				return result;
			}

		} else {
			if (petMembers != null) {

				List<Integer> list = favorateDAO.selectCategoryIdList(petMembers.getId());

				if (list.isEmpty()) {

					Page<TopiclistView> result = topiclistViewDAO.getAllTopiclist(pageInfo);
					
					setExtraColumn(result.getRecords(), petMembers.getId());


//					for (TopiclistView topicView : result.getRecords()) {
//
//						ThumbsUp thumbsUp = thumbsUpDAO.selectByTopic(topicView.getTopicId(), petMembers.getId());
//						topicView.setIsThumbsUp(thumbsUp != null);
//
//						Follow follow = followDAO.select(topicView.getTopicId(), petMembers.getId());
//						topicView.setIsFollowed(follow != null);
//
//						Report report = reportDAO.select(topicView.getTopicId(), petMembers.getId());
//						topicView.setIsReported(report != null);
//					}

					return result;

				} else {
					Page<TopiclistView> result = topiclistViewDAO.getFavorateCategoryTopiclist(list, pageInfo);
					
					setExtraColumn(result.getRecords(), petMembers.getId());


//					for (TopiclistView topicView : result.getRecords()) {
//
//						ThumbsUp thumbsUp = thumbsUpDAO.selectByTopic(topicView.getTopicId(), petMembers.getId());
//						topicView.setIsThumbsUp(thumbsUp != null);
//
//						Follow follow = followDAO.select(topicView.getTopicId(), petMembers.getId());
//						topicView.setIsFollowed(follow != null);
//
//						Report report = reportDAO.select(topicView.getTopicId(), petMembers.getId());
//						topicView.setIsReported(report != null);
//					}
					return result;
				}
			} else {

				return topiclistViewDAO.getAllTopiclist(pageInfo);

			}
		}

	}
	
	/**
	 * To set isThumbsUp, isFollowed and is Reported status
	 */
	private void setExtraColumn(List<TopiclistView> topiclistViewList,Integer userId) {
		for (TopiclistView topicView : topiclistViewList) {

			ThumbsUp thumbsUp = thumbsUpDAO.selectByTopic(topicView.getTopicId(), userId);
			topicView.setIsThumbsUp(thumbsUp != null);

			Follow follow = followDAO.select(topicView.getTopicId(), userId);
			topicView.setIsFollowed(follow != null);

			Report report = reportDAO.select(topicView.getTopicId(), userId);
			topicView.setIsReported(report != null);
		}
	}

	// get hit topiclist
	public Page<TopiclistView> getHitTopicList(Integer categoryId, PageInfo pageInfo) {

		if (categoryId != null) {
			return topiclistViewDAO.getHitCategoryTopiclist(categoryId, pageInfo);
		}

		return topiclistViewDAO.getHitAllTopiclist(pageInfo);
	}

	// get topic content
	public Topic getTopicContent(PetMembers petMembers, Integer topicId) {

		if (petMembers == null) {
			return topicDAO.select(topicId);
		} else {
			Topic topic = topicDAO.select(topicId);

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

	// get all reply
//	public Map<String, Object> getReplyList(PetMembers petMembers, Integer topicId, PageInfo pageInfo) {
//		Map<String, Object> map = new HashMap<>();
//		if (petMembers == null) {
//			Reply reply = replyDAO.selectByTopicId(topicId);
//			map.put("replyData", reply);
//		} else {
//			Reply reply = replyDAO.selectByTopicId(topicId);
//			map.put("replyData", reply);
//			ThumbsUp thumbsUp = thumbsUpDAO.selectByReply(topicId, reply.getId(), petMembers.getId());
//			map.put("isThumbsUp", thumbsUp != null);
//		}
//		return map;
//	}

	// get all reply
	public Page<ReplylistView> getReplyList(PetMembers petMembers, Integer topicId, PageInfo pageInfo) {

		if (petMembers == null) {
			return replylistViewDAO.getAllReplylist(topicId, pageInfo);
		} else {
			Page<ReplylistView> result = replylistViewDAO.getAllReplylist(topicId, pageInfo);

			for (ReplylistView replyView : result.getRecords()) {
				ThumbsUp thumbsUp = thumbsUpDAO.selectByReply(topicId, replyView.getReplyId(), petMembers.getId());
				replyView.setIsThumbsUp(thumbsUp != null);
			}

			return result;
		}

	}

	// get lastest 3 thumbsUp
	public List<String> getBriefThumbsUpList(Integer topicId, String type) {
		return thumbsUpViewDAO.selectBriefThumbsUp(topicId, type);
	}

	// TODO how to group by the ThumbsUp value?
	public List<ThumbsUpView> getThumbsUpList(Integer topicId) {
		return thumbsUpViewDAO.selectByTopicId(topicId);
	}

	// add topic
	public Topic addTopic(Topic topic) {
		return topicDAO.insert(topic);
	}

	// add reply
	public Reply addReply(Reply reply) {
		return replyDAO.insert(reply);
	}

	// add thumbsUp
	public ThumbsUp addThumbsUp(ThumbsUp thumbsUp, Integer replyId) {
		thumbsUp.setType((replyId == null) ? ThumbsUpType.topic : ThumbsUpType.reply);

		return thumbsUpDAO.insert(thumbsUp);

//		if (replyId != null) {
//			thumbsUp.setType(ThumbsUpType.reply);
//			thumbsUpDAO.insert(thumbsUp);
//			System.out.println("insert reply thumbsUp");
//		}
//		thumbsUp.setType(ThumbsUpType.topic);
//		thumbsUpDAO.insert(thumbsUp);
//		System.out.println("insert topic thumbsUp");
	}

	// add follow topic
	public Follow addFollowTopic(Follow follow) {
		return followDAO.insert(follow);
	}

	// add report
	public Report addReport(Report report) {
		return reportDAO.insert(report);
	}

	// delete thumbsUp
	public Boolean removeThumbsUp(Integer id) {
		return thumbsUpDAO.delete(id);
	}

	// update follow status
	public void removeFollow(Integer topicId, PetMembers petmembers) {

		Follow follow = followDAO.select(topicId, petmembers.getId());
		if (follow != null) {
			follow.setStatus(false);
			followDAO.update(follow);
			System.out.println("Update follow status");
		}

		System.out.println("Update fail");
	}

	// update per notice isRead status
	public void updateIsReadStatus(Notice notice) {
		notice.setIsRead(true);
		noticeDAO.update(notice);
	}

//	public Boolean removeReport(Integer id) {
//		return reportDAO.delete(id);
//	}

}
