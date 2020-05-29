package tw.pet.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import tw.pet.admin.dao.AdminMemberDao;
import tw.pet.model.PetMembers;

@Transactional
//@Service
@EnableTransactionManagement
public class AdminMemberService_impl implements AdminMemberService {

	@Autowired
	AdminMemberDao adminMemberDao;
	
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

	@Override
	public List<PetMembers> findAllMembers() {
		return adminMemberDao.findAllMembers();
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
