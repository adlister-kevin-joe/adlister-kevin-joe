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
                    <input name="email" type="text" class="form-control ${emailIsInvalid}" value="${sessionScope.stickyEmail}" id="validationServerEmail" required>
                    <div id="validationServerEmailFeedback" class="invalid-feedback">
                        Email address is invalid.
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
