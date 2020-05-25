package com.happytail.member.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happytail.forum.model.Reply;
import com.happytail.member.model.PetMembers;

@Repository
public class PetMembersDAOImpl implements PetMembersDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

	public PetMembersDAOImpl() {

	}

	private final String saveMember = "FROM PetMembers WHERE email=:email";
	private final String checkIDPassword = "FROM PetMembers WHERE email=:email and password=:password";

	@Override
	public PetMembers insert(PetMembers petMembers) {
		Query<PetMembers> query = getSession().createQuery(saveMember, PetMembers.class);
		petMembers = query.setParameter("email", petMembers.getEmail()).uniqueResult();

		try {
			if (petMembers == null) {
				getSession().save(petMembers);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Insert fail");
			return null;
		}
		return petMembers;
	}

	@Override
	public boolean delete(Integer id) {
		try {
			if (id != null) {
				getSession().delete(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Delete fail");
			return false;
		}
		return true;
	}

	@Override
	public PetMembers update(PetMembers petMembers) {
		try {
			if(petMembers != null) {
				getSession().update(petMembers);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Update fail");
			return null;
		}
		return petMembers;
	}

	@Override
	public PetMembers select(Integer id) {
		PetMembers petMembers = null;
		try {
			petMembers = getSession().get(PetMembers.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No result");
			return null;
		}
		return petMembers;
	}

	@Override
	public PetMembers checkIDPassword(String email, String password) {
		Query<PetMembers> check = getSession().createQuery(checkIDPassword,PetMembers.class);
		check.setParameter(1, email);
		check.setParameter(2, password);
		List<PetMembers> list = check.list();

		if (list == null || list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
	}

}
