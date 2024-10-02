package com.service.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
 Controller를 작성하는 방법
 1. Controller 인터페이스를 상속
 2. POJO로 --> @Annotation으로 작성한다는 의미 --> <bean> <-이 부분이 생략된다는 의미
 */

@Controller
public class IndexController{
	@RequestMapping("/index.do") //이 요청이 들어오면 밑의 함수가 동작하도록
	public ModelAndView doIndex() {
		/*
		 1. 폼값 받아서
		 2. DAO 리턴받고 비지니스 로직 호출하고
		 3. (바인딩-->ServletRequest에 자동 바인딩)
		 4. (네비게이션 --> forwarding)
		 */
		return new ModelAndView("result", "info", "Plain Old Java Object");
		//확장자를 넣지 않음
	}
}
