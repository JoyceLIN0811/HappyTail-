package com.happytail.forum.model.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happytail.forum.model.TopiclistView;
import com.happytail.general.util.Page;
import com.happytail.general.util.PageInfo;

@Repository
public class TopiclistViewDAOImpl implements TopiclistViewDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

	public TopiclistViewDAOImpl() {

	}

	private final String SelectAllTopic = "FROM com.happytail.forum.model.TopiclistView ORDER BY createTime DESC";
	private final String SelectByCategoryId = "FROM com.happytail.forum.model.TopiclistView WHERE categoryId=:categoryId ORDER BY createTime DESC";
	private final String SelectByMemberId = "FROM com.happytail.forum.model.TopiclistView WHERE memberId=:memberId ORDER BY createTime DESC";
	private final String SelectHitAllTopic = "FROM com.happytail.forum.model.TopiclistView ORDER BY count DESC";
	private final String SelectHitCategoryTopic = "FROM com.happytail.forum.model.TopiclistView WHERE categoryId=:categoryId ORDER BY count DESC";
	private final String AllTopicCounts = "SELECT COUNT(*) FROM com.happytail.forum.model.TopiclistView";
	private final String CategoryTopicCounts = "SELECT COUNT(*) FROM com.happytail.forum.model.TopiclistView WHERE categoryId=:categoryId";
	private final String MyTopicCounts = "SELECT COUNT(*) FROM com.happytail.forum.model.TopiclistView WHERE memberId=:memberId";

	@Override
	public Page<TopiclistView> getAllTopiclist(PageInfo pageInfo) {

		Integer startPosition = pageInfo.getPageSize() * (pageInfo.getPageNum() - 1);
		List<TopiclistView> resultList = getSession()
				.createQuery(SelectAllTopic, TopiclistView.class)
				.setFirstResult(startPosition)
				.setMaxResults(pageInfo.getPageSize())
				.getResultList();
		Query query = getSession().createQuery(AllTopicCounts);
		Long totalCount = (Long) query.uniqueResult();

		return new Page<TopiclistView>(resultList, pageInfo.getPageNum(), pageInfo.getPageSize(), totalCount);
	}

	@Override
	public Page<TopiclistView> getCategoryTopiclist(PageInfo pageInfo,Integer categoryId) {

		Integer startPosition = pageInfo.getPageSize() * (pageInfo.getPageNum() - 1);
		List<TopiclistView> resultList = getSession()
				.createQuery(SelectByCategoryId, TopiclistView.class)
				.setParameter("categoryId", categoryId)
				.setFirstResult(startPosition)
				.setMaxResults(pageInfo
						.getPageSize())
				.getResultList();
		Query query = getSession().createQuery(CategoryTopicCounts);
		Long totalCount = (Long) query.uniqueResult();

		return new Page<TopiclistView>(resultList, pageInfo.getPageNum(), pageInfo.getPageSize(), totalCount);
	}

	@Override
	public Page<TopiclistView> getMemberIdTopiclist(PageInfo pageInfo, Integer memberId) {
		Integer startPosition = pageInfo.getPageSize() * (pageInfo.getPageNum() - 1);
		List<TopiclistView> resultList = getSession()
				.createQuery(SelectByMemberId, TopiclistView.class)
				.setParameter("memberId", memberId)
				.setFirstResult(startPosition)
				.setMaxResults(pageInfo
				.getPageSize())
				.getResultList();
		Query query = getSession().createQuery(MyTopicCounts);
		Long totalCount = (Long) query.uniqueResult();

		return new Page<TopiclistView>(resultList, pageInfo.getPageNum(), pageInfo.getPageSize(), totalCount);
	}
	
	@Override
	public Page<TopiclistView> getHitAllTopiclist(PageInfo pageInfo) {

		Integer startPosition = pageInfo.getPageSize() * (pageInfo.getPageNum() - 1);
		List<TopiclistView> resultList = getSession()
				.createQuery(SelectHitAllTopic, TopiclistView.class)
				.setFirstResult(startPosition)
				.setMaxResults(pageInfo.getPageSize())
				.getResultList();
		Query query = getSession().createQuery(AllTopicCounts);
		Long totalCount = (Long) query.uniqueResult();

		return new Page<TopiclistView>(resultList, pageInfo.getPageNum(), pageInfo.getPageSize(), totalCount);
	}
	
	@Override
	public Page<TopiclistView> getHitCategoryTopiclist(PageInfo pageInfo,Integer categoryId) {

		Integer startPosition = pageInfo.getPageSize() * (pageInfo.getPageNum() - 1);
		List<TopiclistView> resultList = getSession()
				.createQuery(SelectHitCategoryTopic, TopiclistView.class)
				.setParameter("categoryId", categoryId)
				.setFirstResult(startPosition)
				.setMaxResults(pageInfo
						.getPageSize())
				.getResultList();
		Query query = getSession().createQuery(CategoryTopicCounts);
		Long totalCount = (Long) query.uniqueResult();

		return new Page<TopiclistView>(resultList, pageInfo.getPageNum(), pageInfo.getPageSize(), totalCount);
	}


	@Override
	public Long allTopicCounts() {
		Long count = null;
		try {
			Query query = getSession().createQuery(AllTopicCounts);
			count = (Long) query.uniqueResult();
		} catch (Exception e) {
			return null;
		}
		return count;
	}

	@Override
	public Long categoryTopicCounts(Integer categoryId) {
		Long count = null;
		try {
			Query query = getSession().createQuery(CategoryTopicCounts);
			count = (Long) query.uniqueResult();
		} catch (Exception e) {
			return null;
		}
		return count;
	}

	@Override
	public Long myTopicCounts(Integer memberId) {
		Long count = null;
		try {
			Query query = getSession().createQuery(MyTopicCounts);
			count = (Long) query.uniqueResult();
		} catch (Exception e) {
			return null;
		}
		return count;
	}

//	@Override
//	public List<TopiclistView> select() {
//		List<TopiclistView> list = null;
//		try {
//			list = getSession().createQuery(selectAllTopic, TopiclistView.class).list();
//		} catch (Exception e) {
//			return null;
//		}
//		return list;
//	}
//
//	@Override
//	public List<TopiclistView> selectByCategoryId(Integer categoryId) {
//		List<TopiclistView> list = null;
//		try {
//			list = getSession().createQuery(SelectByCategoryId, TopiclistView.class)
//					.setParameter("categoryId", categoryId).getResultList();
//		} catch (Exception e) {
//			return null;
//		}
//		return list;
//	}
//
//	@Override
//	public List<TopiclistView> selectByMemberId(Integer memberId) {
//		List<TopiclistView> list = null;
//		try {
//			list = getSession().createQuery(selectByMemberId, TopiclistView.class).setParameter("memberId", memberId)
//					.getResultList();
//		} catch (Exception e) {
//			return null;
//		}
//		return list;
//	}

}
