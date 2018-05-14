package com.tumv.model;


public class Book {
    private int bookId;
    private String bookName;
    private String bookType;
    private String bookAuther;
    private String bookStatus;
    public int getBookId() {
        return bookId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getBookType() {
        return bookType;
    }
    public void setBookType(String bookType) {
        this.bookType = bookType;
    }
    public String getBookAuther() {
        return bookAuther;
    }
    public void setBookAuther(String bookAuther) {
        this.bookAuther = bookAuther;
    }
    public String getBookStatus() {
        return bookStatus;
    }
    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }
}
