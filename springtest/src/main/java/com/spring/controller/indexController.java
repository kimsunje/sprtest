package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class indexController {
	
	@RequestMapping("/index.do")
	public String view() {
		return "index";
	}
	

}
