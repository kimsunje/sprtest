package com.spring.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("registrationdao")
public class registrationDaoImpl implements registrationDao {
	@Autowired
	SqlSession sqlsession;
	
	@Override
	public String emailCheck(String email) {
		// TODO Auto-generated method stub
		System.out.println("DAO »£√‚ µ  Email:"+email);
		
		/*
		if(sqlsession.selectOne("com.registration.emailcheck",email).equals("ksj@gmail.com")) {
			return true;
		}else {
			return false;
			}
	*/	
		return sqlsession.selectOne("com.registration.emailcheck",email);
	}

}
