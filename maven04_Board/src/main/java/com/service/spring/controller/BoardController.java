package com.service.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.spring.domain.Board;
import com.service.spring.domain.Member;
import com.service.spring.service.BoardService;
import com.service.spring.service.MemberService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("write.do")
	public String write(Board bvo, HttpSession session, Model model) {
		Member mvo = (Member)session.getAttribute("mvo");
		if(mvo==null) return "redirect:index.jsp"; //로그인 안 된 상태라면...
		try {
			bvo.setMemberVO(mvo);
			model.addAttribute("bvo", bvo);
			boardService.write(bvo); //인자값으로 들어온 위의 bvo와는 다름
			
			return "board/show_content";
		} catch (Exception e) {
			model.addAttribute("message", "게시글 작성 - 에러 발생");
			System.out.println(e);
			
			return "Error";
		}
	}
}
