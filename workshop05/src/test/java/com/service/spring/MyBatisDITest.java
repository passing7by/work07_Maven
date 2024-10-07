package com.service.spring;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.spring.domain.Book;
import com.service.spring.domain.MyProduct;
import com.service.spring.service.BookService;
import com.service.spring.service.MyProductService;

public class MyBatisDITest {
	//myBatis와 DI 연도 부분의 단위 테스트...빈 설정문서를 읽어야 함
	
	ApplicationContext factory = 
			new ClassPathXmlApplicationContext("/beans/businessBean.xml");
	
	//IOC로부터 MyProductDAO 객체를 반환
	BookService bookService = (BookService)factory.getBean("bookService");
	
	@Test
	public void addTest() throws Exception{
		List<Book> list = bookService.searchByTitle("of");
		for (Book book : list) {
			System.out.println(book);
		}
	} //addTest
	
	
}
