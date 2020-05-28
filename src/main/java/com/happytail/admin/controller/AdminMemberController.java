package com.happytail.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.happytail.member.model.PetMembers;
import com.happytail.member.model.service.PetMembersService;

@Controller
public class AdminMemberController {

	@Autowired
	PetMembersService service;
	
	@Autowired
	PetMembers petMembers;
	
	//回後臺首頁
	@GetMapping(value = "adminIndex")
	public String adminIndex() {
		return "admin-index";
	}
	
	//選取所有會員資料
	@GetMapping(value = "/selectMembers")
	public String selectAllMembers(Model model) {
		List<PetMembers> members = service.selectAllPetMembers();
		model.addAttribute("allMembers",members);
		for(PetMembers pm:members) {
			System.out.println(pm.getUsername() + " " + pm.getGender() + " " + pm.getStatus());
		}
		return "admin-members";
	}
}
