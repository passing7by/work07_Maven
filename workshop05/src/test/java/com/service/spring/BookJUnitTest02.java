package com.service.spring;


import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import com.service.spring.domain.Book;

public class BookJUnitTest02 {		
	
	public SqlSession getSqlSession() throws Exception{
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
	
		SqlSession session = factory.openSession();
		
		return session;
	}
	

	//쿼리문 실행	
	
	@Test
	public void unit1() throws Exception{
		SqlSession session = getSqlSession();
		Book book = new Book();
        book.setIsbn("1234-123-123");
        book.setTitle("The Enchanted Forest");
        book.setCatalogue("Fantasy");
        book.setNation("USA");
        book.setPublishDate("2020-07-06");
        book.setPublisher("Fantasy World");
        book.setAuthor("Jane Doe");
        book.setPrice(25);
        book.setCurrency("USD");
        book.setDescription("A magical journey through an enchanted forest.");
		
		session.insert(statement)
	}
	
//		System.out.println("////////////////////////////////////////////////////////");
//		
//		System.out.println("searchByTitle =========================================");
//		List<Book> list1 = session.selectList("ns.sql.BookMapper.searchByTitle", "of");
//		for (Book book : list1) {
//			System.out.println(book);
//		}
//		
//		System.out.println("searchByPrice =========================================");
//		List<Book> list2 = session.selectList("ns.sql.BookMapper.searchByPrice", 30);
//		for (Book book : list2) {
//			System.out.println(book);
//		}
//		
//		System.out.println("////////////////////////////////////////////////////////");
//		
//		System.out.println("getIsbn =========================================");
//		List<String> list3 = session.selectList("ns.sql.BookMapper.getIsbn", "garden");
//		for (String s : list3) {
//			System.out.println(s);
//		}
//		
//		List<String> list4 = session.selectList("ns.sql.BookMapper.getIsbn", "of");
//		for (String s : list4) {
//			System.out.println(s);
//		}
	
	




}
