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
		System.out.println("�ʱ� �ߺ��˻� ���� üũ duplicatecheck:"+duplicatecheck);
		System.out.println("JSP���� ������ ����:" + email);
		// return "signup";
		HashMap <String, String> dupcheck=new HashMap<String, String>();
		
		try {
			if (duplicatecheck == null) {
				System.out.println("try catch ���� Email:"+email);
				
				
				
				
				duplicatecheck = service.emailCheck(email);
				System.out.println("try���� duplicatecheck: "+duplicatecheck);
				dupcheck.put("duplcheck",duplicatecheck);
				System.out.println("MAP"+dupcheck.get("duplcheck"));
				
			}
		} catch (Exception e) {
			System.out.println("error");
		}
		System.out.println("�ߺ����� ���ϰ� " + duplicatecheck); 

		// �ߺ�üũ true, false return �� �߰�
		
		
	
		// �׽�Ʈ ����
		if (duplicatecheck.equals("1")) {
			System.out.println("�ߺ�");
		} else {
			System.out.println("�ߺ��ƴ�");
		}

		// duplicatecheck �� Ŭ���̾�Ʈ�� ����
		System.out.println("addObject �� ���� duplicatecheck ��" + duplicatecheck);
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
		// ���⼭ �Ķ���� ������ �Ἥ ó��
		System.out.println("�ؽ��� ������ Ȯ��");
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

		System.out.println("RequestParam���� �ٷ� ���� ����:" + email);

		String cemail = email;

		System.out.println("���� ȣ�� ��");
		// boolean duplicateCheck=service.emailCheck(email);
		// System.out.println("���� ȣ�� ��:"+duplicateCheck);

		boolean duplicateCheck2 = true;

		// service.

		boolean t1 = true;

		// �� ��Ʈ�ѷ����� jsp �� ������ �ȳѾ�� �� �ֿֿֿֿֿֿֿֿֿֿֿֿֿֿֿֿֿֿֿ�
		mav.addObject("email", cemail);

		/*
		 * if(duplicateCheck2==true) { System.out.println("�ߺ� �̸��� O"); }else
		 * if(duplicateCheck2!=true) { System.out.println("�ߺ� �̸��� X"); }
		 */

		// System.out.println("String cemail:"+cemail);
		System.out.println("emailCheck Controller End");
		return mav;

	}

}
