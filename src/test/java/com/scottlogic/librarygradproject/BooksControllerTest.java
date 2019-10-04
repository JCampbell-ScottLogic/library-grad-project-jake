package com.scottlogic.librarygradproject;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BooksControllerTest {


    private BooksController controller;
    private BookService mockService;

    @Before
    public void setUp() {
        mockService = mock(BookService.class);
        controller = new BooksController(mockService);

    }
//    private MockMvc mockMvc;
//
//    mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
//    @Test
//    public void get_api_books() throws Exception{
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/books"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"));
//
//    }

    @Test
    public void getAll_Calls_Service_GetAll() {
        // Act
        controller.getAll();
        // Assert
        verify(mockService).getAll();
    }

    @Test
    public void get_With_Id_Calls_Service_Get() {
        // Arrange
        int id = 1;
        // Act
        controller.get(id);
        // Assert
        verify(mockService).get(id);
    }

    @Test
    public void post_With_Book_Calls_Service_Add() {
        //Arrange
        Book newBook = new Book();
        // Act
        controller.post(newBook);
        // Assert
        verify(mockService).add(newBook);
    }

    @Test
    public void delete_With_Id_Calls_Service_Remove() {
        // Arrange
        int id = 1;
        // Act
        controller.delete(id);
        // Assert
        verify(mockService).remove(id);
    }

    @Test
    public void put_With_Book_Calls_Service_Put(){
        //Arrange
        Book book = new Book();
        //Act
        controller.put(book);
        //Assert
        verify(mockService).put(book);
    }
}
