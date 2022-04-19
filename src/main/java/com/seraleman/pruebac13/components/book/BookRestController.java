package com.seraleman.pruebac13.components.book;

import java.util.List;

import javax.validation.Valid;

import com.seraleman.pruebac13.components.book.services.IBookService;
import com.seraleman.pruebac13.helpers.response.IResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookRestController {

    @Autowired
    private IBookService bookService;

    @Autowired
    private IResponse response;

    @GetMapping("/")
    public ResponseEntity<?> getBooks() {
        try {
            List<Book> books = bookService.getBooks();
            if (books.isEmpty()) {
                return response.empty();
            }
            return response.list(books);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable String id) {
        try {
            Book book = bookService.getBookById(id);
            if (book == null) {
                return response.notFound(id);
            }
            return response.found(book);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> createBook(@Valid @RequestBody Book book, BindingResult result) {

        if (result.hasErrors()) {
            return response.invalidObject(result);
        }
        try {
            return response.created(bookService.saveBook(book));
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBookById(
            @PathVariable String id,
            @Valid @RequestBody Book book,
            BindingResult result) {

        if (result.hasErrors()) {
            return response.invalidObject(result);
        }
        try {
            Book currentBook = bookService.getBookById(id);
            if (currentBook == null) {
                return response.notFound(id);
            }
            currentBook.setAuthor(book.getAuthor());
            currentBook.setDescription(book.getDescription());
            currentBook.setGenre(book.getGenre());
            currentBook.setName(book.getName());

            return response.updated(bookService.saveBook(currentBook));
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBookById(@PathVariable String id) {
        try {
            Book currentBook = bookService.getBookById(id);
            if (currentBook == null) {
                return response.notFound(id);
            }
            bookService.deleteBookById(id);
            return response.deleted();
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }
    }

}
