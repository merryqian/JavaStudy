package com.donkey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.donkey.utils.DbHelper;

public class UserDao {
	public void addUser(int userId,String name){
		Connection conn = DbHelper.getConnection();
		Statement st = null;
		try {
			st = conn.createStatement();
			String sql = "insert into UserInfo(UserID,Name) VALUES("+userId+",'"+name+"')";
			st.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				st.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void newAddUser(int userId,String name){
		Connection conn = DbHelper.getConnection();
		PreparedStatement pst = null;
		
		String sql = "insert into UserInfo(UserID,name) values(?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, userId);
			pst.setString(2, name);
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteUser(int userId)
	{
		Connection connect=DbHelper.getConnection();
		Statement statement=null;
		try {
			statement=connect.createStatement();
			String sql="Delete from UserInfo where userid="+userId+"";
			statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				statement.close();
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void queryUserByName(String name){
		Connection connect=DbHelper.getConnection();
		Statement statement=null;
		try {
			statement=connect.createStatement();
			String sql = "select * from UserInfo where name='"+name+"'";
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				System.out.println("userid="+rs.getInt("UserId")+"   name="+rs.getString("Name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				statement.close();
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
