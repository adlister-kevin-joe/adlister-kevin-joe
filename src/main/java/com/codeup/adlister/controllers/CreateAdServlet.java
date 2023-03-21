package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Tag;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }

        request.setAttribute("categories", DaoFactory.getCategoriesDao().all());

        request.getRequestDispatcher("/WEB-INF/ads/create.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        long categoryId = Long.parseLong(request.getParameter("categoryId"));
        String[] tags = request.getParameter("tags").split(",");

        request.getSession().setAttribute("stickyTitle", title);
        request.getSession().setAttribute("stickyDescription", description);
        request.getSession().setAttribute("stickyCategory", categoryId);
        request.getSession().setAttribute("stickyTag", tags);

        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }

        User currentUser = (User) request.getSession().getAttribute("user");

        Ad ad = new Ad(
                currentUser.getId(),
                title,
                description,
                categoryId
        );

        DaoFactory.getAdsDao().insert(ad);
        response.sendRedirect("/ads");
    }
}
