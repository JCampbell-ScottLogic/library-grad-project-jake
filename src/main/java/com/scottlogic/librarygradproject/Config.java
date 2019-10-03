package com.scottlogic.librarygradproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public BookRepository getBookRepository(){
        return new BookRepository();
    }

    @Autowired
    @Bean
    public BookService getBookService(BookRepository bookRepo ){
        return new BookService(bookRepo);
    }
}
