package com.jpa.db.entity.item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@DiscriminatorValue("Movie")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Movie extends Item {

    private String director;

    private String actor;

    public static Movie createMovie(String name, Integer stockQuantity,
        String director, String actor) {
        Movie movie = new Movie();
        movie.name = name;
        movie.stockQuantity = stockQuantity;
        movie.director = director;
        movie.actor = actor;
        return movie;
    }


}
