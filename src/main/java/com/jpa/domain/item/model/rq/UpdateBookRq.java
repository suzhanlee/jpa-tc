package com.jpa.domain.item.model.rq;

import com.jpa.db.entity.item.Book;
import com.jpa.domain.item.model.dto.ItemDto;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class UpdateBookRq {

    @NotNull
    private ItemDto itemDto;

    @NotNull
    private Long bookId;

    @NotNull
    private String author;

    @NotNull
    private String isbn;

    public static UpdateBookRq of(String name, Integer stockQuantity, Long categoryId,
        Long bookId,
        String author,
        String isbn) {
        UpdateBookRq rq = new UpdateBookRq();
        rq.itemDto = new ItemDto(name, stockQuantity, categoryId);
        rq.bookId = bookId;
        rq.author = author;
        rq.isbn = isbn;
        return rq;
    }

    public Book toEntity() {
        return Book.createBook(itemDto.getName(), itemDto.getStockQuantity(), author, isbn);
    }

}
