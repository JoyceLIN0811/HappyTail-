package tw.pet.admin.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import tw.pet.model.PetMembers;



@Repository
public interface AdminMemberDao {
	PetMembers findByPrimaryKey(int key);

	PetMembers findByName(String name);

	int saveMember(PetMembers member);

	void updateMember(PetMembers member);

	void deleteMemberByPrimaryKey(int key);

	List<PetMembers> findAllMembers();

	void deleteAllMembers();

	public boolean isMemberExist(PetMembers member);
	
	public String checkMemberId(String memberId);

}
