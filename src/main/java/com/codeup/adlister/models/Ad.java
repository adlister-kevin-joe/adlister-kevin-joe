package com.codeup.adlister.models;

import lombok.*;

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

    public Ad(long userId, String title, String description, long categoryId) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.categoryId = categoryId;
    }
}
