package com.tumv.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.tumv.model.Book;

@Service
public interface UserService {
	ArrayList<Book> getAllBook() throws Exception;
}
