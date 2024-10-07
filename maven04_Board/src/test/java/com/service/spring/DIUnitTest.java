package com.service.spring;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.spring.dao.BoardDAO;
import com.service.spring.domain.Board;
import com.service.spring.domain.Member;
import com.service.spring.service.BoardService;
import com.service.spring.service.MemberService;

public class DIUnitTest {
	//myBatis와 DI 연도 부분의 단위 테스트...빈 설정문서를 읽어야 함
	
	ApplicationContext factory = 
			new ClassPathXmlApplicationContext("/beans/businessBean.xml");
	
	//IOC로부터 MyProductDAO 객체를 반환
	BoardDAO boardDAO = (BoardDAO)factory.getBean("boardDAO");
	BoardService boardService = (BoardService)factory.getBean("boardService");
	MemberService memberService = (MemberService)factory.getBean("memberService");
	
	@Test
	public void unit1() {
		Member member1 = new Member();
		member1.setId("user1");
		
		Board pvo = new Board("안녕하세요", "안녕하세요~~~~~~", "2020-01-01", member1);
		
		boardService.write(pvo);
		System.out.println(pvo);
	}
	
	@Test
	public void unit2() {
		List<Board> list = boardService.getBoardList();
		for (Board board : list) {
			System.out.println(board);
		}
	}
	
	@Test
	public void unit3() {
		Board board = boardService.showContent(1);
		System.out.println(board);
	}
	
}
