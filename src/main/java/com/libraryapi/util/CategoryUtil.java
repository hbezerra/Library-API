package com.libraryapi.util;

import com.libraryapi.domain.category.Category;
import com.libraryapi.domain.category.CategoryDTO;
import com.libraryapi.exceptions.categoryExceptions.CategoryNotFoundException;
import com.libraryapi.exceptions.categoryExceptions.CategoryVinculateBookException;
import com.libraryapi.exceptions.categoryExceptions.ExistingCategoryException;
import com.libraryapi.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryUtil {

    private final CategoryRepository categoryRepository;

    // FUNCTIONS ;

    public Boolean existsByName(String name){
        return categoryRepository.existsByName(name);
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException("Category not found!"));
    }

    public void existByNameAndCategory(Category categoryUpdate, CategoryDTO categoryDTO) {
        if (!categoryUpdate.getName().equals(categoryDTO.name()) && this.existsByName(categoryDTO.name())) {
            throw new ExistingCategoryException("Category already exists");
        }
    }

    public void categoryVinculateBook(Category category) {
        if(!category.getBooks().isEmpty()) {throw new CategoryVinculateBookException("Category Vinculated a book!");}
    }

}
