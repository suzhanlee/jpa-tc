package com.jpa.domain.item.service;

import com.jpa.db.entity.item.Book;
import com.jpa.domain.item.model.rq.CreateBookRq;
import com.jpa.domain.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {

    private final FindItemService findItemService;
    private final ItemRepository itemRepository;

    public Book saveBook(CreateBookRq rq) {
        Book book = rq.toEntity();
        itemRepository.save(book);
        return book;
    }
}
