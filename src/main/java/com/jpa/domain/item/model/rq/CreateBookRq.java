package com.jpa.domain.item.model.rq;


import com.jpa.db.entity.item.Book;
import com.jpa.domain.item.model.dto.ItemDto;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CreateBookRq {

    @NotNull
    private ItemDto itemDto;

    @NotNull
    private String author;

    @NotNull
    private String isbn;

    public static CreateBookRq of(String name, Integer stockQuantity, Long categoryId,
        String author,
        String isbn) {
        CreateBookRq rq = new CreateBookRq();
        rq.itemDto = new ItemDto(name, stockQuantity, categoryId);
        rq.author = author;
        rq.isbn = isbn;
        return rq;
    }

    public Book toEntity() {
        return Book.createBook(itemDto.getName(), itemDto.getStockQuantity(), author, isbn);
    }
}
