package com.kyosk.assignment.controller;

import com.kyosk.assignment.entity.Book;
import com.kyosk.assignment.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BooksController {

    @Autowired
    private BooksService booksService;

    @GetMapping("/books")
    public List<Book> getBooks() {
        return booksService.getAllBooks();
    }

    // Add a new endpoint to create a new book
    // test 1
    // test 2
}
