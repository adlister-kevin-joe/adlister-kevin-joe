<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Register For Our Site!" />
    </jsp:include>
</head>
<body>
    <jsp:include page="partials/navbar.jsp" />
    <div class="container">
        <h1>Please fill in your information.</h1>
<%--        <form action="/register" method="post">--%>
<%--            <div class="form-group">--%>
<%--                <h3 style="display: ${errDisplay}; color: red;">User name ${sessionScope.userExists.username} already exists.</h3>--%>
<%--                <label for="username">Username</label>--%>
<%--                <input id="username" name="username" class="form-control" type="text" value="${sessionScope.stickyUsername}">--%>
<%--            </div>--%>
<%--            <div class="form-group">--%>
<%--                <label for="email">Email</label>--%>
<%--                <input id="email" name="email" class="form-control" type="text" value="${sessionScope.stickyEmail}">--%>
<%--            </div>--%>
<%--            <div class="form-group">--%>
<%--                <label for="password">Password</label>--%>
<%--                <input id="password" name="password" class="form-control" type="password">--%>
<%--            </div>--%>
<%--            <div class="form-group">--%>
<%--                <label for="confirm_password">Confirm Password</label>--%>
<%--                <input id="confirm_password" name="confirm_password" class="form-control" type="password">--%>
<%--            </div>--%>
<%--            <input type="submit" class="btn btn-primary btn-block">--%>
<%--        </form>--%>

        <form action="/register" method="post">

            <div class="col-md-4">
                <label for="validationServerUsername" class="form-label">Username</label>
                <div class="input-group has-validation">
                    <input name="username" type="text" class="form-control ${userExists}" value="${sessionScope.stickyUsername}" id="validationServerUsername" required>
                    <div id="validationServerUsernameFeedback" class="invalid-feedback">
                        Username already exists.
                    </div>
                </div>
            </div>

            <br>

            <div class="col-md-4">
                <label for="validationServerEmail" class="form-label">Email</label>
                <div class="input-group has-validation">
                    <input name="email" type="text" class="form-control ${errInvalidUsernamePassword}" value="${sessionScope.stickyEmail}" id="validationServerEmail" required>
                    <div id="validationServerEmailFeedback" class="invalid-feedback">
                        Username or password is invalid.
                    </div>
                </div>
            </div>

            <br>

            <div class="col-md-4">
                <label for="validationServerPassword" class="form-label">Password</label>
                <div class="input-group has-validation">
                    <input name="password" type="password" class="form-control ${passwordMismatch}" id="validationServerPassword" required>
                    <div id="validationServerPasswordFeedback" class="invalid-feedback">
                    </div>
                </div>
            </div>

            <br>

            <div class="col-md-4">
                <label for="validationServerConfirmPassword" class="form-label">Confirm Password</label>
                <div class="input-group has-validation">
                    <input name="confirm_password" type="password" class="form-control ${passwordMismatch}" id="validationServerConfirmPassword" required>
                    <div id="validationServerConfirmPasswordFeedback" class="invalid-feedback">
                    </div>
                    <div id="validationServerEmailFeedback" class="invalid-feedback">
                        Passwords do not match, re-enter.
                    </div>
                </div>
            </div>

            <br>

            <input type="submit" class="btn btn-primary btn-block">

        </form>



    </div>
    <jsp:include page="/WEB-INF/partials/bootstrap_js.jsp" />
</body>
</html>
