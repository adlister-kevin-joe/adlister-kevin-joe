<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <h1>Create a new Ad</h1>
        <form class="column g-3" action="/ads/create" method="post">

            <div class="col-md-4 w-100">
                <label for="validationServerTitle" class="form-label">Title</label>
                <div class="input-group has-validation w-100">
                    <input name="title" type="text" class="input-group w-100 form-control" value="${sessionScope.stickyTitle}" id="validationServerTitle" required>
                    <div id="validationServerTitleFeedback" class="invalid-feedback">
                        Please provide a title.
                    </div>
                </div>
            </div>

            <br>

            <div class="col-md-4 w-100">
                <label for="validationServerDescription" class="form-label">Description</label>
                <div class="input-group has-validation w-100">
                    <textarea name="description" class="form-control w-100" id="validationServerDescription" required>${sessionScope.stickyDescription}</textarea>
                    <div id="validationServerDescriptionFeedback" class="invalid-feedback">
                        Please provide a Description.
                    </div>
                </div>
            </div>

            <br>

            <input type="submit" class="btn btn-block btn-primary">
        </form>
    </div>
    <jsp:include page="/WEB-INF/partials/bootstrap_js.jsp" />
</body>
</html>
