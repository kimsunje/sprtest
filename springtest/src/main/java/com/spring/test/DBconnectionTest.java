package com.spring.test;

import java.sql.*;
public class DBconnectionTest {
	
	
	    public static void main(String[] args)
	                throws ClassNotFoundException, SQLException {
	    	
	    	
	 
	        // 1. JDBC ����̺� �ε�...
	        Class.forName("oracle.jdbc.OracleDriver");
	        // 2. �������� Connection ��ü����...
	        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "ksj", "1234");
	        // 3.Statement ��ü ����...
	        Statement stmt = conn.createStatement();
	        // 4. ���� ����...
	        System.out.println("Success DB Connection");
	        // 5. ���ҽ� ��ȯ
	        stmt.close();
	        conn.close();
	    }
	

	
}
