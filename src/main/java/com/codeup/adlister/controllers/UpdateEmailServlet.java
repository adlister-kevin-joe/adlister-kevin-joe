package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Validate;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "controllers.UpdateEmailServlet", urlPatterns = "/profile/update/email")
public class UpdateEmailServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            response.sendRedirect("/login");
        }

        session.removeAttribute("invalidemail");

        User currentUser = (User) session.getAttribute("user");
        String formEmail = request.getParameter("form-email");

        boolean isNotValidEmail = !Validate.isValid(formEmail);

        if (isNotValidEmail) {
            session.setAttribute("invalidemail", "is-invalid");
            response.sendRedirect("/profile");
            return;
        }



        // After form inputs are validated, do the following:
        currentUser.setEmail(formEmail);
        User updatedUser = currentUser;
        DaoFactory.getUsersDao().updateUser(updatedUser);
        session.removeAttribute("user");
        session.setAttribute("user", updatedUser);
        response.sendRedirect("/profile");
    }
}