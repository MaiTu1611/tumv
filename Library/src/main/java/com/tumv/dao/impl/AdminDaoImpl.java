package com.tumv.dao.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.tumv.dao.AdminDao;
import com.tumv.model.Book;
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

    public ArrayList<Book> getAllBook() throws Exception {
        ArrayList<Book> listBook = new ArrayList<Book>();
        for (int i = 0; i < 100; i++) {
            Book book = new Book();
            book.setBookId(i);
            book.setBookName("Book" + i);
            if(i % 2 == 0) {
                book.setBookType("A");
            } else if (i % 3 == 0)  {
                book.setBookType("B");
            } else {
                book.setBookType("C");
            }
            book.setBookAuther("bookAuther" + i);
            book.setBookStatus("NEW");
            listBook.add(book);
        }
        return listBook;
    }

}
