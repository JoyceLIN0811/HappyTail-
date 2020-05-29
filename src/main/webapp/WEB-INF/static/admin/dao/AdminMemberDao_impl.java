package tw.pet.admin.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.pet.model.PetMembers;

@Repository
public class AdminMemberDao_impl implements AdminMemberDao {

	@Autowired
	SessionFactory factory;
	
	@Override
	public PetMembers findByPrimaryKey(int key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PetMembers findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int saveMember(PetMembers member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateMember(PetMembers member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMemberByPrimaryKey(int key) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PetMembers> findAllMembers() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Member";
		List<PetMembers> list = session.createQuery(hql).getResultList();
		return list;
	}

	@Override
	public void deleteAllMembers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isMemberExist(PetMembers member) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String checkMemberId(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}

}
