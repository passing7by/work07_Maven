package com.service.spring.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.dao.BoardDAO;
import com.service.spring.domain.Board;

@Repository
public class BoardService {

	@Autowired
	private BoardDAO boardDAO;
		
	public int write(Board vo) {
		
		System.out.println("writeDate : " + vo); //no가 없을 것이다.
		int row = boardDAO.write(vo);
		System.out.println("writeDate : " + vo);
		
		String date = boardDAO.selectByNoForDate(vo.getNo());
		vo.setWriteDate(date);
		
		System.out.println("writeDate : " + vo); //no가 있을 것이다. 왜? ->
		
		return row;
	}
	
	public List<Board> getBoardList() {
		return boardDAO.getBoardList();
	}
	
	public Board showContent(int no) {
		boardDAO.updateCount(no);
		
		return boardDAO.showContent(no);
	}
	
	public int updateBoard(Board vo) {
		return boardDAO.updateBoard(vo);
	}
}
