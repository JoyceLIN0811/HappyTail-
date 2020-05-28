package com.happytail.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.happytail.member.model.PetMembers;
import com.happytail.member.model.service.PetMembersService;

@Controller
public class LoginController {	
	
	@Autowired
	PetMembersService service;
	
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String processLogin() {
		return "Member/memberLogin";
//		return "Member/login";
	}
	
	@PostMapping(value = "/loginCheck")
	public String checkLogin(
			@RequestParam(name="account") String account,
			@RequestParam(name="password") String password,

			HttpServletRequest request
	
		) {		
		HttpSession session = request.getSession();
		
		Map<String, String> errorMsg = new HashMap<String, String>();
		request.setAttribute("ErrorMsg", errorMsg);
		
		if(account == null || account.trim().length() == 0) {
			errorMsg.put("accountError", "帳號欄不可空白");
		}
		
		if(password == null || password.trim().length() == 0) {
			errorMsg.put("passwordError", "密碼欄不可空白");
		}
		
		if (!errorMsg.isEmpty() ) {
			return "Member/memberLogin";
		}
		

		
		PetMembers pMember = service.checkLogin(account, password);
		
			if( pMember != null) {
				session.setAttribute("LoginOK", pMember);
				return "../../index";
			
			}else {
				errorMsg.put("LoginError", "帳號或密碼錯誤");
			}
		
			if (!errorMsg.isEmpty()) {
				return "Member/memberLogin";
			}
		
		return "../../index";
		
	}
	
	@GetMapping(value = "/logoutCheck")
	public String Logout(HttpServletRequest request ) {
				
		HttpSession session = request.getSession(false);
		
		session.invalidate();
		
		return "index";
	}
	
}
