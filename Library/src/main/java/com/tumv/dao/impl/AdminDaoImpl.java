package com.tumv.dao.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.tumv.dao.AdminDao;
import com.tumv.model.User;

@Repository
public class AdminDaoImpl implements AdminDao{

	public ArrayList<User> getAllUser() throws Exception {
		ArrayList<User> listUser = new ArrayList<User>();
		for (int i = 0; i < 100; i++) {
			User user = new User();
			user.setUserId(i);
			user.setUserName("user" + i);
			user.setPassword("pass");
			listUser.add(user);
		}
		return listUser;
	}

}
