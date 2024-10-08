package com.service.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.spring.dao.BoardDAO;
import com.service.spring.domain.Board;
import com.service.spring.domain.Member;
import com.service.spring.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardDAO boardDAO;
	
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
	} //write
	
	@RequestMapping("list.do")
	public String list(Model model) {
		
		try {
			List<Board> list = boardService.getBoardList();
			model.addAttribute("list", list);
			
			return "board/list";
		} catch (Exception e) {
			model.addAttribute("message", "게시글 목록 보기 - 에러 발생");
			System.out.println(e);
			
			return "Error";
		}
	} //list
	
	@RequestMapping("showContent.do")
	public String showContent(int no, Model model, HttpSession session) {
		if(session.getAttribute("mvo") == null)
			return "redirect:index.jsp";
		try {			
			System.out.println(no);
			Board bvo = boardService.showContent(no);
			model.addAttribute("bvo", bvo);
			
			return "board/show_content";
		} catch (Exception e) {
			model.addAttribute("message", "게시글 상세 보기 - 에러 발생");
			System.out.println(e);
			
			return "Error";
		}
	} //showContent
	
	@RequestMapping("delete.do")
	public String doDelete(int no, Model model) {
	//행위...
	//login() : 해당 메소드를 실행하면 로그인을 할 수 있는 폼이 나온다는 의미
	//doLogin() : 해당 메소드에서 직접 로그인 기능이 나온다는 의미
		try {
			boardDAO.deleteBoard(no);
			
			return "redirect:list.do";
		} catch (Exception e) {
			model.addAttribute("message", "게시글 상세 보기 - 에러 발생");
			System.out.println(e);
			
			return "Error";
		}
	} //doDelete
	
	@RequestMapping("updateView.do")
	public String update(int no, Model model) {
		try {
			Board bvo = boardService.showContent(no);
			model.addAttribute("bvo", bvo);
			
			return "board/update";
		} catch (Exception e) {
			model.addAttribute("message", "게시글 수정 폼으로 이동 - 에러 발생");
			System.out.println(e);
			
			return "Error";
		}
	} //update
	
	@RequestMapping("updateBoard.do") //TODO : 추가 필요 (showContent)
	public String doUpdate(Board pvo, Model model) {
		try {
			System.out.println("pvo : "+pvo);
			boardService.updateBoard(pvo);
			Board newBvo = boardService.showContent(pvo.getNo());
			//유저 정보를 세션에서 받아오지 않아도 됨

			System.out.println("pvo : "+pvo);
			System.out.println("newBvo : "+newBvo);
		

			model.addAttribute("bvo", newBvo);
			
			return "board/show_content";
		} catch (Exception e) {
			model.addAttribute("message", "게시글 수정 - 에러 발생");
			System.out.println(e);
			
			return "Error";
		}
	} //doUpdate
	
}
