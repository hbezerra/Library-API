package com.libraryapi.util;

import com.libraryapi.domain.book.Book;
import com.libraryapi.exceptions.bookExceptions.BookNotFoundException;
import com.libraryapi.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookUtil {

    private final BookRepository bookRepository;

    // FUNCTIONS ;

    public Book findBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found"));
    }

}
