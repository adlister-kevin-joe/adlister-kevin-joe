package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.codeup.adlister.util.Validate.isValid;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("errDisplay") == "") {
            request.getSession().setAttribute("errDisplay", "");
        } else {
            request.getSession().setAttribute("errDisplay", "none");
        }
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");

        request.getSession().setAttribute("stickyUsername", username);
        request.getSession().setAttribute("stickyEmail", email);

        // validate input
//        boolean inputHasErrors = username.isEmpty()
//            || email.isEmpty()
//            || password.isEmpty()
//            || (! password.equals(passwordConfirmation));

//        if (inputHasErrors) {
//            response.sendRedirect("/register");
//            return;
//        }

        User userNameCheck = DaoFactory.getUsersDao().findByUsername(username);

        request.getSession().setAttribute("userExists", "");
        request.getSession().setAttribute("emailIsInvalid", "");
        request.getSession().setAttribute("passwordMismatch", "");

        if (userNameCheck != null) {
            request.getSession().setAttribute("userExists", "is-invalid");
        }

        if (!isValid(email)) {
            request.getSession().setAttribute("emailIsInvalid", "is-invalid");
        }

        if (! password.equals(passwordConfirmation)) {
            request.getSession().setAttribute("passwordMismatch", "is-invalid");
        }

        if ((userNameCheck != null) || (! password.equals(passwordConfirmation)) || (!isValid(email))) {
            response.sendRedirect("/register");
            return;
        }

        password = Password.hash(password);

        try {
            // create and save a new user
            User user = new User(username, email, password);
            DaoFactory.getUsersDao().insert(user);
            request.getSession().setAttribute("userExists", "");
            response.sendRedirect("/login");
        } catch (Exception e) {
        }

    }
}
