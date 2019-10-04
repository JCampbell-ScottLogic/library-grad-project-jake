package com.scottlogic.librarygradproject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    private Book book;

    @BeforeEach
    void setUp() {
        book = new Book("isbn","title","author","date");

    }

    @Test
    void get_Set_Id() {
        int newId =0 ;
        book.setId(0);
        assertEquals(book.getId(),0);
    }

    @Test
    void getIsbn() {
        assertEquals("isbn",book.getIsbn());
    }

    @Test
    void setIsbn() {
        String newVal = "newIsbn";
        book.setIsbn(newVal);
        assertEquals(newVal,book.getIsbn());
    }

    @Test
    void getTitle() {
        assertEquals("title",book.getTitle());
    }

    @Test
    void setTitle() {
        String newVal = "newIsbn";
        book.setTitle(newVal);
        assertEquals(newVal,book.getTitle());
    }

    @Test
    void getAuthor() {
        assertEquals("author",book.getAuthor());
    }

    @Test
    void setAuthor() {
        String newVal = "newAuthor";
        book.setAuthor(newVal);
        assertEquals(newVal,book.getAuthor());
    }

    @Test
    void getPublishDate() {
        assertEquals("date",book.getPublishDate());
    }

    @Test
    void setPublishDate() {
        String newVal = "newDate";
        book.setPublishDate(newVal);
        assertEquals(newVal,book.getPublishDate());
    }

    @Test
    void testEquals() {
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book("isbn","title","author","date2");
        Book book4 = new Book("isbn","title","author2","date");
        Book book5 = new Book("isbn","title2","author","date");
        Book book6 = new Book("isbn2","title","author","date");
        Book bookSame = new Book("isbn","title","author","date");

        assertNotEquals(book, book1);
        assertEquals(book1, book2);

        assertNotEquals(book,book3);
        assertNotEquals(book,book4);
        assertNotEquals(book,book5);
        assertNotEquals(book,book6);

        assertEquals(book,bookSame);

    }

    @Test
    void testHashCode() {
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book("isbn","title","author","date2");
        Book book4 = new Book("isbn","title","author2","date");
        Book book5 = new Book("isbn","title2","author","date");
        Book book6 = new Book("isbn2","title","author","date");
        Book bookSame = new Book("isbn","title","author","date");

        assertNotEquals(book1.hashCode(),book.hashCode());
        assertEquals(book1.hashCode(),book2.hashCode());

        assertNotEquals(book.hashCode(),book3.hashCode());
        assertNotEquals(book.hashCode(),book4.hashCode());
        assertNotEquals(book.hashCode(),book5.hashCode());
        assertNotEquals(book.hashCode(),book6.hashCode());

        assertEquals(book.hashCode(),bookSame.hashCode());
    }
}