package com.service.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.MyProduct;

//pojo
@Repository
public class MyProductDAO {
	
	public static final String NS = "ns.sql.MyProductMapper."; //맨 뒤에 . 붙여야 함
	@Autowired
	private SqlSession sqlSession;
	
	public int addProduct(MyProduct myProduct) throws Exception{
		return sqlSession.insert(NS + "addProduct", myProduct);
	}
	
	public List<MyProduct> findProductByName(String name) throws Exception{
		return sqlSession.selectList(NS + "findProductByName", name);
	}
	
	public MyProduct findProductByMaker(String maker) throws Exception{
		return sqlSession.selectOne(NS + "findProductByMaker", maker);
	}
	
	public List<MyProduct> findProducts() throws Exception{
		return sqlSession.selectList(NS + "findProducts");
	}
	

	
}
