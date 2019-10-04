package com.scottlogic.librarygradproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class Config {

    @Bean("emptyRepository")
    public BookRepository getBookRepository(){
        return new BookRepository();
    }

    @Bean
    @Autowired
    public BookService getBookService(@Qualifier("filledRepository") BookRepository bookRepo ){
        return new BookService(bookRepo);
    }

    @Bean("filledRepository")
    public FilledBookRepository getFilledRepository(List<Book> books){
        return new FilledBookRepository(books);
    }

    @Bean
    public List<Book> getListOfEmptyBooks(){
        Book b1 = new Book();
        Book b2 = new Book();
        Book b3 = new Book();
        return Arrays.asList(b1,b2,b3);
    }
}
