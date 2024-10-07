package com.service.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.Book;
import com.service.spring.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("bookList.do")
	public ModelAndView getBooks() throws Exception{
		List<Book> list=bookService.getBooks();
		
		return new ModelAndView("book/bookList","list",list);
	}
	
	@RequestMapping("bookRegister.do")
	public ModelAndView register(Book book)throws Exception{
		System.out.println("register BookVO before:: "+book);//?
		
		String msg = "책 정보 등록에 실패했습니다.";
		String path = "Error.jsp";
		
		if(book != null) {
			bookService.insertBook(book);
			msg = "책 정보가 정상적으로 등록되었습니다.";
			path = "bookForm.jsp";
		}
	
		return new ModelAndView("redirect:" + path);
	}
	
	@RequestMapping("bookSearch.do")
    public ModelAndView search(String searchField, String searchText) throws Exception{ 
		
		List<Book> list = new ArrayList<Book>();
		String path = "find_fail";
		
		try {
			if(searchField.equals("LIST")) list = bookService.getBooks();
			else if(searchField.equals("TITLE")) list = bookService.searchByTitle(searchText);
			else if(searchField.equals("PUBLISHER")) list = bookService.searchByPublisher(searchText);
			else if(searchField.equals("PRICE")) {
				int i = Integer.parseInt(searchText);
				
				list = bookService.searchByPrice(i);
			}
		} finally {
			System.out.println("searchField : " + searchField);
			System.out.println("searchText : " + searchText);
			
			path = "book/bookList";
		}
		
		return new ModelAndView(path, "list", list);
	}
	@RequestMapping("bookView.do")
    public ModelAndView bookview(String isbn)throws Exception{
			
		Book book = bookService.searchByIsbn(isbn);
		return new ModelAndView("book/bookView", "book", book);
	}	
	

}//





