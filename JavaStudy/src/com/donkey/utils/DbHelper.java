package com.donkey.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbHelper 
{
	public static Connection getConnection(){
		String dbPath = "E:\\DevelopTools\\Databases\\JAVA_JDBC.db";
		Connection conn = null;
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:"+dbPath);
			System.out.println("get connection success.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception: can't get connection.");
		}
		return conn;
	}
}
