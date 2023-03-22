package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "controllers.UpdatePasswordServlet", urlPatterns = "/profile/update/password")
public class UpdatePasswordServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            response.sendRedirect("/login");
        }

        User currentUser = (User) session.getAttribute("user");

        String oldPassword = request.getParameter("old-password");
        String formPassword = request.getParameter("form-password");
        String confirmFormPassword = request.getParameter("confirm-form-password");

        boolean correctOldPassword = Password.check(oldPassword, currentUser.getPassword());
        boolean updatedPasswordMatchesConfirmedPassword = formPassword.equals(confirmFormPassword);

        // Resetting validation attributes
        session.removeAttribute("incorrectpassword");
        session.removeAttribute("passwordmismatch");

        // Validating form inputs

        if (!correctOldPassword) {
            request.getSession().setAttribute("incorrectpassword", "is-invalid");
        }

        if (!updatedPasswordMatchesConfirmedPassword) {
            request.getSession().setAttribute("passwordmismatch", "is-invalid");
            response.sendRedirect("/profile");
            return;
        }


        // After form inputs are validated, do the following:
        currentUser.setPassword(Password.hash(formPassword));
        User updatedUser = currentUser;
        DaoFactory.getUsersDao().updateUser(updatedUser);
        session.removeAttribute("user");
        session.setAttribute("user", updatedUser);
        response.sendRedirect("/profile");
    }
}