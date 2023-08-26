package com.jpa.domain.item.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ItemDto {

    @NotNull
    private String name;

    @NotNull
    private Integer stockQuantity;

    @NotNull
    private Long categoryId;
}
