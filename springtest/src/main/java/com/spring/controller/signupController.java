package com.spring.controller;

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

	@ResponseBody
	@RequestMapping("/signup.do")
	public Model signupView(
			@RequestParam(value = "email", required = false, defaultValue = "") String email,
			@RequestParam(value = "password1", required = false, defaultValue = "") String password1,
			@RequestParam(value = "password2", required = false, defaultValue = "") String password2,
			Model model) {
		
		ModelAndView mav = new ModelAndView();
		/*mav.addObject("email", email);*/
		System.out.println("JSP���� ������ ����:" + email);
		// return "signup";
		
		int duplicatecheck = service.emailCheck(email);
		System.out.println("�ߺ����� ���ϰ� "+duplicatecheck);
		
		//�ߺ�üũ true, false return �� �߰�
		
		
		//�׽�Ʈ ����
		if (duplicatecheck == 1) {
			System.out.println("�ߺ�");
		}else {
			System.out.println("�ߺ��ƴ�");
		}
		
		//duplicatecheck �� Ŭ���̾�Ʈ�� ����
		System.out.println("addObject �� ���� duplicatecheck ��"+duplicatecheck);
		//mav.addObject("duplicatecheck", duplicatecheck);
		//model.addAttribute("duplicatecheck",duplicatecheck);
		model.addAttribute("duplicatecheck",duplicatecheck);
		//mav.setViewName("emailcheck");
		// ���⼭ �Ķ���� ������ �Ἥ ó��
		return model;
	}

	@ResponseBody
	@RequestMapping(value = "/emailCheck.do") // , method=RequestMethod.GET
	public ModelAndView emailCheck(@RequestParam(value = "email", required = false, defaultValue = "") String email) {

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
