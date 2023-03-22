package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Tag;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
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

    @Override
    public void insertIntoAdTagTable(Ad ad, Long adId) {
        try {
            List<Tag> tags = ad.getTags();
            for (Tag tag : tags) {
                Long tagID = getTagID(tag);
                PreparedStatement stmt = connection.prepareStatement("INSERT INTO ymir_joe.ad_tag(ad_id, tag_id) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
                stmt.setLong(1, adId);
                stmt.setLong(2, tagID);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting into ad_tag table.", e);
        }
    }

    @Override
    public void deletingAdTagRelationships(Long adId) {
        try {
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM ymir_joe.ad_tag WHERE ad_id = ?");
            stmt.setLong(1, adId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting ad_tag relationships.", e);
        }
    }

    private Long getTagID(Tag tag) {
        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO tags (tag) VALUES (?) ON DUPLICATE KEY UPDATE tag_id=LAST_INSERT_ID(tag_id), tag = ?; SELECT LAST_INSERT_ID();", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, tag.toString());
            stmt.setString(2, tag.toString());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error getting tag id.", e);
        }
    }
}
