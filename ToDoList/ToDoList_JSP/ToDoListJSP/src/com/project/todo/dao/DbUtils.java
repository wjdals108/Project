package com.project.todo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbUtils {
	public static Connection getCon() throws Exception{
		final String URL = "jdbc:mysql://localhost/todolist?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8";		//타임존 뒤에꺼 써주면 이모지 다 쓸 수 있음
		final String USERNAME = "root";
		final String PASSWORD = "1234";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		System.out.println("연결 완료");
		
		return con;
	}
	public static void close(Connection con, PreparedStatement ps) {
		if(con != null) {
			try {con.close();} catch(Exception e) {}
		}
		if(ps != null) {
			try {ps.close();} catch(Exception e) {}
		}
	}
	
	public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
		if(rs != null) {
			try {rs.close();} catch(Exception e) {}
		}
		close(con, ps);
	}
}