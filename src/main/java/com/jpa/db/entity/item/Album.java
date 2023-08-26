package com.jpa.db.entity.item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@DiscriminatorValue("Album")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Album extends Item {

    private String artist;

    public static Album createAlbum(String name, Integer stockQuantity,
        String artist) {
        Album album = new Album();
        album.name = name;
        album.stockQuantity = stockQuantity;
        album.artist = artist;
        return album;
    }
}
