package com.happytail.member.model.dao;

import com.happytail.member.model.PetMembers;

public interface PetMembersDAO {

	public PetMembers insert(PetMembers petMembers);

	public boolean delete(Integer id);

	public PetMembers update(PetMembers petMembers);

	public PetMembers select(Integer id);
	
	public PetMembers checkIDPassword(String email, String password);
}
