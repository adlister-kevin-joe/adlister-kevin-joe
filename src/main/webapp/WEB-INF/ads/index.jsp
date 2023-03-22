<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Here Are all the ads!</h1>

    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6">
            <h2><a class="NoDeco" href="http://localhost:8080/ads/showad?id=${ad.id}&uid=${ad.userId}"><c:out value="${ad.title}" /></a></h2>
            <p><a class="NoDeco" href="http://localhost:8080/ads/showad?id=${ad.id}&uid=${ad.userId}"><c:out value="${ad.description}" /></a></p>
            <p><a class="NoDeco" href="http://localhost:8080/ads/showad?id=${ad.id}&uid=${ad.userId}"><c:out value="${ad.category}" /></a></p>
            <p><a class="NoDeco" href="http://localhost:8080/ads/showad?id=${ad.id}&uid=${ad.userId}"><c:out value="${ad.tags}" /></a></p>
            <a href="http://localhost:8080/ads/showad?id=${ad.id}&uid=${ad.userId}">See Ad</a>
        </div>
        <br><br>
    </c:forEach>

</div>
<jsp:include page="/WEB-INF/partials/bootstrap_js.jsp" />
</body>
</html>
