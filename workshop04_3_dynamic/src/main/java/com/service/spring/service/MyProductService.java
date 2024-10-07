package com.service.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.dao.MyProductDAO;
import com.service.spring.domain.MyProduct;

@Service
public class MyProductService {
	@Autowired
	private MyProductDAO myProductDAO;
	
	public int addProduct(MyProduct myProduct) throws Exception{
		return myProductDAO.addProduct(myProduct);
	}
	
//	public List<MyProduct> findProductByName(MyProduct myProduct) throws Exception{
//		return myProductDAO.findProductByName(myProduct);
//	}
//	
//	public List<MyProduct> findProductByMaker(MyProduct myProduct) throws Exception{
//		return myProductDAO.findProductByMaker(myProduct);
//	}
//	
//	public List<MyProduct> findProducts() throws Exception{
//		return myProductDAO.findProducts();
//	}
	
	public List<MyProduct> findProduct(String select, String search) throws Exception{
		return myProductDAO.findProduct(select, search);
	}
}
