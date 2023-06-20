package com.devsuperior.services;

import com.devsuperior.dto.CategoryDTO;
import com.devsuperior.entities.Category;
import com.devsuperior.repositories.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {
        List<Category> list = categoryRepository.findAll();
        // Expressão lambda para transformar a list de cateregory em uma list de categoryDTO
        return list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
    }

}
