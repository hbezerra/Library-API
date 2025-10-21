package com.libraryapi.domain.category;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.libraryapi.domain.book.Book;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false, unique = true)
    private String name;

    @Column(length = 250, nullable = false)
    private String description;

    @OneToMany(mappedBy = "category")
    @JsonBackReference
    private List<Book> books = new ArrayList<>();

}
