package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        session.setAttribute("stickyUsername", username);

        User user = DaoFactory.getUsersDao().findByUsername(username);

        if (user == null) {
            session.setAttribute("errInvalidUsernamePassword", "is-invalid");
            response.sendRedirect("/login");
            return;
        }

        boolean validAttempt = Password.check(password, user.getPassword());

        if (validAttempt) {
            session.setAttribute("user", user);
            if (session.getAttribute("intended-redirect") != null) {
                response.sendRedirect("/" + session.getAttribute("intended-redirect"));
                return;
            }
            session.setAttribute("errInvalidUsernamePassword", "");
            response.sendRedirect("/profile");
        } else {
            session.setAttribute("errInvalidUsernamePassword", "is-invalid");
            response.sendRedirect("/login");
        }
    }
}
