package com.happytail.config.view;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.RedirectView;

@Configuration
public class MembersView {

	@Bean
	public View PetMemberPage() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/Member/memberRegister.jsp");
		return view;	
	}
	
	

}
