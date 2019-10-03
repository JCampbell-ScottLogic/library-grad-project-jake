package com.scottlogic.librarygradproject;

import org.junit.Before;
import org.junit.Test;
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

    private MockMvc mockMvc;
    private BooksController controller;
    private BookService mockService;

    @Before
    public void setUp() {
        mockService = mock(BookService.class);
        controller = new BooksController(mockService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void get_api_books() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/books"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"));

    }

    @Test
    public void getAll_Calls_Repo_GetAll() {
        // Act
        controller.getAll();
        // Assert
        verify(mockService).getAll();
    }

    @Test
    public void get_With_Id_Calls_Repo_Get() {
        // Arrange
        int id = 1;
        // Act
        controller.get(id);
        // Assert
        verify(mockService).get(id);
    }

//    @Test
//    public void get_With_Incorrect_Id_Throws_Null(){
//        assertThrows(NullPointerException.class,() -> {
//           controller.get(8);
//        });
//    }

    @Test
    public void post_With_Book_Calls_Repo_Add() {
        //Arrange
        Book newBook = new Book();
        // Act
        controller.post(newBook);
        // Assert
        verify(mockService).add(newBook);
    }

    @Test
    public void delete_With_Id_Calls_Repo_Remove() {
        // Arrange
        int id = 1;
        // Act
        controller.delete(id);
        // Assert
        verify(mockService).remove(id);
    }
}
