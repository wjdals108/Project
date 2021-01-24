package com.project.todo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.todo.model.ToDoEntity;

public class ToDoDAO {
	public static void insToDo(ToDoEntity vo) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO t_todo (item) VALUES (?)";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setNString(1, vo.getItem());
			int result = ps.executeUpdate();
			System.out.println(result);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps);
		}
	}
	
	public static int selToDoCount() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT COUNT(i_todo) FROM t_todo";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps, rs);
		}
		return 0;
	}
	
	public static List<ToDoEntity> selToDoList() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ToDoEntity> list = new ArrayList();
		
		String sql = "SELECT i_todo, item FROM t_todo ORDER BY i_todo DESC";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				int i_todo = rs.getInt("i_todo");
				String item = rs.getNString("item");
				ToDoEntity vo = new ToDoEntity();
				vo.setI_todo(i_todo);
				vo.setItem(item);
				list.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps, rs);
		}
		return list;
	}
	
	public static void delToDo(ToDoEntity param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "DELETE FROM t_todo WHERE i_todo = ?";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getI_todo());
			int result = ps.executeUpdate();
			System.out.println(result);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps);
		}
	}
	
	public static void delToDoAll() {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "DELETE FROM t_todo";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			int result = ps.executeUpdate();
			System.out.println(result);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps);
		}
	}
}
