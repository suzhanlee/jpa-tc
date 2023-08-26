package com.jpa.domain.item.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;
import static org.junit.jupiter.api.Assertions.*;

import com.jpa.db.entity.item.Album;
import com.jpa.db.entity.item.Book;
import com.jpa.db.entity.item.Item;
import com.jpa.db.entity.item.Movie;
import com.jpa.domain.item.repository.ItemRepository;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FindItemServiceTest {

    @Autowired
    private FindItemService findItemService;

    @Autowired
    private ItemRepository itemRepository;

    @BeforeEach
    void setUp() {
        Book book = Book.createBook("jpabook", 100, "김영한", "isbn");
        Album album = Album.createAlbum("glowforever", 10, "thequiet");
        Movie movie = Movie.createMovie("영화", 10, "영화감독", "영화배우");

        itemRepository.saveAll(List.of(book, album, movie));
    }

    @AfterEach
    void tearDown() {
        itemRepository.deleteAllInBatch();
    }

    @Test
    @DisplayName("상품 목록을 조회할 수 있습니다.")
    void findAllItems(){
        // when
        List<Item> itemList = findItemService.findAllItems();

        // then
        assertThat(itemList)
            .extracting("name", "stockQuantity")
            .contains(
                tuple("jpabook", 100),
                tuple("glowforever", 10),
                tuple("영화", 10)
            );

    }

    @Test
    @DisplayName("상품을 카테고리별로 조회할 수 있습니다.")
    void findAllItemsByCategory(){
        // given

        // when

        // then
    }

}