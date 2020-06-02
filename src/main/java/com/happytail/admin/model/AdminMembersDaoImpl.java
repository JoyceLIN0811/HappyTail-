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
	
	@Override
	public Long countMembers() {
		String hql = "select count(*) from PetMembers";
		Query query = getSession().createQuery(hql);
		return (Long)query.uniqueResult();
	}

	
	@Override
	public Long countMale() {
		Query query = getSession().createQuery("select count(*) from PetMembers p where p.gender=:gender");
		query.setString("gender", "M");
		return (Long)query.uniqueResult();
	}

	@Override
	public Long countFemale() {
		Query query = getSession().createQuery("select count(*) from PetMembers p where p.gender=:gender");
		query.setString("gender", "F");
		return (Long)query.uniqueResult();
	}
	
	@Override
	public Integer changeMemberStatus(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
