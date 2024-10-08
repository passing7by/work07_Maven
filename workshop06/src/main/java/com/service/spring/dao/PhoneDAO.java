package com.service.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.Phone;
import com.service.spring.domain.UserInfo;

@Repository
public class PhoneDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public static final String NS = "ns.sql.phone.";
	
	public int insert(Phone vo) {
		return sqlSession.insert(NS + "insert", vo);
	}
	
	public List<Phone> select(Phone vo) {
		return sqlSession.selectList(NS + "select", vo);
	}
	
	public UserInfo selectUser(UserInfo vo) {
		return sqlSession.selectOne(NS + "selectUser", vo);
	}
	
	public int delete(List<Phone> list) {
		return sqlSession.delete(NS + "delete", list);
	}
	
	public int update(Phone vo) {
		return sqlSession.update(NS + "update", vo);
	}
}
