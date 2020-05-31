package com.happytail.forum.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.happytail.forum.model.Favorate;
import com.happytail.forum.model.Follow;
import com.happytail.forum.model.Topic;
import com.happytail.forum.model.TopiclistView;
import com.happytail.forum.model.dao.FavorateDAO;
import com.happytail.forum.model.dao.FollowDAO;
import com.happytail.forum.model.dao.ThumbsUpDAO;
import com.happytail.forum.model.dao.TopicDAO;
import com.happytail.forum.model.dao.TopiclistViewDAO;
import com.happytail.general.model.Notice;
import com.happytail.general.model.dao.NoticeDAO;
import com.happytail.general.util.Page;
import com.happytail.general.util.PageInfo;
import com.happytail.member.model.PetMembers;
import com.happytail.member.model.dao.PetMembersDAO;

@Service
@Transactional
public class FourmMemberService {
	
	@Autowired
	private PetMembersDAO petMembersDAO;

	@Autowired
	private TopiclistViewDAO topiclistViewDAO;

	@Autowired
	private FollowDAO followDAO;

	@Autowired
	private ThumbsUpDAO thumbsUpDAO;

	@Autowired
	private FavorateDAO favorateDAO;

	@Autowired
	private NoticeDAO noticeDAO;

	@Autowired
	private TopicDAO topicDAO;

	// get my topiclist
	public Page<TopiclistView> getMemberIdTopiclist(Integer userId, PageInfo pageInfo) {
		return topiclistViewDAO.getMemberIdTopiclist(userId, pageInfo);
	}

	// get my followlist
	public Page<TopiclistView> getMyFollowlist(Integer userId, PageInfo pageInfo) {

		List<Integer> list = followDAO.selectTopicIdList(userId);
		return topiclistViewDAO.getFollowOrThumbsUplist(list, pageInfo);
	}

	// get my thumbsUplist
	public Page<TopiclistView> getMyThumbsUplist(Integer userId, String type, PageInfo pageInfo) {
		List<Integer> list = thumbsUpDAO.selectTopicIdList(userId, type);
		return topiclistViewDAO.getFollowOrThumbsUplist(list, pageInfo);
	}

	// get my favorate category
	public List<Favorate> getMyFavorateCategory(Integer userId) {
		List<Favorate> list = favorateDAO.selectFavorateCategoryList(userId);
		return list;
	}

	// get all my forum notice
	public List<Notice> getAllMyForumNotice(String module) {
		List<Notice> list = noticeDAO.selectByModule(module);
		return list;
	}

	// get topic content
	public Topic getTopicContent(PetMembers petMembers, Integer id) {

		return topicDAO.select(id);
	}

	// update topic
	public void updateTopic(Topic topic) {

		topicDAO.update(topic);
	}

	// delete topic
	public void deleteTopic(Integer id) {

		topicDAO.delete(id);
	}

	// update my favorate category(via delete all and save again)
	public void refereshFavorateCategory(List<Favorate> list, PetMembers petmembers) {

		favorateDAO.delete(petmembers.getId());

		for (Favorate favorate : list) {
			favorateDAO.insert(favorate);
		}
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

	// update per notice isRead status
	public void updateAllIsReadStatus(PetMembers petMembers) {
		
		Notice notice  = noticeDAO.selectByUserId(petMembers.getId());
		notice.setIsRead(true);
		noticeDAO.update(notice);
	}

}
