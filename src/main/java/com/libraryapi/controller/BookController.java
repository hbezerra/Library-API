package com.libraryapi.controller;

import com.libraryapi.domain.book.Book;
import com.libraryapi.domain.book.BookDTO;
import com.libraryapi.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    // FUNCTIONS ;

    @GetMapping
    public ResponseEntity<List<Book>> getBooks() { // Function responsible for returning all books registered in the database ;
        List<Book> books = bookService.getBooks();
        return ResponseEntity.ok().body(books);
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@Valid @RequestBody BookDTO bookDTO) { // Function responsible for adding a book in the database ;
        Book book = bookService.addBook(bookDTO);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(book.getId())
                .toUri();
        return ResponseEntity.created(location).body(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) { // Function responsible for delete a book in the database ;
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @Valid @RequestBody BookDTO bookDTO) { // Function responsible for updating a book in the database ;
        Book book = bookService.updateBook(id, bookDTO);
        return ResponseEntity.ok().body(book);
    }
}
