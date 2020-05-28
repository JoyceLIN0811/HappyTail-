package com.happytail.member.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.happytail.member.model.PetMembers;
import com.happytail.member.model.dao.PetMembersDAO;

@Service
@Transactional
public class PetMembersServiceImpl implements PetMembersService{
	
	@Autowired
	private PetMembersDAO petMembersDAO;	

	
	
	@Override
	public PetMembers checkLogin(String username,String password) {
		
		PetMembers petMember = petMembersDAO.selectPetMembers(username, password);
	
			return petMember;	
	}
	
	
	@Override
	public PetMembers insertPetMembers(PetMembers petMembers) {	
			
		PetMembers	petMember = petMembersDAO.insertPetMembers(petMembers);			
		
		return petMember;	
	}

	@Override
	public PetMembers selectPetMembers(int memberId) {
		
		PetMembers petMember = petMembersDAO.selectPetMembers(memberId);
	
		return  petMember;
	}
	
	@Override
	public String selectPetMembers(String username) {
		
		String petMember = petMembersDAO.selectPetMembers(username);
	
		return  petMember;
	}
	
	@Override
	public PetMembers selectPetMembers(String password, String username) {
		
		PetMembers petMember = petMembersDAO.selectPetMembers(password,username);
		
		return  petMember;
	}

	@Override
	public List<PetMembers> selectAllPetMembers() {
		
		List<PetMembers> list = petMembersDAO.selectAllPetMembers();
		
		return list;
	}

	@Override
	public PetMembers updatePetMembers(PetMembers petMember) {
		
		PetMembers pMember = petMembersDAO.updatePetMembers(petMember);
		
		return pMember; 
	}

	@Override
	public boolean deletePetMembers(int memberId) {
		
		boolean result = petMembersDAO.deletePetMembers(memberId);
		
		return result;
	}
	
	

}
