package com.libraryapi.service;

import com.libraryapi.domain.author.Author;
import com.libraryapi.domain.author.AuthorDTO;
import com.libraryapi.repository.AuthorRepository;
import com.libraryapi.util.AuthorUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorUtil authorUtil;

    // FUNCTIONS ;

    public List<Author> getAuthors() { // Function responsible for returning all authors registered in the database ;
        return authorRepository.findAll();
    }

    public Author addAuthor(AuthorDTO authorDTO) { // Function responsible for adding an author in the database ;
        authorUtil.authorExists(authorDTO.email());
        Author author = new Author();
        author.setName(authorDTO.name());
        author.setEmail(authorDTO.email());
        author.setNacionality(authorDTO.nacionality());
        return authorRepository.save(author);
    }

    public void deleteAuthor(Long id) { // Function responsible for deleting an author in the database ;
        Author author = authorUtil.authorById(id);
        authorUtil.authorVinculateABook(author);
        authorRepository.delete(author);
    }

    public Author updateAuthor(Long id, AuthorDTO authorDTO) { // Function responsible for updating an author in the database ;
        Author author = authorUtil.authorById(id);
        authorUtil.existsAuthorByEmail(author, authorDTO);
        author.setName(authorDTO.name());
        author.setEmail(authorDTO.email());
        author.setNacionality(authorDTO.nacionality());
        return authorRepository.save(author);
    }

}
