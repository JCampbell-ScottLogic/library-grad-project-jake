package com.scottlogic.librarygradproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookRepository implements Repository<Book,Integer> {

    private List<Book> bookCollection = new ArrayList<>();

    @Override
    public Optional<Book> get(Integer id) {
        return bookCollection.stream().filter(book -> book.getId() == id).findFirst();
    }

    @Override
    public List<Book> getAll() {
        return bookCollection;
    }

    @Override
    public Integer add(Book entity) {
        int id = bookCollection.size();

        entity.setId(id);
        bookCollection.add(entity);
        return  id;
    }

    @Override
    public Integer remove(Integer id) {
        if (get(id).isPresent()) {
            bookCollection.remove(get(id).get());
            return id;
        }
        return -1;
    }
}
