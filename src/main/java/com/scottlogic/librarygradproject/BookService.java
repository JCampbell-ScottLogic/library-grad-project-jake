package com.scottlogic.librarygradproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class BookService {
    private BookRepository bookRepo;

//    @Autowired
    public BookService(BookRepository bookRepository){
        System.out.println("inside service");
        System.out.println(bookRepository.getAll());
        bookRepo = bookRepository;

        if (bookRepo.get(0).isPresent()) {
            System.out.println(bookRepo.get(0).get());
        }
    }

    public List<Book> getAll() {
        return bookRepo.getAll();
    }

    public Book get(int id) {
        Optional<Book> foundBook = bookRepo.get(id);
        return foundBook.orElseThrow(() -> new NoSuchElementException("Book with id " + id + " not found"));
    }

    public int remove(int id) {
        return bookRepo.remove(id);
    }

    public int add(Book book) {
        return bookRepo.add(book);
    }

    public int put(Book book) {
        if (bookRepo.get(book.getId()).isPresent() )bookRepo.remove(book.getId());
        return bookRepo.add(book);
    }
}
