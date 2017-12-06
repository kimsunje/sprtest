package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.service.registrationService;

@Controller
public class signupController {
	@Autowired
	registrationService service;
	
	@RequestMapping("/signup.do")
	public String signupView() {
		
		return "signup";
	}
	
	
	
	@RequestMapping(value="/emailCheck.do", method=RequestMethod.GET)
	public ModelAndView emailCheck(@RequestParam(value="email", required=false, defaultValue="")String email ) {
		
		System.out.println("emailCheck Controller Start");
		ModelAndView mav = new ModelAndView();
		
		System.out.println("RequestParam���� �ٷ� ���� ����");
		System.out.println(email);
		String cemail=email;
		
		System.out.println("���� ȣ�� ��");
		boolean duplicateCheck=service.emailCheck(email);
		System.out.println("���� ȣ�� ��:"+duplicateCheck);
		
		if(duplicateCheck==true) {
			System.out.println("�ߺ� �̸��� O");
		}else if(duplicateCheck!=true) {
			System.out.println("�ߺ� �̸��� X");
		}
		
		//service.
		
		
		mav.addObject("email",cemail);
		
		
		System.out.println("String cemail:"+cemail);
		System.out.println("emailCheck Controller End");
		return mav;
		
		
	}
	
	
	
	

}
