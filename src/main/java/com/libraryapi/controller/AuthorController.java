package com.libraryapi.controller;

import com.libraryapi.domain.author.Author;
import com.libraryapi.domain.author.AuthorDTO;
import com.libraryapi.service.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    // FUNCTIONS ;

    @GetMapping
    public ResponseEntity<List<Author>> getAuthors() { // Function responsible for returning all authors registered in the database ;
        List<Author> authors = authorService.getAuthors();
        return ResponseEntity.ok().body(authors);
    }

    @PostMapping
    public ResponseEntity<Author> addAuthor(@Valid @RequestBody AuthorDTO authorDTO) { // Function responsible for adding an author in the database ;
        Author author = authorService.addAuthor(authorDTO);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(author.getId())
                .toUri();
        return ResponseEntity.created(location).body(author);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) { // Function responsible for deleting an author in the database ;
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@Valid @RequestBody AuthorDTO authorDTO, @PathVariable Long id) { // Function responsible for updating an author in the database ;
        Author author = authorService.updateAuthor(id, authorDTO);
        return ResponseEntity.ok().body(author);
    }


}
