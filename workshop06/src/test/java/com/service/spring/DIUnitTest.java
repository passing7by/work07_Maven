package com.service.spring;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.spring.dao.PhoneDAO;
import com.service.spring.domain.Phone;
import com.service.spring.domain.UserInfo;
import com.service.spring.service.PhoneService;

public class DIUnitTest {
	String[] beans = {
			"/bean/businessBean.xml",
			"/bean/presentationBean.xml"
	};
	
	ApplicationContext factory = 
			new ClassPathXmlApplicationContext(beans);
	
	PhoneDAO phoneDAO = (PhoneDAO)factory.getBean("phoneDAO");
	PhoneService phoneService = (PhoneService)factory.getBean("phoneService");
	
	@Test
	public void unit1() {
//		Phone pvo = new Phone();
//		pvo.setNum("A111P");
//		pvo.setModel("애플 아이패드 10세대");
//		pvo.setPrice(500000);
//		pvo.setVcode("30");
//		
//		phoneService.insert(pvo); //company는 null로 출력됨
//		System.out.println("[insert 성공] : " + pvo);
		
		Phone pvo = new Phone();
		pvo.setNum("A222P");
		pvo.setModel("애플 아이패드 9세대");
		pvo.setPrice(400000);
		pvo.setVcode("30");
		
		phoneService.insert(pvo); //company는 null로 출력됨
		System.out.println("[insert 성공] : " + pvo);
	} //unit1
	
	@Test
	public void unit2() {
		Phone pvo = new Phone();
		List<Phone> listAll = phoneService.select(pvo); //전체 목록 보기
		System.out.println("1. 전체목록");
		for (Phone phone : listAll) {
			System.out.println(phone);
		} //for
		
		pvo.setNum("A111P");
		List<Phone> listByNum = phoneService.select(pvo); //특정 폰 보기
		System.out.println("\n2. 특정 폰 조회");
		for (Phone phone : listByNum) {
			System.out.println(phone);
		} //for
	} //unit2
	
	@Test
	public void unit3() {
		List<Phone> list = new ArrayList<Phone>();
		Phone pvo1 = new Phone();
		pvo1.setNum("A111P");
		Phone pvo2 = new Phone();
		pvo2.setNum("A222P");
		list.add(pvo1);
		list.add(pvo2);
		
		int row = phoneDAO.delete(list);
		System.out.println("[삭제 성공] : " + row + " 행");
	} //unit3
	
	@Test
	public void unit4() {
		List<Phone> list = new ArrayList<Phone>();
		Phone pvo1 = new Phone();
		pvo1.setNum("A111P");
		Phone pvo2 = new Phone();
		pvo2.setNum("A222P");
		list.add(pvo1);
		list.add(pvo2);
		
		int row = phoneDAO.delete(list);
		System.out.println("[삭제 성공] : " + row + " 행");
	}
	
}
