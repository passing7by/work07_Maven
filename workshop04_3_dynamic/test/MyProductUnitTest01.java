package com.service.spring.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.spring.domain.MyProduct;

public class MyProductUnitTest01 {

	public static void main(String[] args) throws Exception{
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
	
		SqlSession session = factory.openSession();
	
		//쿼리문 실행
		MyProduct myProduct1 = new MyProduct("고양이 사료", "로얄캐닌", 20000);
		MyProduct myProduct2 = new MyProduct("고양이 빗", "엘라스틴", 6000);
		MyProduct myProduct3 = new MyProduct("고양이 모래", "두부두부", 5000);
		String ns = "ns.sql.MyProductMapper.";
		
		//1
//		System.out.println("=================================");
//		session.insert(ns+"addProduct", myProduct1);
//		System.out.println("[등록 성공] : " + myProduct1);
//		
//		session.insert(ns+"addProduct", myProduct2);
//		System.out.println("[등록 성공] : " + myProduct2);
//		
//		session.insert(ns+"addProduct", myProduct3);
//		System.out.println("[등록 성공] : " + myProduct3);
//		System.out.println("=================================");
		
		//2
		System.out.println("=================================");
		List<MyProduct> list1 = session.selectList(ns+"findProductByName", "모래");
		for (MyProduct myProduct : list1) {
			System.out.println(myProduct);
		}
		System.out.println("=================================");
		
		//3
		System.out.println("=================================");
		 MyProduct myProduct = session.selectOne(ns+"findProductByMaker", "엘라스틴");
		 System.out.println(myProduct);
		System.out.println("=================================");
		
		//4
		System.out.println("=================================");
		List<MyProduct> list4 = session.selectList(ns+"findProducts");
		for (MyProduct myProduct4 : list4) {
			System.out.println(myProduct4);
		}
		System.out.println("=================================");
		session.commit();

	}

}
