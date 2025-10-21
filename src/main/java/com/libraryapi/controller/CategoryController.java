package com.libraryapi.controller;

import com.libraryapi.domain.category.Category;
import com.libraryapi.domain.category.CategoryDTO;
import com.libraryapi.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    // FUNCTIONS ;

    @GetMapping
    public ResponseEntity<List<Category>> getCategories() { // Function responsible for returning all categories registered in the database ;
        List<Category> categories = categoryService.getCategories();
        return ResponseEntity.ok().body(categories);
    }

    @PostMapping
    public ResponseEntity<Category> addCategory(@Valid @RequestBody CategoryDTO categoryDTO) { // Function responsible for adding category in the database ;
        Category categoryCreated = categoryService.saveCategory(categoryDTO);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(categoryCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(categoryCreated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) { // Function responsible for delete category in the database ;
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @Valid @RequestBody CategoryDTO categoryDTO) { // Function responsible for updating category in the database ;
        Category categoryUpdate = categoryService.updateCategory(id, categoryDTO);
        return ResponseEntity.ok().body(categoryUpdate);
    }
}
