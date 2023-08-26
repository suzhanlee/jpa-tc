package com.jpa.domain.item.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.jpa.db.entity.item.Book;
import com.jpa.db.entity.item.Item;
import com.jpa.domain.item.model.rq.CreateBookRq;
import com.jpa.domain.item.model.rq.UpdateBookRq;
import com.jpa.domain.item.repository.ItemRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
    void saveItemTest() {
        // given
        CreateBookRq rq = CreateBookRq.of("jpabook", 100, 1L, "김영한", "isbn");

        // when
        Book book = itemService.saveBook(rq);
//        em.flush();
//        em.clear();
        Item findBook = findItemService.findByIdOrElseThrow(book.getId());
        Book newBook = (Book) findBook;

        // then
        assertThat(newBook.getName()).isEqualTo("jpabook");
        assertThat(newBook.getStockQuantity()).isEqualTo(100);
        assertThat(newBook.getAuthor()).isEqualTo("김영한");
        assertThat(newBook.getIsbn()).isEqualTo("isbn");

    }

    @Test
    @DisplayName("상품(Book)을 수정할 수 있습니다")
    void updateItem() {
        // given
        CreateBookRq createBookRq = CreateBookRq.of("jpabook", 100, 1L, "김영한", "isbn");
        Book book = itemService.saveBook(createBookRq);
        UpdateBookRq rq = UpdateBookRq.of("update-jpabook", 200, 1L, book.getId(), "김영한2", "isbn2");

        // when
        Book updateBook = itemService.updateBook(rq); //update 쿼리도 item과 book 2개 날라간다.
        Item findItem = findItemService.findByIdOrElseThrow(book.getId());
        Book findBook = (Book) findItem;

        // then
        assertThat(findBook.getName()).isEqualTo("update-jpabook");
        assertThat(findBook.getStockQuantity()).isEqualTo(200);
        assertThat(findBook.getAuthor()).isEqualTo("김영한2");
        assertThat(findBook.getIsbn()).isEqualTo("isbn2");
    }

}