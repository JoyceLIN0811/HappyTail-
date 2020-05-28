package com.happytail.member.model.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happytail.member.model.PetMembers;

@Repository
public class PetMembersDAOImpl implements PetMembersDAO  {
	
	@Autowired
	private SessionFactory factory;
	
	
	public Session getSession() {
		Session session = factory.getCurrentSession();
		return session;
	}	
	
	@Override
	public PetMembers checkLogin(String username,String password) {
		
		PetMembers result = selectPetMembers(username, password);
	
			return result;	
	}
	
	
	
	
	@Override
	public PetMembers insertPetMembers(PetMembers petMembers) {
		
		Query<PetMembers> query = getSession().createQuery("From PetMembers where username=:username", PetMembers.class);
		query.setParameter("username", petMembers.getUsername());
		PetMembers bean = (PetMembers) query.uniqueResult();
		if(bean == null) {
			petMembers.setRegisterTime(new Timestamp(System.currentTimeMillis()));
			getSession().save(petMembers);
			return petMembers;
		}
		
		return null;
	}
	
	@Override
	public PetMembers selectPetMembers(int memberId) {		
		
		return getSession().get(PetMembers.class , memberId);
	}
	
	@Override
	public String selectPetMembers(String username) {
		Query<PetMembers> query = getSession().createQuery("From PetMembers where username=:username", PetMembers.class);
		query.setParameter("username", username);
		PetMembers bean = (PetMembers) query.uniqueResult();
		if(bean == null) {
			return null;
		}
		return bean.getUsername();
	}
	
	@Override
	public PetMembers selectPetMembers(String username, String password) {		
		
		Query<PetMembers> query = getSession().createQuery("from PetMembers where username=?1 and password=?2", PetMembers.class);
		query.setParameter(1, username);
		query.setParameter(2, password);
		System.out.println(username + "  " + password);
		PetMembers result = null;
		try {
			result = (PetMembers) query.getSingleResult();
		}catch(NoResultException nre) {
			nre.printStackTrace();
			return result;
		}
		
		return result;
	}
	
	@Override
	public List<PetMembers> selectAllPetMembers() {
		
		Query<PetMembers> query = getSession().createQuery("from PetMembers", PetMembers.class);
		List<PetMembers> list = query.list();
		return list;
		
	}
	
	@Override
	public PetMembers updatePetMembers(PetMembers petMember) {
		
		PetMembers pMember = getSession().get(PetMembers.class, petMember.getMemberId());
		
		if(pMember != null) {
			pMember.setEmail(petMember.getEmail());
			pMember.setPassword(petMember.getPassword());
			pMember.setUsername(petMember.getUsername());
			pMember.setGender(petMember.getGender());
			pMember.setBday(petMember.getBday());
			pMember.setAge(petMember.getAge());
			pMember.setAddress(petMember.getAddress());
			pMember.setPhone(petMember.getPhone()); 
//			pMember.setPetType(petMember.getPetType());
			pMember.setMemberImage(petMember.getMemberImage());
			pMember.setFileName(petMember.getFileName());
			
			getSession().update(pMember);
		}
		
		return petMember;
	}
	
	@Override
	public boolean deletePetMembers(int memberId) {
		PetMembers petMember = getSession().get(PetMembers.class, memberId);
		
		if(petMember!=null) {
			getSession().delete(petMember);
			return true;
		}
		
		return false;
	}	
	
	
}
