package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import java.util.List;

public interface Ads {

    List<Ad> all();

    Long insert(Ad ad);

    List<Ad> usersAds(Long userID);

    List<Ad> searchForAds(String searchInput);

    Ad findByAdId(String id);

    List<Ad> searchForAdsByCategory(String category);
}
