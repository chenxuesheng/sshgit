package com.sino.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sino.model.User;
import com.sino.service.UserServcie;

public class SpringContext {
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		
		UserServcie service = (UserServcie) ac.getBean("userServiceImpl");		
		
		User user = service.getById("001");
		System.out.println(user.getId() + ":" + user.getName());
	}

}
