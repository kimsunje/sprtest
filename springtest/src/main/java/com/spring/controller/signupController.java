package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.service.registrationService;

@Controller
public class signupController {
	@Autowired
	registrationService service;
	
	@ResponseBody
	@RequestMapping("/signup.do")
	public ModelAndView signupView(@RequestParam(value="email",required=false,defaultValue="")String email) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("email", email);
		System.out.println("JSP에서 가져온 변수:"+email);
		//return "signup";
		return mav;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/emailCheck.do")//, method=RequestMethod.GET
	public ModelAndView emailCheck(@RequestParam(value="email", required=false, defaultValue="")String email ) {
		
		System.out.println("emailCheck Controller Start");
		ModelAndView mav = new ModelAndView(); 
		
		System.out.println("RequestParam으로 바로 받은 변수:"+email);
		
		String cemail=email;
		
		System.out.println("서비스 호출 전");
		//boolean duplicateCheck=service.emailCheck(email);
		//System.out.println("서비스 호출 후:"+duplicateCheck);
		
		boolean duplicateCheck2=true;
		
		
		
		//service.
		
		boolean t1=true;
		
		
		//왜 컨트롤러에서 jsp 로 변수가 안넘어가니 왜 왜왜왜왜왜왜왜왜왜왜왜왜왜왜왜왜왜왜왜왜
		mav.addObject("email",cemail);
		
		
		/*if(duplicateCheck2==true) {
			System.out.println("중복 이메일 O");
		}else if(duplicateCheck2!=true) {
			System.out.println("중복 이메일 X");
		}*/
		
		
		//System.out.println("String cemail:"+cemail);
		System.out.println("emailCheck Controller End");
		return mav;
		
		
	}
	
	
	
	

}
