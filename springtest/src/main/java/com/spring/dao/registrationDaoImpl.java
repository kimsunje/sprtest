package com.spring.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("registrationdao")
public class registrationDaoImpl implements registrationDao {
	@Autowired
	SqlSession sqlsession;
	
	@Override
	public boolean emailCheck(String email) {
		// TODO Auto-generated method stub
		System.out.println("DAO »£√‚ µ ");
		System.out.println("Email:"+email);
		return sqlsession.selectOne("com.registration.emailcheck",email);
	}

}
