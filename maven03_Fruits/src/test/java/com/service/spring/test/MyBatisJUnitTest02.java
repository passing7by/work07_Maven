package com.service.spring.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.service.spring.domain.Item;

public class MyBatisJUnitTest02 {
	
	@Test
	public void unit() throws Exception{
		//1.
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		//2.
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		//3.
		SqlSession session = factory.openSession();
	
		//4. 쿼리문 실행
		List<Item> list = session.selectList("FruitMapper.getItemList");
		for (Item item : list) {
			System.out.println(item);
		}
	} //unit()
	
	@Test
	public void unit2() throws Exception{
		//1.
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		//2.
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		//3.
		SqlSession session = factory.openSession();
		
		//4. 쿼리문 실행
		Item item = session.selectOne("FruitMapper.getItem", 1111);
		System.out.println("\n"+item);
	} //unit2()
} //MyBatisJUnitTest02
