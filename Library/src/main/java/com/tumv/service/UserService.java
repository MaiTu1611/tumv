package com.tumv.service;

import java.util.ArrayList;

import com.tumv.model.Book;

public interface UserService {
	ArrayList<Book> getAllBook() throws Exception;
}
