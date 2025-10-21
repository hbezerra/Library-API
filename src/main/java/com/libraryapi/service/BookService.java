package com.libraryapi.service;

import com.libraryapi.domain.author.Author;
import com.libraryapi.domain.book.Book;
import com.libraryapi.domain.book.BookDTO;
import com.libraryapi.domain.category.Category;
import com.libraryapi.repository.BookRepository;
import com.libraryapi.util.AuthorUtil;
import com.libraryapi.util.BookUtil;
import com.libraryapi.util.CategoryUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final CategoryUtil categoryUtil;
    private final AuthorUtil authorUtil;
    private final BookUtil bookUtil;

    // FUNCTIONS ;

    public List<Book> getBooks() {// Function responsible for returning all books registered in the database ;
        return bookRepository.findAll();
    }

    public Book addBook(BookDTO bookDTO) { // Function responsible for adding a book in the database ;
        Category category = categoryUtil.getCategoryById(bookDTO.categoryId());
        Author author = authorUtil.authorById(bookDTO.authorId());

        Book book = new Book();
        book.setTitle(bookDTO.title());
        book.setPrice(bookDTO.price());
        book.setPublicationYear(bookDTO.publicationYear());
        book.setCategory(category);
        book.setAuthor(author);

        return bookRepository.save(book);
    }

    public void deleteBook(Long id) { // Function responsible for delete a book in the database ;
        Book book = bookUtil.findBookById(id);
        bookRepository.delete(book);
    }

    public Book updateBook(Long id, BookDTO bookDTO) { // Function responsible for updating a book in the database ;

        Book book = bookUtil.findBookById(id);

        Category category = categoryUtil.getCategoryById(bookDTO.categoryId());
        Author author = authorUtil.authorById(bookDTO.authorId());

        book.setTitle(bookDTO.title());
        book.setPrice(bookDTO.price());
        book.setPublicationYear(bookDTO.publicationYear());
        book.setCategory(category);
        book.setAuthor(author);

        return bookRepository.save(book);
    }
}
