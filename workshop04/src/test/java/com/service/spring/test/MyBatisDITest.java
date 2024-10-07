package com.service.spring.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.spring.domain.MyProduct;
import com.service.spring.service.MyProductService;

public class MyBatisDITest {
	//myBatis와 DI 연도 부분의 단위 테스트...빈 설정문서를 읽어야 함
	
	ApplicationContext factory = 
			new ClassPathXmlApplicationContext("/bean/beans.xml");
	
	//IOC로부터 MyProductDAO 객체를 반환
	MyProductService service = (MyProductService)factory.getBean("myProductService");
	
	@Test
	public void addTest() throws Exception{
		MyProduct pvo = new MyProduct("공기청정기", "LG", 10000);
		service.addProduct(pvo);
		System.out.println("[등록 완료] : " + pvo);
	} //addTest
	
	@Test
	public void findByNameTest() throws Exception{
		List<MyProduct> list = service.findProductByName("고양이");
		for (MyProduct myProduct : list) {
			System.out.println(myProduct);
		} //for
	} //findByNameTest
	
	@Test
	public void findByMakerTest() throws Exception{
		MyProduct myProduct = service.findProductByMaker("엘라스틴");
			System.out.println(myProduct);
	} //findByMakerTest
	
	@Test
	public void findTest() throws Exception{
		List<MyProduct> list3 = service.findProducts();
		for (MyProduct myProduct : list3) {
			System.out.println(myProduct);
		} //for
	} //findTest
}
