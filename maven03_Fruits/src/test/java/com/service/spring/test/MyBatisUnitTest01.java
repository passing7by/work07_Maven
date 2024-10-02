package com.service.spring.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.spring.domain.Item;

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
		List<Item> list = session.selectList("ns.sql.FruitMapper.getItemList");
		for (Item item : list) {
			System.out.println(item);
		}
		
		Item item = session.selectOne("ns.sql.FruitMapper.getItem", 1111);
		System.out.println("\n"+item);
	}

}
