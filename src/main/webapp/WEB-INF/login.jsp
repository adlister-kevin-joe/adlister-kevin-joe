<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <h1>Please Log In</h1>
        <form class="column g-3" action="/login" method="POST">

            <div class="col-md-4">
                <label for="validationServerUsername" class="form-label">Username</label>
                <div class="input-group has-validation">
                    <input name="username" type="text" class="form-control ${errInvalidUsernamePassword}" value="${sessionScope.stickyUsername}" id="validationServerUsername" required>
                    <div id="validationServerUsernameFeedback" class="invalid-feedback">
                        Username or password is invalid.
                    </div>
                </div>
            </div>

            <br>

            <div class="col-md-4">
                <label for="validationServerPassword" class="form-label">Password</label>
                <div class="input-group has-validation">
                    <input name="password" type="password" class="form-control ${errInvalidUsernamePassword}" id="validationServerPassword" required>
                    <div id="validationServerPasswordFeedback" class="invalid-feedback">
                    </div>
                </div>
            </div>

            <br>

            <input type="submit" class="btn btn-primary btn-block" value="Log In">
        </form>

    </div>
    <jsp:include page="/WEB-INF/partials/bootstrap_js.jsp" />
</body>
</html>
