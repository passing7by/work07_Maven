package com.service.spring.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.MyProduct;
import com.sun.javafx.collections.MappingChange.Map;

//pojo
@Repository
public class MyProductDAO {
	
	public static final String NS = "ns.sql.MyProductMapper."; //맨 뒤에 . 붙여야 함
	@Autowired
	private SqlSession sqlSession;
	
	public int addProduct(MyProduct myProduct) throws Exception{
		return sqlSession.insert(NS + "addProduct", myProduct);
	}
	
//	public List<MyProduct> findProductByName(MyProduct myProduct) throws Exception{
//		return sqlSession.selectList(NS + "findProduct", myProduct);
//	}
//	
//	public List<MyProduct> findProductByMaker(MyProduct myProduct) throws Exception{
//		return sqlSession.selectList(NS + "findProduct", myProduct);
//	}
//	
//	public List<MyProduct> findProducts() throws Exception{
//		return sqlSession.selectList(NS + "findProduct");
//	}
	
	public List<MyProduct> findProduct(String select, String search) throws Exception{
		HashMap map = new HashMap();
		map.put("select", select);
		map.put("search", search);
		return sqlSession.selectList(NS + "findProduct", map);
	}
	

	
}
