package com.seraleman.pruebac13.components.book.services;

import java.util.List;

import com.seraleman.pruebac13.components.book.Book;
import com.seraleman.pruebac13.components.book.IBookDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private IBookDao bookDao;

    @Override
    public List<Book> getBooks() {
        return bookDao.findAll();
    }

    @Override
    public Book getBookById(String id) {
        return bookDao.findById(id).orElse(null);
    }

    @Override
    public Book saveBook(Book book) {
        return bookDao.save(book);
    }

    @Override
    public void deleteBookById(String id) {
        bookDao.deleteById(id);
    }

}
