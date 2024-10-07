package com.service.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.Book;
import com.service.spring.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("bookList.do")
	public ModelAndView getBooks() throws Exception{
		List<Book> list=bookService.getBooks();
		
		return new ModelAndView("book/bookList","list",list);
	}
	
//	@RequestMapping("bookRegister.do")
//	public ModelAndView register(Book book)throws Exception{
//		System.out.println("register BookVO before:: "+book);//?
//		
//		String msg = "책 정보 등록에 실패했습니다.";
//		String path = "Error.jsp";
//		
//		if(book != null) {
//			bookService.insertBook(book);
//			msg = "책 정보가 정상적으로 등록되었습니다.";
//			path = "bookForm.jsp";
//		}
//	
//		return new ModelAndView("redirect:" + path);
//	} //register()
	
	@PostMapping("bookRegister.do")
	public ModelAndView register(String isbn1, String isbn2, String isbn3, Book book, HttpServletRequest request)throws Exception{
		//isbn을 뺀 나머지는 자동바인딩됨
		System.out.println("register BookVO before:: "+book);//book 정보에는 isbn은 빠져 있음
		
		String isbn = isbn1+"-"+isbn2+"-"+isbn3;
		book.setIsbn(isbn);
		
		System.out.println("register BookVO before:: "+book);//isbn이 들어가 있음
		
		String msg = "책 정보 등록에 실패했습니다.";
		String path = "redirect:Error.jsp";
		
		try {
			bookService.insertBook(book); //DB에 book 정보가 정상적으로 입력
			msg = "책 정보가 정상적으로 등록되었습니다.";
			path = "redirect:result.jsp";
		}catch (DuplicateKeyException e) {
			//DB에 book 정보가 정상적으로 입력되지 않았다면..
			System.out.println("register() 실패 : 키 중복 : " + e);
			msg = "isbn 중복되었습니다. 다시 등록 부탁;;";
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("register() 실패 : " + e);
		}
		
		request.getSession().setAttribute("msg", msg);
		
		return new ModelAndView(path);
	} //register()
	
//	@RequestMapping("bookSearch.do")
//    public ModelAndView search(String searchField, String searchText) throws Exception{ 
//		
//		List<Book> list = new ArrayList<Book>();
//		String path = "find_fail";
//		
//		try {
//			if(searchField.equals("LIST")) list = bookService.getBooks();
//			else if(searchField.equals("TITLE")) list = bookService.searchByTitle(searchText);
//			else if(searchField.equals("PUBLISHER")) list = bookService.searchByPublisher(searchText);
//			else if(searchField.equals("PRICE")) {
//				int i = Integer.parseInt(searchText);
//				
//				list = bookService.searchByPrice(i);
//			}
//		} finally {
//			System.out.println("searchField : " + searchField);
//			System.out.println("searchText : " + searchText);
//			
//			path = "book/bookList";
//		}
//		
//		return new ModelAndView(path, "list", list);
//	} //search
	
	@GetMapping("bookSearch.do")
    public ModelAndView search(String searchField, String searchText, HttpServletRequest request) throws Exception{ 
		
		List<Book> list = null;
		String path = "redirect:Error.jsp";
		String msg = "도서 검색 중 오류가 발생했습니다.";
		
		try {
			switch (searchField) { //String 값이 들어갈 때는 반드시 JDK 버전이 8버전 이상이어야 함
				case "TITLE":
					list = bookService.searchByTitle(searchText);
				break;
				case "PUBLISHER":
					list = bookService.searchByPublisher(searchText);
				break;
				case "PRICE":
					int i = Integer.parseInt(searchText);
					list = bookService.searchByPrice(i);
				break;
				default:
					list = bookService.getBooks();
				break;
			} //switch
			
			path = "book/bookList";
			msg = "도서 검색을 정상적으로 수행했습니다.";
			
			//추가
			request.setAttribute("field", searchField);
			request.setAttribute("text", searchText);
		}catch (Exception e) {
			System.out.println("search() 수행 중 에러...");
		}finally {
			System.out.println("searchField : " + searchField);
			System.out.println("searchText : " + searchText);
		}
		
		return new ModelAndView(path, "list", list); //포워딩 -> 리퀘스트에 바인딩 됨
	} //search()
	
//	@RequestMapping("bookView.do")
//    public ModelAndView bookview(String isbn)throws Exception{
//			
//		Book book = bookService.searchByIsbn(isbn);
//		return new ModelAndView("book/bookView", "book", book);
//	}	
	
	@GetMapping("bookView.do")
    public ModelAndView bookview(String isbn)throws Exception{
		Book book = null;
		String path = "redirect:Error.jsp";
		String msg = "isbn으로 검색 중 오류가 발생했습니다.";
		try {
			book = bookService.searchByIsbn(isbn);
			path = "book/bookView";
			msg = "isbn으로 검색 성공";
		} catch (Exception e) {
			System.out.println("bookview 수행 중 에러 발생");
		}
		return new ModelAndView(path, "book", book);
	} //bookview()
	

}//





