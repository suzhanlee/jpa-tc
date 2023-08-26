package com.jpa.domain.category.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.jpa.db.entity.category.Category;
import com.jpa.domain.category.model.rq.CreateCategoryRq;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CategoryServiceTest {

    @Autowired
    private FindCategoryService findCategoryService;
    @Autowired
    private CategoryService categoryService;

    @Test
    @DisplayName("상품을 등록할 수 있습니다.")
    void saveCategory() {

        // given
        CreateCategoryRq rq = CreateCategoryRq.of("여가활동");

        // when
        Category category = categoryService.saveCategory(rq);
        Category findCategory = findCategoryService.findByIdOrElseThrow(category.getId());

        // then
        assertThat(findCategory.getName()).isEqualTo("여가활동");
    }

}