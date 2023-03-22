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
import java.util.Objects;

@WebServlet(name = "controllers.UpdateUsernameInfoServlet", urlPatterns = "/profile/update/username")
public class UpdateUsernameServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            response.sendRedirect("/login");
        }

        User currentUser = (User) session.getAttribute("user");

        String formUsername = request.getParameter("form-username");

        boolean updatedUsernameExists = DaoFactory.getUsersDao().findByUsername(formUsername) != null;
        boolean formUsernameIsTheSame = Objects.equals(formUsername, currentUser.getUsername());

        // Resetting validation attributes
        session.removeAttribute("userexists");

        System.out.println("updatedUsernameExists: " + updatedUsernameExists);
        System.out.println("formUsernameIsTheSame: " + formUsernameIsTheSame);


        // Validating form inputs
        if (updatedUsernameExists || formUsernameIsTheSame) {
            request.getSession().setAttribute("userexists", "is-invalid");
            response.sendRedirect("/profile");
            return;
        }


        // After form inputs are validated, do the following:
        System.out.println("Updating user!");
        currentUser.setUsername(formUsername);
        User updatedUser = currentUser;
        DaoFactory.getUsersDao().updateUser(updatedUser);
        session.removeAttribute("user");
        session.setAttribute("user", updatedUser);
        response.sendRedirect("/profile");
    }
}