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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "controllers.EditAdServlet", urlPatterns = "/ads/editad")
public class EditAdServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        long categoryId = Long.parseLong(request.getParameter("categoryId"));
        List<Tag> tags = request.getParameter("tags");
        String[] tagsStringArray = request.getParameter("tags").split(",");
        for (String string : tagsStringArray) {
        }
        List<Tag> tags = new ArrayList<>();

        for (String string : tagsStringArray) {
            Tag newTag = new Tag(string);
            tags.add(newTag);
        }

        request.getSession().setAttribute("stickyEditTitle", title);
        request.getSession().setAttribute("stickyEditDescription", description);
        request.getSession().setAttribute("stickyCategory", categoryId);
        request.getSession().setAttribute("stickyTag", tags);

        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }

        User currentUser = (User) request.getSession().getAttribute("user");
        Ad editAd = (Ad) request.getSession().getAttribute("editAd");

        Ad ad = new Ad(
                editAd.getId(),
                currentUser.getId(),
                title,
                description,
                categoryId,
                tags
        );

        DaoFactory.getTagsDao().insertIntoAdTagTable(ad, DaoFactory.getAdsDao().updateAd(ad));
//        DaoFactory.getAdsDao().updateAd(ad);
        response.sendRedirect("/myads");
    }
}