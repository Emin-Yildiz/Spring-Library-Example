package com.example.library.controller;

import com.example.library.dto.request.BookCreateDTO;
import com.example.library.dto.response.BookGetResponseDTO;
import com.example.library.entities.Book;
import com.example.library.services.BookService;
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
    public List<BookGetResponseDTO> getAllBook(){
        return bookService.getAllBook();
    }


    @PostMapping
    public Book addBook(@RequestBody BookCreateDTO createDTO){
        return bookService.addBook(createDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        bookService.deleteById(id);
    }
}
