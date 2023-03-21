package com.codeup.adlister.models;

import lombok.*;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Ad {
    private long id;
    private long userId;
    private String title;
    private String description;
    private long categoryId;
    private String category;

    public Ad(long id, long userId, String title, String description, long categoryId) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.categoryId = categoryId;
    }

    public Ad(long userId, String title, String description, long categoryId) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.categoryId = categoryId;
    }
}
