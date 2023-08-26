package com.jpa.domain.item.service;

import com.jpa.db.entity.item.Item;
import com.jpa.domain.global.exception.item.CannotFindItemException;
import com.jpa.domain.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FindItemService {

    private final ItemRepository itemRepository;

    public Item findByIdOrElseThrow(Long id) {
        return itemRepository.findById(id).orElseThrow(CannotFindItemException::new);
    }
}
