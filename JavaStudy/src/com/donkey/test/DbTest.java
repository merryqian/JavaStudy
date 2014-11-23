package com.donkey.test;

import com.donkey.dao.UserDao;

public class DbTest {
	public static void main(String[] args) {
		UserDao dao=new UserDao();
		//dao.addUser(2, "merry");
		//dao.deleteUser(2);
		//dao.newAddUser(11, "snail");
		dao.queryUserByName("snail");
		
	}
}
