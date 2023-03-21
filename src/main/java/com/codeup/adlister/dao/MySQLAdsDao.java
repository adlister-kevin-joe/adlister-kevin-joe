package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
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
        String query = "SELECT * FROM ads as a INNER JOIN categories AS c ON a.category_id = c.category_id WHERE ad_id = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return extractAd(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a ad by id", e);
        }
    }

    @Override
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT a.ad_id, a.user_id, a.title, a.description, a.category_id, c.category FROM ads as a INNER JOIN categories AS c ON a.category_id = c.category_id");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public List<Ad> usersAds(Long userID) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads as a INNER JOIN adlister_users as u ON a.user_id = u.user_id INNER JOIN categories AS c ON a.category_id = c.category_id WHERE a.user_id = ?");
            stmt.setLong(1, userID);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
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
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, ad.getTitle());
            stmt.setString(2, ad.getDescription());
            stmt.setLong(3, ad.getCategoryId());
            stmt.setLong(4, ad.getId());
            stmt.executeUpdate();
//            ResultSet rs = stmt.getGeneratedKeys();
//            rs.next();
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("Error updating an ad.", e);
        }
    }

    @Override
    public Ad deleteByAdId(String id) {
        String query = "DELETE FROM ymir_joe.ads WHERE ad_id = ?";
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
            stmt = connection.prepareStatement("SELECT a.ad_id, a.user_id, a.title, a.description, a.category_id, c.category FROM ads as a INNER JOIN categories AS c ON a.category_id = c.category_id WHERE a.title LIKE ? OR a.description LIKE ?");
            stmt.setString(1, "%" + searchInput + "%");
            stmt.setString(2, "%" + searchInput + "%");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public List<Ad> searchForAdsByCategory(String category) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT a.ad_id, a.user_id, a.title, a.description, a.category_id, c.category FROM ads as a INNER JOIN categories AS c ON a.category_id = c.category_id WHERE c.category = ?");
            stmt.setString(1, category);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
            rs.getLong("ad_id"),
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("description"),
            rs.getLong("category_id"),
            rs.getString("category")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }
}
