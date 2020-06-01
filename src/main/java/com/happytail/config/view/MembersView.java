package com.happytail.config.view;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.RedirectView;

@Configuration
public class MembersView {
	
	@Bean
	public View petMemberIndex() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/index.jsp");
		return view;	
	}
	
	@Bean
	public View petMemberPage() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/Member/memberRegister.jsp");
		return view;	
	}
	
	@Bean
	public View sendTemporaryPassword() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/Member/sendTemporaryPassword_1.jsp");
		return view;	
	}
	
	@Bean
	public View temporaryPetMemberPage1() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/Member/sendTemporaryPassword_1.jsp");
		return view;	
	}
	
	@Bean
	public View temporaryPetMemberPage2() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/Member/sendTemporaryPassword_2.jsp");
		return view;	
	}
	
	@Bean
	public View changePassword() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/Member/changePassword.jsp");
		return view;	
	}
	
	@Bean
	public View verificationSuccess() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/Member/verificationSuccess.jsp");
		return view;	
	}
	
	@Bean
	public View verificationFail() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/Member/verificationFail.jsp");
		return view;	
	}
	
	@Bean
	public View memberLogin() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/Member/memberLogin.jsp");
		return view;	
	}
	
	@Bean
	public View memberCRUD() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/Member/member_CRUD.jsp");
		return view;	
	}

}
