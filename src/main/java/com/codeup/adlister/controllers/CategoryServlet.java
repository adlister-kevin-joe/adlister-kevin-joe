package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.CategoryServlet", urlPatterns = "/category")
public class CategoryServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String category = request.getParameter("category");
        request.setAttribute("category", category);
        request.setAttribute("ads", DaoFactory.getAdsDao().searchForAdsByCategory(category));
        request.getRequestDispatcher("/WEB-INF/ads/category.jsp").forward(request, response);
    }
}
