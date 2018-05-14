package com.tumv.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.tumv.model.Book;
import com.tumv.model.User;

@Repository
public interface AdminDao {
    public ArrayList<User> getAllUser() throws Exception;
    public ArrayList<Book> getAllBook() throws Exception;
}
