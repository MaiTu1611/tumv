package com.tumv.service;

import java.util.ArrayList;

import com.tumv.model.User;

public interface AdminService {
	ArrayList<User> getAllUser() throws Exception;
}
