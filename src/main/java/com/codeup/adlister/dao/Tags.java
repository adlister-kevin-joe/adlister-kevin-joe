package com.codeup.adlister.dao;

import com.codeup.adlister.models.Tag;

import java.util.List;

public interface Tags {

    List<Tag> all();

    Tag findByTagId(String id);

}
