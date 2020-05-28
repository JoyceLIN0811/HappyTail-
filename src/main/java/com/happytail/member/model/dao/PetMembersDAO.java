package com.happytail.member.model.dao;

import java.util.List;

import com.happytail.member.model.PetMembers;





public interface PetMembersDAO {
	
	public PetMembers insertPetMembers(PetMembers petMembers);
	
	public PetMembers selectPetMembers(int memberId);
	
	public List<PetMembers> selectAllPetMembers();
	
//	public PetMembers updatePetMembers(int memberId, String email, String password, String username, String gender, 
//			Date bday, int age, String address, String phone, String petType, Blob memberImage, String fileName, Timestamp registerTime);
	
	public boolean deletePetMembers(int memberId);

	PetMembers selectPetMembers(String password, String username);

	PetMembers updatePetMembers(PetMembers petMember);

	PetMembers checkLogin(String memberId, String password);

	public String selectPetMembers(String username);
	
	
}
