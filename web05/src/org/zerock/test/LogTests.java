package org.zerock.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class LogTests {
	
	@Test
	public void test100DBCP() throws Exception{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Class.forName("org.apache.commons.dbcp.PoolingDriver");
		
		long start = System.currentTimeMillis();
		
		for(int i = 0; i < 100; i++) {
			
			Connection con = 
					DriverManager.getConnection(
					"jdbc:apache:commons:dbcp:/pool",
					"hr",
					"hr");
			PreparedStatement pstmt = 
				con.prepareStatement("select sysdate from dual");
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			System.out.println(rs.getString(1));
			rs.close();
			pstmt.close();
			con.close();
			
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println(end - start);
		
	}
	
	
	@Test
	public void test100JDBC() throws Exception{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		long start = System.currentTimeMillis();
		
		for(int i = 0; i < 100; i++) {
			
			Connection con = 
					DriverManager.getConnection(
					"jdbc:oracle:thin:@192.168.41.38:1521:XE",
					"hr",
					"hr");
			PreparedStatement pstmt = 
				con.prepareStatement("select sysdate from dual");
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			System.out.println(rs.getString(1));
			rs.close();
			pstmt.close();
			con.close();
			
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println(end - start);
		
	}
	
	@Test
	public void testLog() {
		
		log.debug("debug");
		log.info("info");
		log.warn("warn");
		log.error("error");
		log.fatal("fatal");
	}
}
