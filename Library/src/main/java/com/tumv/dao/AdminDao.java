package com.tumv.dao;

import java.util.ArrayList;

import com.tumv.model.User;

public interface AdminDao {
	public ArrayList<User> getAllUser() throws Exception;
}
