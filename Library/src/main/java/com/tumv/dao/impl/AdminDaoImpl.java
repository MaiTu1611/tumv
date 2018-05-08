package com.tumv.dao.impl;

import java.util.ArrayList;

import com.tumv.dao.AdminDao;
import com.tumv.model.User;

public class AdminDaoImpl implements AdminDao{

	public ArrayList<User> getAllUser() throws Exception {
		ArrayList<User> listUser = new ArrayList<User>();
		for (int i = 0; i < 100; i++) {
			User user = new User();
		}
		return null;
	}

}
