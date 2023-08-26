package com.jpa.domain.category.service;

import com.jpa.db.entity.category.Category;
import com.jpa.domain.category.repository.CategoryRepository;
import com.jpa.domain.global.exception.category.CannotFindCategoryException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FindCategoryService {

    private final CategoryRepository categoryRepository;

    public Category findByIdOrElseThrow(Long id) {
        return categoryRepository.findById(id).orElseThrow(CannotFindCategoryException::new);
    }
}
