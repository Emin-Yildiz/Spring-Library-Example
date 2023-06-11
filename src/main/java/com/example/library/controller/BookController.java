package com.example.library.controller;

import com.example.library.dto.request.BookCreateDTO;
import com.example.library.dto.response.BookGetResponseDTO;
import com.example.library.entities.Book;
import com.example.library.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookGetResponseDTO>> getAllBook(){
        return ResponseEntity.ok(bookService.getAllBook());
    }


    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody BookCreateDTO createDTO){
        return new ResponseEntity<>(bookService.addBook(createDTO),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        bookService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
