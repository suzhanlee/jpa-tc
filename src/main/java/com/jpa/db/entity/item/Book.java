package com.jpa.db.entity.item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@DiscriminatorValue("Book")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book extends Item {

    private String author;

    private String isbn;

    public static Book createBook(String name, Integer stockQuantity,
        String author, String isbn) {
        Book book = new Book();
        book.name = name;
        book.stockQuantity = stockQuantity;
        book.author = author;
        book.isbn = isbn;
        return book;
    }
}
