package com.scottlogic.librarygradproject;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BookServiceTest {

    private BookRepository mockRepo;
    private BookService service;

    @Before
    public void setUp() {
        mockRepo = mock(BookRepository.class);
        service = new BookService(mockRepo);

    }


    @Test
    public void getAll_Calls_Repo_GetAll() {
        // Act
        service.getAll();
        // Assert
        verify(mockRepo).getAll();
    }


    @Test
    public void get_With_Id_Calls_Repo_Get() {

        Optional<Book> opBook = Optional.of(new Book());
        // Arrange
        int id = 0;
        when(mockRepo.get(id)).thenReturn(opBook);
        // Act
        service.get(id);
        // Assert
        verify(mockRepo).get(id);
    }

    @Test
    public void post_With_Book_Calls_Repo_Add() {
        //Arrange
        Book newBook = new Book();
        // Act
        service.add(newBook);
        // Assert
        verify(mockRepo).add(newBook);
    }

    @Test
    public void delete_With_Id_Calls_Repo_Remove() {
        // Arrange
        int id = 9;
        // Act
        service.remove(id);
        // Assert
        verify(mockRepo).remove(id);
    }

    @Test
    public void  put_With_Book_Calls_Repo_Add_Get(){
        //Arrange
        Book book = new Book();
        when(mockRepo.add(book)).thenReturn(0);
        //Act
        service.put(book);
        //Assert
        verify(mockRepo).get(0);
        verify(mockRepo).add(book);

    }

}