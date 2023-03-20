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

@WebServlet(name = "controllers.UpdateProfileInfoServlet", urlPatterns = "/profile/update")
public class UpdateProfileInfoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            response.sendRedirect("/login");
        }

        User currentUser = (User) session.getAttribute("user");

        String formUsername = request.getParameter("form-username");
        String formEmail = request.getParameter("form-email");
        String oldPassword = request.getParameter("old-password");
        String formPassword = request.getParameter("form-password");
        String confirmFormPassword = request.getParameter("confirm-form-password");

        boolean updatedUsernameExists = DaoFactory.getUsersDao().findByUsername(formUsername) != null;
        boolean correctOldPassword = Password.check(oldPassword, currentUser.getPassword());
        boolean updatedPasswordMatchesConfirmedPassword = formPassword.equals(confirmFormPassword);
        boolean formUsernameIsTheSame = formUsername == currentUser.getUsername();

        // Resetting validation attributes
        session.removeAttribute("userexists");
        session.removeAttribute("incorrectpassword");
        session.removeAttribute("passwordmismatch");

        // Validating form inputs
        if (updatedUsernameExists || !formUsernameIsTheSame) {
            request.getSession().setAttribute("userexists", "is-invalid");
        }

        if (!correctOldPassword) {
            request.getSession().setAttribute("incorrectpassword", "is-invalid");
        }

        if (!updatedPasswordMatchesConfirmedPassword) {
            request.getSession().setAttribute("passwordmismatch", "is-invalid");
        }

        if (updatedUsernameExists || (!updatedPasswordMatchesConfirmedPassword)) {
            response.sendRedirect("/profile");
            return;
        }


        // After form inputs are validated, do the following:
        User updatedUser = new User(currentUser.getId(), formUsername, formEmail, Password.hash(formPassword));
        DaoFactory.getUsersDao().updateUser(updatedUser);
        session.removeAttribute("user");
        session.setAttribute("user", updatedUser);
        response.sendRedirect("/profile");
    }
}
