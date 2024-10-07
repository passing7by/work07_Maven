package com.service.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.cj.Session;
import com.service.spring.domain.User;
import com.service.spring.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/memberLogin.do")
	public ModelAndView login(User user, HttpServletRequest request) throws Exception{
	//필요한게 있으면 인자값에 추가해서 쓰면 됨
		System.out.println(" get User Before : " + user); //name, email값은 null
		User rvo = userService.getUser(user);
		
		System.out.println(" get User Before : " + rvo); //모든 값이 들어가있음
		String path = "index.jsp";
		String msg = "아이디 혹은 패스워드가 틀렸습니다.";
		
		if(rvo != null) { //로그인 성공 => 세션에 바인딩
			request.getSession().setAttribute("user", rvo);
			msg = "성공적으로 로그인 됐습니다.";
		}
		
		request.setAttribute("msg", msg); //로그인 성공 여부에 따라 저장되는 msg가 달라지도록 함
		return new ModelAndView("redirect:" + path); //리다이
	}
	
	@RequestMapping("/memberLogout.do")
	public ModelAndView logout(HttpSession session) throws Exception{
		session.invalidate();
		
		return new ModelAndView("redirect:index.jsp");
	}

}















