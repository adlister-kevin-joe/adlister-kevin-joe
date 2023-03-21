package com.codeup.adlister.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Tag {
    private String tag;
    private Long tagID;

    public Tag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "" + tag;
    }
}
