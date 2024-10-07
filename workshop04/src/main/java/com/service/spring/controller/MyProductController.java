package com.service.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.MyProduct;
import com.service.spring.service.MyProductService;

@Controller
public class MyProductController {
	@Autowired
	private MyProductService myProductService;
	
	@RequestMapping("addProduct.do")
	public ModelAndView add(MyProduct myProduct) throws Exception {
		myProductService.addProduct(myProduct);
		return new ModelAndView("result");
	} //add
	
	@RequestMapping("findProduct.do")
	public ModelAndView find(String select, String search) throws Exception {
		List<MyProduct> list = new ArrayList<MyProduct>();
		System.out.println("select : " + select);
		System.out.println("search : " + search);
		if(search!="") {
			if(select.equals("name")) list = myProductService.findProductByName(search);
			if(select.equals("maker")) list.add(myProductService.findProductByMaker(search));
		}else list = myProductService.findProducts(); 
		return new ModelAndView("result", "list", list);
	} //find
}
