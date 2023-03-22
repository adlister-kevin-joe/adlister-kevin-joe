<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing My Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>My Ads</h1>
    <form action="/myads" method="post">

    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6">
            <h2><c:out value="${ad.title}" /></h2>
            <p><c:out value="${ad.description}" /></p>
            <p><c:out value="${ad.category}" /></p>
            <p><c:out value="${ad.tags}" /></p>
            <button type="submit" name="button" class="btn btn-outline-secondary" value="edit${ad.id}" >Edit</button>
            <button type="submit" name="button" class="btn btn-outline-secondary" value="delete${ad.id}">Delete</button>
        </div>
    </c:forEach>
    </form>
</div>
<jsp:include page="/WEB-INF/partials/bootstrap_js.jsp" />
</body>
</html>