package com.jpa.domain.category.model.rq;

import com.jpa.db.entity.category.Category;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CreateCategoryRq {

    @NotNull
    private String name;

    public static CreateCategoryRq of(String name) {
        CreateCategoryRq rq = new CreateCategoryRq();
        rq.name = name;
        return rq;
    }

    public Category toEntity() {
        return Category.createCategory(name);
    }
}
