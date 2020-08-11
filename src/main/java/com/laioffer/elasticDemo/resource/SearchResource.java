package com.laioffer.elasticDemo.resource;


import com.laioffer.elasticDemo.entity.Book;
import com.laioffer.elasticDemo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class SearchResource {
    @Autowired
    BookRepository bookRepository;

    @GetMapping("/insert")
    public ResponseEntity<?> insert() {
        Book book = new Book(1, "Harry Potter", "Jk.R");
        bookRepository.save(book);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public ResponseEntity<?> search() {
        List<Book> bookList = bookRepository.findBooksByNameIsLike("Harry");
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }
}
