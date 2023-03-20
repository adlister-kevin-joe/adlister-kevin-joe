package com.codeup.adlister.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Category {

    private long categoryID;

    private String category;

    public Category(String category) {
        this.category = category;
    }
}
