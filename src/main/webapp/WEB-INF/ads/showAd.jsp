<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Here is your ad ... </h1>
        <div class="col-md-6">
            <h2><c:out value="${sessionScope.viewAd.title}" /></h2>
            <p><u>Description</u></p>
            <p><c:out value="${sessionScope.viewAd.description}" /></p>
            <p><c:out value="${sessionScope.viewAd.category}" /></p>
            <p><c:out value="${sessionScope.viewAd.tags}" /></p>
            <p>Seller: <c:out value="${sessionScope.userAd.username}" /></p>
            <p>Email: <c:out value="${sessionScope.userAd.email}" /></p>
        </div>
</div>
<jsp:include page="/WEB-INF/partials/bootstrap_js.jsp" />
</body>
</html>

