package com.libraryapi.service;

import com.libraryapi.domain.category.Category;
import com.libraryapi.domain.category.CategoryDTO;
import com.libraryapi.exceptions.categoryExceptions.ExistingCategoryException;
import com.libraryapi.repository.CategoryRepository;
import com.libraryapi.util.CategoryUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryUtil categoryUtil;

    // FUNCTIONS ;

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Category saveCategory(CategoryDTO categoryDTO) {
        if (categoryUtil.existsByName(categoryDTO.name())) { throw new ExistingCategoryException("Category already exists"); }
        Category category = new Category();
        category.setName(categoryDTO.name());
        category.setDescription(categoryDTO.description());
        return categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        Category category = categoryUtil.getCategoryById(id);
        categoryUtil.categoryVinculateBook(category);
        categoryRepository.delete(category);
    }

    public Category updateCategory(Long id, CategoryDTO categoryDTO) {
        Category categoryUpdate =  categoryUtil.getCategoryById(id);
        categoryUtil.existByNameAndCategory(categoryUpdate, categoryDTO);

        categoryUpdate.setName(categoryDTO.name());
        categoryUpdate.setDescription(categoryDTO.description());

        return categoryRepository.save(categoryUpdate);

    }

}
