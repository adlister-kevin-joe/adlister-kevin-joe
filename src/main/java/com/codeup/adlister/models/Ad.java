package com.codeup.adlister.models;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

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
    private List<Tag> tags;

    public Ad(long id, long userId, String title, String description, long categoryId, List<Tag> tags) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.categoryId = categoryId;
        this.tags = tags;
    }

    public Ad(long userId, String title, String description, long categoryId, List<Tag> tags) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.categoryId = categoryId;
        this.tags = tags;
    }
}
