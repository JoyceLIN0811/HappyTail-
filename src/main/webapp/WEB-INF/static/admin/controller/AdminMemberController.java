package tw.pet.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tw.pet.model.PetMembers;
import tw.pet.service.PetMembersService;

@Controller
@RequestMapping(value = "adminMember")
public class AdminMemberController {
	
	@Autowired
	PetMembersService petMembersService;
	
	//返回後台管理主頁
	@GetMapping("/adminIndex")
	public String adminIndex() {
		return "admin_index";
	}
	
	@GetMapping(value = "/selectMembers", produces = {"text/html"})
	public String selectAllMembers(Model model) {
		List<PetMembers> members = petMembersService.selectAllPetMembers();
		model.addAttribute("AllMembers",members);
		return "admin_members";
	}

}
