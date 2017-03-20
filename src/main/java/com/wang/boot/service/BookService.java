package com.wang.boot.service;

import com.wang.boot.config.BookProperties;

public class BookService {
    private BookProperties bookProperties;
    public BookService(BookProperties bookProperties){
        this.bookProperties = bookProperties;
    }
    public BookService(){
    }

    public String getName(){
        return bookProperties.getName();
    }

    public String getIsbn() {
        return bookProperties.getIsbn();
    }

    public String getAuthor() {
        return bookProperties.getAuthor();
    }

}