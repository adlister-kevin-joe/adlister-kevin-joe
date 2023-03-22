package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Tag;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
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
    public Ad findByAdId(String id) {
        String query = "SELECT a.ad_id, a.user_id, a.title, a.description, a.category_id, c.category, at.tag_id, t.tag FROM ads as a INNER JOIN categories AS c ON a.category_id = c.category_id INNER JOIN ad_tag AS at on a.ad_id = at.ad_id INNER JOIN tags AS t on at.tag_id = t.tag_id WHERE a.ad_id = ? GROUP BY a.ad_id LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            List<Tag> tags = extractTags(rs);
            return extractAd(rs, tags);
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a ad by id", e);
        }
    }

    // Use two queries, one to get the distinct ad_id's and another to get a result set for the tags per ad_id
    @Override
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT a.ad_id, a.user_id, a.title, a.description, a.category_id, c.category, at.tag_id, t.tag FROM ads as a INNER JOIN categories AS c ON a.category_id = c.category_id INNER JOIN ad_tag AS at on a.ad_id = at.ad_id INNER JOIN tags AS t on at.tag_id = t.tag_id GROUP BY a.ad_id");
            ResultSet adsResultSet = stmt.executeQuery();
            return createAdsFromResults(adsResultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public List<Ad> usersAds(Long userID) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ymir_joe.ads as a INNER JOIN ymir_joe.adlister_users as u ON a.user_id = u.user_id INNER JOIN ymir_joe.categories AS c ON a.category_id = c.category_id WHERE a.user_id = ?");
            stmt.setLong(1, userID);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving users ads.", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ymir_joe.ads(user_id, title, description, category_id) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.setLong(4, ad.getCategoryId());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    @Override
    public Long updateAd(Ad ad) {
        try {
            String insertQuery = "UPDATE ymir_joe.ads SET title = ?, description = ?, category_id = ? WHERE ad_id = ?";
            PreparedStatement stmt = connection.prepareStatement(insertQuery);
            stmt.setString(1, ad.getTitle());
            stmt.setString(2, ad.getDescription());
            stmt.setLong(3, ad.getCategoryId());
            stmt.setLong(4, ad.getId());
            stmt.executeUpdate();
            return ad.getId();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating an ad.", e);
        }
    }

    @Override
    public Ad deleteByAdId(String id) {
        String query = "DELETE FROM ymir_joe.ads WHERE ad_id = ?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, id);
            stmt.executeUpdate();
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting an ad by id", e);
        }
    }

    @Override
    public List<Ad> searchForAds(String searchInput) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT a.ad_id, a.user_id, a.title, a.description, a.category_id, c.category, at.tag_id, t.tag FROM ads as a INNER JOIN categories AS c ON a.category_id = c.category_id INNER JOIN ad_tag AS at on a.ad_id = at.ad_id INNER JOIN tags AS t on at.tag_id = t.tag_id WHERE a.title LIKE ? OR a.description LIKE ? OR t.tag LIKE ? GROUP BY a.ad_id");
//            stmt = connection.prepareStatement("SELECT a.ad_id, a.user_id, a.title, a.description, a.category_id, c.category FROM ymir_joe.ads as a INNER JOIN ymir_joe.categories AS c ON a.category_id = c.category_id WHERE a.title LIKE ? OR a.description LIKE ?");
            stmt.setString(1, "%" + searchInput + "%");
            stmt.setString(2, "%" + searchInput + "%");
            stmt.setString(3, "%" + searchInput + "%");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error searching for ads.", e);
        }
    }

    @Override
    public List<Ad> searchForAdsByCategory(String category) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT a.ad_id, a.user_id, a.title, a.description, a.category_id, c.category FROM ymir_joe.ads as a INNER JOIN ymir_joe.categories AS c ON a.category_id = c.category_id WHERE c.category = ?");
            stmt.setString(1, category);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<Ad> createAdsFromResults(ResultSet adsResultSet) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (adsResultSet.next()) {
            List<Tag> tags = extractTags(adsResultSet);
            ads.add(extractAd(adsResultSet, tags));
        }
        return ads;
    }

    private List<Tag> extractTags(ResultSet adsResultSet) throws SQLException {
        List<String> tagsStringArray = new ArrayList<>();
        List<Tag> tags = new ArrayList<>();
        PreparedStatement stmt = connection.prepareStatement("SELECT t.tag FROM tags t INNER JOIN ad_tag at ON t.tag_id = at.tag_id INNER JOIN ads a ON at.ad_id = a.ad_id WHERE at.ad_id = ?");
        stmt.setLong(1, adsResultSet.getLong("ad_id"));
        ResultSet newResultSet = stmt.executeQuery();
        while (newResultSet.next()) {
            tagsStringArray.add(newResultSet.getString(1));
        }
        for (String string : tagsStringArray) {
            Tag newTag = new Tag(string);
            tags.add(newTag);
        }
        return tags;
    }

    private Ad extractAd(ResultSet adsResultSet, List<Tag> tags) throws SQLException {
        return new Ad(
                adsResultSet.getLong("ad_id"),
                adsResultSet.getLong("user_id"),
                adsResultSet.getString("title"),
                adsResultSet.getString("description"),
                adsResultSet.getLong("category_id"),
                adsResultSet.getString("category"),
                tags
        );
    }

}
