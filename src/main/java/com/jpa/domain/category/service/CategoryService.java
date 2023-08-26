package com.jpa.domain.category.service;

import com.jpa.db.entity.category.Category;
import com.jpa.domain.category.model.rq.CreateCategoryRq;
import com.jpa.domain.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category saveCategory(CreateCategoryRq rq) {
        Category category = rq.toEntity();
        return categoryRepository.save(category);
    }
}
