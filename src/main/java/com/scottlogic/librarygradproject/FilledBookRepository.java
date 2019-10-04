package com.scottlogic.librarygradproject;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FilledBookRepository extends BookRepository {

    public FilledBookRepository (List<Book> books){
        books.forEach(this::add);
    }

}
