package com.service.spring;


import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.spring.domain.User;

public class UserUnitTest01 {

	public static void main(String[] args) throws Exception{
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
	
		SqlSession session = factory.openSession();
	
		//쿼리문 실행
		User user1 = new User("qwer", "1234", "김지남", "qwer@naver.com");
		User user2 = new User("admin", "admin");
		User user3 = new User("java");
		
		String ns = "ns.sql.UserMapper.";
		
		//1
//		System.out.println("1. addUser =================================");
//		session.insert(ns+"addUser", user1);
//		System.out.println("[등록 성공] : " + user1);
		
		//2
		System.out.println("2. getUser =================================");
		User user4 = session.selectOne(ns+"getUser", user2);
		System.out.println(user4);
		
		User user5 = session.selectOne(ns+"getUser", user3);
		System.out.println(user5);
		session.commit();

	}

}
