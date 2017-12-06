package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring.dao.registrationDao;

@Service
public class registrationServiceImpl implements registrationService{
	@Autowired
	@Qualifier("registrationdao")
	registrationDao DAO;
	
	@Override
	public boolean emailCheck(String email) {
		System.out.println("Service »£√‚ µ ");
		System.out.println("Email:"+email);
		return DAO.emailCheck(email);
	}

}
