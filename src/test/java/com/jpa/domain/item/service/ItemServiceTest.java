package com.jpa.domain.item.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

import com.jpa.db.entity.item.Book;
import com.jpa.db.entity.item.Item;
import com.jpa.domain.item.model.rq.CreateBookRq;
import com.jpa.domain.item.repository.ItemRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class ItemServiceTest {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private FindItemService findItemService;

//    @PersistenceContext
//    private EntityManager em;

    @AfterEach
    void tearDown() {
        itemRepository.deleteAllInBatch();
    }

    @Test
    @DisplayName("상품(Book)을 등록할 수 있습니다.")
//    @Transactional
    void saveItemTest(){
        // given
        CreateBookRq rq = CreateBookRq.of("jpabook", 100,1L, "김영한", "isbn");

        // when
        Book book = itemService.saveBook(rq);
//        em.flush();
//        em.clear();
        Item findBook = findItemService.findByIdOrElseThrow(book.getId());
        Book newBook = (Book) findBook;

        // then
        assertThat(findBook.getName()).isEqualTo("jpabook");
        assertThat(findBook.getStockQuantity()).isEqualTo(100);
        assertThat(newBook.getAuthor()).isEqualTo("김영한");
        assertThat(newBook.getIsbn()).isEqualTo("isbn");

    }

}