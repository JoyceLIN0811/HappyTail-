package com.happytail.admin.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.happytail.admin.model.AdminMembersDao;
import com.happytail.admin.model.service.AdminMembersService;
import com.happytail.member.model.PetMembers;
import com.happytail.member.model.service.PetMembersService;


@Controller
public class AdminMemberController {

	@Autowired
	PetMembersService service;
	
	@Autowired
	PetMembers petMembers;
	
	@Autowired
	ServletContext context;
	
	@Autowired
	AdminMembersDao adDao;
	
	@Autowired
	AdminMembersService adMemberService;
	
	//回後臺首頁
	@GetMapping(value = "admin-Index")
	public String adminIndex(Model model) {
		Long countAll = adMemberService.countMembers();
		model.addAttribute("count",countAll);
		
		Long male = adMemberService.countMale();
		model.addAttribute("male", male);
		
		
		
		Long female = adMemberService.countFemale();
		model.addAttribute("female", female);
	
		System.out.println(male);
		return "adminIndex";
	}
	
	//選取所有會員資料
	@GetMapping(value = "admin-AllMembers")
	public String selectAllMembers(Model model) {
		List<PetMembers> members = service.selectAllPetMembers();
		model.addAttribute("allMembers",members);
		return "adminMembers";
	}
	
	//所有會員資料Json
	@GetMapping(value = "admin-allMembersJSON", produces= {"application/json"})
	public ResponseEntity<List<PetMembers>> queryAllMembersForJSON(Model model) {
		List<PetMembers> members = service.selectAllPetMembers();
		ResponseEntity<List<PetMembers>> re  = new ResponseEntity<>(members, HttpStatus.OK);
		return re;
	}
	

}
