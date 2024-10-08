package com.service.spring.controller;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.service.spring.domain.UserInfo;
import com.service.spring.service.PhoneService;
@Controller
public class PhoneController {
	@Autowired
	private PhoneService service;
	
	
	@GetMapping("/")
	public String index() {
		
		return "redirect:index.jsp";
		
	}
	//로그인 폼을 먼저 요청 ... Get
	@GetMapping
	public String loginForm() {
		
		return "Login";
		
	}
	//로그인을 진행하는 요청
	@PostMapping
	public String login(UserInfo user, Model model,HttpSession session) {
		try {
			UserInfo selected = service.selectUser(user);
			if(selected != null) { //로그인 되어 있다면
				session.setAttribute("loginUser", selected);
				return "redirect:searchPhone.do";
			}else {
				return "Login";
			}
		}catch(Exception e) {
			System.out.println(e);
			model.addAttribute("message","문제 내용- 회원 로그인 중 문제 발생");
			model.addAttribute("title","핸드폰 관리 - 에러.");
			return"Error";
		}
	}
	
	
	@RequestMapping("regPhone.do")
	public String insert(Model model) {
		String path="Error";
		String msg ="폰 등록 화면 이동 중 에러발생하였습니다.";
		try {
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
		
	}
	
	@RequestMapping("savePhone.do")
	public String insertDo() {
		return null;
	}
}