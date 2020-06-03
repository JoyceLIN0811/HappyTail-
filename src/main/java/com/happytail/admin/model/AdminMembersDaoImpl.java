package com.happytail.admin.model;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminMembersDaoImpl implements AdminMembersDao {

	@Autowired
	private SessionFactory factory;
	
	
	public Session getSession() {
		Session session = factory.getCurrentSession();
		return session;
	}
	
	//計算所有會員數
	@Override
	public Long countMembers() {
		String hql = "select count(*) from PetMembers";
		Query query = getSession().createQuery(hql);
		return (Long)query.uniqueResult();
	}

	//計算所有男性會員
	@Override
	public Long countMale() {
		Query query = getSession().createQuery("select count(*) from PetMembers p where p.gender=:gender");
		query.setParameter("gender", "M");
		return (Long)query.uniqueResult();
	}

	//所有女性會員
	@Override
	public Long countFemale() {
		Query query = getSession().createQuery("select count(*) from PetMembers p where p.gender=:gender");
		query.setParameter("gender", "F");
		return (Long)query.uniqueResult();
	}
	
	//會員年齡分布
	
	
	@Override
	public Integer changeMemberStatus(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
