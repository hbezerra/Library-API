package com.libraryapi.util;

import com.libraryapi.domain.author.Author;
import com.libraryapi.domain.author.AuthorDTO;

import com.libraryapi.exceptions.authorExceptions.AuthorNotFoundException;
import com.libraryapi.exceptions.authorExceptions.AuthorVinculateBookException;
import com.libraryapi.exceptions.authorExceptions.ExistingAuthorException;
import com.libraryapi.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthorUtil {

    private final AuthorRepository authorRepository;

    // FUNCTIONS ;

    public void authorExists(String email) {
        if(authorRepository.existsByEmail(email)) throw new ExistingAuthorException("Author already exists");
    }

    public Author authorById(Long id) {
        return authorRepository.findById(id).orElseThrow(() -> new ExistingAuthorException("Author not found"));
    }

    public void existsAuthorByEmail(Author authorUpdate, AuthorDTO authorDTO) {
        if(!authorUpdate.getEmail().equals(authorDTO.email()) && this.authorRepository.existsByEmail(authorDTO.email())) {
            throw new AuthorNotFoundException("Author already exists");
        }
    }

    public void authorVinculateABook(Author author) {
        if(!author.getBooks().isEmpty()) {throw new AuthorVinculateBookException("Author Vinculated a book!");}
    }
}
