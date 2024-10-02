package com.service.spring.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.spring.domain.MyProduct;


/*
 mybatis-fruit-mapping.xml sql 구분이 잘 만들어졌는지
 MyBatis 프레임워크 부분이 잘 연결되었는지...여부를 점검하는 테스트
 
 이 부분이 완벽해야 Persistence 레이어로 연결할 수 있음
 
 SqlMapConfig.xml을 읽어서
 SqlSesstionFactory
 SqlSession
 
 CRUD를 확인한다..이때 commit() 해아 함
 */

public class MyBatisUnitTest01 {

	public static void main(String[] args) throws Exception{
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
	
		SqlSession session = factory.openSession();
	
		//쿼리문 실행
		MyProduct myProduct1 = new MyProduct("TV", "LG", 12000);
		MyProduct myProduct2 = new MyProduct("Cookie", "Samsung", 6000);
		MyProduct myProduct3 = new MyProduct("Pen", "JetStream", 5000);
		String ns = "ns.sql.MyProductMapper.";
		
		//1
		System.out.println("=================================");
		session.insert(ns+"addProduct", myProduct1);
		System.out.println("[등록 성공] : " + myProduct1);
		
		session.insert(ns+"addProduct", myProduct2);
		System.out.println("[등록 성공] : " + myProduct2);
		
		session.insert(ns+"addProduct", myProduct3);
		System.out.println("[등록 성공] : " + myProduct3);
		System.out.println("=================================");
		
		//2
		System.out.println("=================================");
		List<MyProduct> list1 = session.selectList("ns.sql.MyProductMapper.findProductByName", "TV");
		System.out.println(list1);
		System.out.println("=================================");
		
		//3
		System.out.println("=================================");
		MyProduct myProduct = session.selectOne("ns.sql.MyProductMapper.findProductByMaker", "Samsung");
		System.out.println(myProduct);
		System.out.println("=================================");
		
		//4
		System.out.println("=================================");
		List<MyProduct> list4 = session.selectList("ns.sql.MyProductMapper.findProducts");
		System.out.println(list4);
		System.out.println("=================================");
		session.commit();

	}

}
