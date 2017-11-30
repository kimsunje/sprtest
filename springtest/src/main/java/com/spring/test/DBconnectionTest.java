package com.spring.test;

import java.sql.*;
public class DBconnectionTest {
	
	
	    public static void main(String[] args)
	                throws ClassNotFoundException, SQLException {
	    	
	    	
	 
	        // 1. JDBC 드라이브 로드...
	        Class.forName("oracle.jdbc.OracleDriver");
	        // 2. 접속정보 Connection 객체생성...
	        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "ksj", "1234");
	        // 3.Statement 객체 생성...
	        Statement stmt = conn.createStatement();
	        // 4. 쿼리 실행...
	        System.out.println("Success DB Connection");
	        // 5. 리소스 반환
	        stmt.close();
	        conn.close();
	    }
	

	
}
