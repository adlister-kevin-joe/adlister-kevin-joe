package com.codeup.adlister.dao;

import com.codeup.adlister.models.Tag;
import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class MySQLTagsDao implements Tags {

    private Connection connection = null;

    public MySQLTagsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }
    @Override
    public List<Tag> all() {
        return null;
    }

    @Override
    public Tag findByTagId(String id) {
        return null;
    }
}
