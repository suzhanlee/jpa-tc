package com.jpa.db.entity.item;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@DiscriminatorValue("Album")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Album extends Item{

    private String artist;

    private String etc;


}
