package com.tumv.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.tumv.model.Book;
import com.tumv.model.User;

@Service
public interface AdminService {
	ArrayList<User> getAllUser() throws Exception;
	ArrayList<Book> getAllBook() throws Exception;
}
