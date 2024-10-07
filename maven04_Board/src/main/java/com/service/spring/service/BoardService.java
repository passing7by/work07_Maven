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
		return boardDAO.write(vo);
	}
	
	public String selectByNoForDate(int no) {
		return boardDAO.selectByNoForDate(no);
	}
	
	public List<Board> getBoardList() {
		return boardDAO.getBoardList();
	}
	
	public Board showContent(int no) {
		return boardDAO.showContent(no);
	}
	
	public int updateCount(int no) {
		return boardDAO.updateCount(no);
	}
	
	public int updateBoard(int no) {
		return boardDAO.updateBoard(no);
	}
}
