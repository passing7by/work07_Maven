package com.service.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.dao.PhoneDAO;
import com.service.spring.domain.Phone;
import com.service.spring.domain.UserInfo;

@Service
public class PhoneService {

	@Autowired
	private PhoneDAO phoneDAO;
	
	public int insert(Phone vo) {
		return phoneDAO.insert(vo);
	}
	
	public List<Phone> select(Phone vo) {
		return phoneDAO.select(vo);
	}

	public UserInfo selectUser(UserInfo vo) {
		return phoneDAO.selectUser(vo);
	}
	
	public int update(Phone vo) {
		return phoneDAO.update(vo);
	}
}
