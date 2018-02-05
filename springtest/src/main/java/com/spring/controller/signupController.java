package com.spring.controller;

import java.util.HashMap;
import java.util.Map;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.service.registrationService;

@Controller
public class signupController {
	@Autowired
	registrationService service;

	
	@RequestMapping("/signup.do")
	public ModelAndView signupView(
			String duplicatecheck,
			@RequestParam(value = "email", required = false, defaultValue = "") String email,
			@RequestParam(value = "password1", required = false, defaultValue = "") String password1,
			@RequestParam(value = "password2", required = false, defaultValue = "") String password2) {

		//String abc = "1";
		
		ModelAndView mav = new ModelAndView();
		/* mav.addObject("email", email); */
		System.out.println("초기 중복검사 변수 체크 duplicatecheck:"+duplicatecheck);
		System.out.println("JSP에서 가져온 변수:" + email);
		// return "signup";
		HashMap <String, String> dupcheck=new HashMap<String, String>();
		
		try {
			if (duplicatecheck == null) {
				System.out.println("try catch 구문 Email:"+email);
				
				
				
				
				duplicatecheck = service.emailCheck(email);
				System.out.println("try구문 duplicatecheck: "+duplicatecheck);
				dupcheck.put("duplcheck",duplicatecheck);
				System.out.println("MAP"+dupcheck.get("duplcheck"));
				
			}
		} catch (Exception e) {
			System.out.println("error");
		}
		System.out.println("중복쿼리 리턴값 " + duplicatecheck); 

		// 중복체크 true, false return 값 추가
		
		
	
		// 테스트 구문
		if (duplicatecheck.equals("1")) {
			System.out.println("중복");
		} else {
			System.out.println("중복아님");
		}

		// duplicatecheck 값 클라이언트로 전달
		System.out.println("addObject 윗 구문 duplicatecheck 값" + duplicatecheck);
		/*Map <String, String>dupcheck=new HashMap<String, String>();
		
		dupcheck.put("email",email);
		dupcheck.put("duplcheck",duplicatecheck);*/
		
		/*for(int i=0; i<dupcheck.size();i++){
			System.out.println("MAP"+dupcheck.get(i));
		}*/
		//mav.addObject("abc", abc);
		mav.addObject("duplicatecheck", dupcheck.get("duplcheck"));
		
		// mav.setViewName("check");
		// model.addAttribute("duplicatecheck",duplicatecheck);
		// model.addAttribute("duplicatecheck",duplicatecheck);
		// mav.setViewName("signup");
		// 여기서 파라메터 여러개 써서 처리
		System.out.println("해쉬맵 데이터 확인");
		for(int i=0;i<dupcheck.size();i++){
			
			System.out.println(dupcheck.get("duplcheck"));
		}
	
		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "/emailCheck.do")
	// , method=RequestMethod.GET
	public ModelAndView emailCheck(
			@RequestParam(value = "email", required = false, defaultValue = "") String email) {

		System.out.println("emailCheck Controller Start");
		ModelAndView mav = new ModelAndView();

		System.out.println("RequestParam으로 바로 받은 변수:" + email);

		String cemail = email;

		System.out.println("서비스 호출 전");
		// boolean duplicateCheck=service.emailCheck(email);
		// System.out.println("서비스 호출 후:"+duplicateCheck);

		boolean duplicateCheck2 = true;

		// service.

		boolean t1 = true;

		// 왜 컨트롤러에서 jsp 로 변수가 안넘어가니 왜 왜왜왜왜왜왜왜왜왜왜왜왜왜왜왜왜왜왜왜왜
		mav.addObject("email", cemail);

		/*
		 * if(duplicateCheck2==true) { System.out.println("중복 이메일 O"); }else
		 * if(duplicateCheck2!=true) { System.out.println("중복 이메일 X"); }
		 */

		// System.out.println("String cemail:"+cemail);
		System.out.println("emailCheck Controller End");
		return mav;

	}

}
