package com.codeup.adlister.controllers;

import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }

        User currentUser = (User) session.getAttribute("user");
        session.setAttribute("username", currentUser.getUsername());
        session.setAttribute("email", currentUser.getEmail());
        session.setAttribute("password", "***********");
        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }
}
