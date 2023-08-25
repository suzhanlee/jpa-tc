package com.jpa.db.valuetype;

import jakarta.persistence.Column;
import lombok.Getter;

@Getter
public class Address {

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String zipcode;

}
