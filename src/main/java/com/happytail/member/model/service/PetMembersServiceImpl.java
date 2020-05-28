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
	public PetMembers checkLogin(String account,String password) {
		
		PetMembers petMember = petMembersDAO.selectPetMembers(account, password);
	
			return petMember;	
	}
	
	
	@Override
	public PetMembers insertPetMembers(PetMembers petMembers) {	
			
		PetMembers	petMember = petMembersDAO.insertPetMembers(petMembers);			
		
		return petMember;	
	}

	@Override
	public PetMembers selectPetMembers(Integer memberId) {
		
		PetMembers petMember = petMembersDAO.selectPetMembers(memberId);
	
		return  petMember;
	}
	
	@Override
	public String selectPetMembers(String account) {
		
		String petMember = petMembersDAO.selectPetMembers(account);
	
		return  petMember;
	}
	
	@Override
	public PetMembers selectPetMembers(String password, String account) {
		
		PetMembers petMember = petMembersDAO.selectPetMembers(password,account);
		
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
	public boolean deletePetMembers(Integer memberId) {
		
		boolean result = petMembersDAO.deletePetMembers(memberId);
		
		return result;
	}
	
	

}
