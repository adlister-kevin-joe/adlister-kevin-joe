package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "controllers.ViewUsersAdsServlet", urlPatterns = "/myads")
public class ViewUsersAdsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (request.getSession().getAttribute("user") == null) {
            session.setAttribute("intended-redirect", "myads");
            response.sendRedirect("/login");
            return;
        }
        User currentUser = (User) request.getSession().getAttribute("user");
        request.setAttribute("ads", DaoFactory.getAdsDao().usersAds(currentUser.getId()));
        request.getRequestDispatcher("/WEB-INF/ads/users_ads.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String buttonClicked = request.getParameter("button");
        String adID = buttonClicked.replace("edit", "").replace("delete", "");

        if (buttonClicked.contains("edit")) {
            Ad ad = DaoFactory.getAdsDao().findByAdId(adID);
            request.setAttribute("categories", DaoFactory.getCategoriesDao().all());
            request.getSession().setAttribute("editAd", ad);
            request.getRequestDispatcher("/WEB-INF/ads/editAd.jsp").forward(request, response);
        } else {
//            DELETE FROM ymir_joe.ads WHERE ad_id = ?
            Ad ad = DaoFactory.getAdsDao().deleteByAdId(adID);
            request.getSession().setAttribute("deleteAd", ad);
            response.sendRedirect("/myads");
        }
    }
}