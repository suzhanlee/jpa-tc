package com.jpa.domain.item.service;

import static org.junit.jupiter.api.Assertions.*;

import com.jpa.domain.item.repository.ItemRepository;
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

    @Test
    @DisplayName("상품을 등록할 수 있습니다.")
    void saveItemTest(){
        // given
//        CreateItemRq createItemRq = CreateItemRq.of()

        // when

        // then
    }

}