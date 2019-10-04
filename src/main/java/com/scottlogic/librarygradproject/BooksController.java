package com.scottlogic.librarygradproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Component
@RestController
@RequestMapping("/api")
public class BooksController {

    private BookService bookService;

    @Autowired
    public BooksController(BookService bookService){
        this.bookService = bookService;
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    public Book get(@PathVariable int id) {
        System.out.println(id);
        return bookService.get(id);
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        bookService.remove(id);
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public void post(@RequestBody() Book book) {
        bookService.add(book);
    }

    @RequestMapping(value = "/books", method = RequestMethod.PUT)
    public RedirectView  put(@RequestBody() Book book){
        bookService.put(book);
        return new RedirectView("/api/books");
    }
}
