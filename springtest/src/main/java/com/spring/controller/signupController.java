package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class signupController {
	
	@RequestMapping("/signup.do")
	public String signupView(@RequestParam(value="inputemail", required=false, defaultValue="")String email) {
		System.out.println("TEST");
		System.out.println(email);
		System.out.println("TEST2");
		return "signup";
	}
	
	//@RequestMapping("/signup.do")
	/*public ModelAndView emailCheck(@RequestParam(value="InputEmail", required=false, defaultValue="")String email ) {
		
		System.out.println(email);
		return null;
		
		
	}*/
	
	
	
	

}
