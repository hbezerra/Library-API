package com.libraryapi.repository;

import com.libraryapi.domain.author.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Boolean existsByEmail(String email);

}
