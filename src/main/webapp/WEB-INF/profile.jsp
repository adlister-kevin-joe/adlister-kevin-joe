<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container">
    <h1>Welcome, ${sessionScope.user.username}!</h1>
</div>


<div class="container-fluid">

    <div class="d-flex align-items-start flex-fill w-100 h-100">
        <div class="nav flex-column nav-pills me-3" id="v-pills-tab" role="tablist">
            <button class="nav-link active" id="v-pills-home-tab" data-bs-toggle="pill"
                    data-bs-target="#v-pills-home"
                    type="button" role="tab">Acount
            </button>
            <button class="nav-link" id="v-pills-profile-tab" data-bs-toggle="pill"
                    data-bs-target="#v-pills-profile"
                    type="button" role="tab">Settings
            </button>
            <button class="nav-link" id="v-pills-messages-tab" data-bs-toggle="pill"
                    data-bs-target="#v-pills-messages"
                    type="button" role="tab">IDK
            </button>
            <button class="nav-link" id="v-pills-settings-tab" data-bs-toggle="pill"
                    data-bs-target="#v-pills-settings"
                    type="button" role="tab">IDK
            </button>
        </div>
        <div class="tab-content w-100 h-100" id="v-pills-tabContent">

            <div class="tab-pane fade show active w-100 h-100" id="v-pills-home" role="tabpanel">
                <div class="card w-100 h-75">
                    <h5 class="card-header">Account</h5>
                    <div class="card-body">

                        <form method="post" action="/profile/update">

<%--                            <div class="mb-3">--%>
<%--                                <label for="account-page-username" class="form-label">Username</label>--%>
<%--                                <input name="form-username" value="${username}" type="text" class="form-control">--%>
<%--                            </div>--%>

                            <div class="mb-3">
                                <label for="account-page-username" class="form-label">Username</label>
                                <div class="input-group has-validation">
                                    <input name="form-username" type="text" class="form-control ${userexists}" value="${username}" id="account-page-username" required>
                                    <div class="invalid-feedback">
                                        Username already exists.
                                    </div>
                                </div>
                            </div>

                            <div class="mb-3">
                                <label for="account-page-username" class="form-label">Email</label>
                                <input name="form-email" value="${email}" type="text" class="form-control"
                                       id="account-page-email">
                            </div>

                            <div class="mb-3">
                                <label for="old-password" class="form-label">Old Password</label>
                                <div class="input-group has-validation">
                                    <input name="old-password" type="password" class="form-control ${incorrectpassword}"
                                           id="old-password" required>
                                    <div class="invalid-feedback">
                                        Password is invalid.
                                    </div>
                                </div>
                            </div>

                            <div class="mb-3">
                                <label for="new-password" class="form-label">New Password</label>
                                <div class="input-group has-validation">
                                    <input name="form-password" type="password" class="form-control ${passwordmismatch}"
                                           id="new-password" required>
                                    <div class="invalid-feedback">
                                    </div>
                                </div>
                            </div>

                            <div class="mb-3">
                                <label for="confirm-form-password" class="form-label">Confirm New Password</label>
                                <div class="input-group has-validation">
                                    <input name="confirm-form-password" type="password"
                                           class="form-control ${passwordmismatch}" id="confirm-form-password" required>
                                    <div id="validationServerConfirmPasswordFeedback" class="invalid-feedback">
                                    </div>
                                    <div id="validationServerEmailFeedback" class="invalid-feedback">
                                        Passwords do not match, re-enter.
                                    </div>
                                </div>
                            </div>

                            <br>

                            <button type="submit" class="btn btn-primary">Save</button>

                        </form>

                    </div>
                </div>
            </div>

            <div class="tab-pane fade w-100 h-100 flex-fill" id="v-pills-profile" role="tabpanel">
                <div class="card w-100 h-50">
                    <h5 class="card-header">Settings</h5>
                    <div class="card-body">

                        <h5 class="card-title">Special title treatment</h5>
                        <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                        <a href="#" class="btn btn-primary">Go somewhere</a>

                    </div>
                </div>
            </div>

            <div class="tab-pane fade" id="v-pills-messages" role="tabpanel">
                <div class="card w-100 h-50">
                    <h5 class="card-header">Featured</h5>
                    <div class="card-body">
                        <h5 class="card-title">Special title treatment</h5>
                        <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                        <a href="#" class="btn btn-primary">Go somewhere</a>
                    </div>
                </div>
            </div>

            <div class="tab-pane fade" id="v-pills-settings" role="tabpanel">
                <div class="card w-100 h-50">
                    <h5 class="card-header">Featured</h5>
                    <div class="card-body">
                        <h5 class="card-title">Special title treatment</h5>
                        <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                        <a href="#" class="btn btn-primary">Go somewhere</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>


<jsp:include page="/WEB-INF/partials/bootstrap_js.jsp"/>
</body>
</html>
