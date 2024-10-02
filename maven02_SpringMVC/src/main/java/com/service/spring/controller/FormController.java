package com.service.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.vo.User;

@Controller
public class FormController {
	//html의 폼의 값이 자동으로 컨트롤러에 바인딩되도록
	@RequestMapping("/form.do")
	public ModelAndView form(User user) {
		/*
		 1. 폼값 받아서
		 	String name = request.getParameter("userName");
		 	String addr = request.getParameter("userAddr");
		 	String addr = request.getParameter("id");
		 2. pvo 생성
		 	User pvo = new User(name, addr, id, password)
		 	기본 생성자로 객체를 생성한 뒤, pvo.set()으로 주입이 일어남
		 */
		return new ModelAndView("result", "info", user);
	}
}
