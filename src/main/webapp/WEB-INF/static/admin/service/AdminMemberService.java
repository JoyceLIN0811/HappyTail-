package tw.pet.admin.service;

import java.util.List;

import tw.pet.model.PetMembers;

public interface AdminMemberService {
	PetMembers findByPrimaryKey(int key);

	PetMembers findByName(String name);

	int saveMember(PetMembers member);

	void updateMember(PetMembers member);

	void deleteMemberByPrimaryKey(int key);

	List<PetMembers> findAllMembers();

	void deleteAllMembers();

	public boolean isMemberExist(PetMembers member);
	
	String checkMemberId(String memberId);

	
}
