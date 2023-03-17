package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.NavbarSearchServlet", urlPatterns = "/navbarsearch")
public class NavbarSearchServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchInput = request.getParameter("search-input");
        request.setAttribute("ads", DaoFactory.getAdsDao().searchForAds(searchInput));
        request.getRequestDispatcher("/WEB-INF/ads/search_ads.jsp").forward(request, response);
    }
}