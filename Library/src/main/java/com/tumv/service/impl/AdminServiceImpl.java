package com.tumv.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tumv.dao.AdminDao;
import com.tumv.model.User;
import com.tumv.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDao adminDao;
	public ArrayList<User> getAllUser() throws Exception {
		ArrayList<User> listUser = adminDao.getAllUser();
		return listUser;
	}

}
