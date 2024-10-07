package com.service.spring;


import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.spring.domain.Book;

public class BookUnitTest01 {

	public static void main(String[] args) throws Exception{
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
	
		SqlSession session = factory.openSession();
	
		//쿼리문 실행		
		
		System.out.println("////////////////////////////////////////////////////////");
		
		System.out.println("searchByTitle =========================================");
		List<Book> list1 = session.selectList("ns.sql.BookMapper.searchByTitle", "of");
		for (Book book : list1) {
			System.out.println(book);
		}
		
		System.out.println("");
		System.out.println("searchByPrice =========================================");
		List<Book> list2 = session.selectList("ns.sql.BookMapper.searchByPrice", 30);
		for (Book book : list2) {
			System.out.println(book);
		}
		
		System.out.println("////////////////////////////////////////////////////////");
		
		System.out.println("");
		System.out.println("getIsbn =========================================");
		List<String> list3 = session.selectList("ns.sql.BookMapper.getIsbn", "garden");
		for (String s : list3) {
			System.out.println(s);
		}
		
		List<String> list4 = session.selectList("ns.sql.BookMapper.getIsbn", "of");
		for (String s : list4) {
			System.out.println(s);
		}
		
		


	}

}
