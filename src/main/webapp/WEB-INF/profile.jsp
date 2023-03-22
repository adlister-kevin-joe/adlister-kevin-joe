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
<jsp:include page="/WEB-INF/partials/change_username_modal.jsp"/>
<jsp:include page="/WEB-INF/partials/change_email_modal.jsp"/>
<jsp:include page="/WEB-INF/partials/change_password_modal.jsp"/>

<div class="container">
    <h1>Welcome, <c:out value="${sessionScope.user.username}" />!</h1>
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

                        <div class="mb-3 w-50 ms-5">
                            <div class="input-group mb-3">
                                <span class="input-group-text">Username</span>
                                <input type="text" class="form-control" value="${username}" disabled readonly>
                            </div>

                            <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                    data-bs-target="#change-username-modal">
                                Change Username
                            </button>
                        </div>

                        <div class="mb-3 w-50 ms-5">
                            <div class="input-group mb-3">
                                <span class="input-group-text">Email</span>
                                <input type="text" class="form-control" value="${email}" disabled readonly>
                            </div>

                            <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                    data-bs-target="#change-email-modal">
                                Change Email
                            </button>
                        </div>


                        <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                data-bs-target="#change-password-modal">
                            Change Password
                        </button>

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
