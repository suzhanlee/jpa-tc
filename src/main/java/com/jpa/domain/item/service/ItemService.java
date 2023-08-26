package com.jpa.domain.item.service;

import com.jpa.db.entity.item.Book;
import com.jpa.db.entity.item.Item;
import com.jpa.domain.item.model.rq.CreateBookRq;
import com.jpa.domain.item.model.rq.UpdateBookRq;
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

    public Book updateBook(UpdateBookRq rq) {
        Item item = findItemService.findByIdOrElseThrow(rq.getBookId());
        Book book = (Book) item;
        return book.updateItem(rq.getItemDto(), rq.getAuthor(), rq.getIsbn());
    }
}
