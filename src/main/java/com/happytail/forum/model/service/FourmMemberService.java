package com.happytail.forum.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.happytail.forum.model.TopiclistView;
import com.happytail.forum.model.dao.TopiclistViewDAO;
import com.happytail.general.util.Page;
import com.happytail.general.util.PageInfo;

@Service
@Transactional
public class FourmMemberService {
	
	@Autowired
	private TopiclistViewDAO topiclistViewDAO;
	
	public Page<TopiclistView> getMemberIdTopiclist(PageInfo pageInfo, Integer memberId) {
		return topiclistViewDAO.getCategoryTopiclist(pageInfo, memberId);
	}

}
