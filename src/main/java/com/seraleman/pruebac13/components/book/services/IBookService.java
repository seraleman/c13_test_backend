package com.seraleman.pruebac13.components.book.services;

import java.util.List;

import com.seraleman.pruebac13.components.book.Book;

public interface IBookService {

    List<Book> getBooks();

    Book getBookById(String id);

    Book saveBook(Book book);

    void deleteBookById(String id);
}
