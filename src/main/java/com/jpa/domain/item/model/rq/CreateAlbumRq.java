package com.jpa.domain.item.model.rq;

import com.jpa.domain.item.model.dto.ItemDto;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CreateAlbumRq {

    @NotNull
    private ItemDto itemDto;

    @NotNull
    private String artist;
}
