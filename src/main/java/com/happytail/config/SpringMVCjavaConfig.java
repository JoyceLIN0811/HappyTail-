package com.happytail.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.BeanNameViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.happytail.forum.controller",
		"com.happytail.shop.controller",
		"com.happytail.reservation.controller",
		"com.happytail.admin.controller",
		"com.happytail.member.controller",
		"com.happytail.general.controller"})
@Import({com.happytail.config.view.ReservationView.class})
public class SpringMVCjavaConfig implements WebMvcConfigurer {

	//Static Resources
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		System.out.println("test!!");
		registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/static/css/");
		registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/static/js/");
		registry.addResourceHandler("/img/**").addResourceLocations("/WEB-INF/static/img/");
		registry.addResourceHandler("/template/**").addResourceLocations("/WEB-INF/pages/template/");
	}
	
	// for file upload
	@Bean
//	public MultipartResolver multipartResolver() {
//		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
//		resolver.setDefaultEncoding("UTF-8");
//		resolver.setMaxUploadSize(81920000);
//		return resolver;
//	}
	
	public MultipartResolver multipartResolver() {
		StandardServletMultipartResolver resolver = new StandardServletMultipartResolver();
		return resolver;
	}
	
	
	//ViewResolver
	@Bean
	public ViewResolver beanNameViewResolver() {
		BeanNameViewResolver bnvr = new BeanNameViewResolver();
		return bnvr;
	}
	
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasenames("MemberMessage", "ValidationMessages");
		return messageSource;
	}
	
}
