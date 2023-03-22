<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container-fluid">
    <h1 class="ms-5">Here Are all the ads!</h1>

    <div class="container d-flex justify-content-center flex-wrap">
        <c:forEach var="ad" items="${ads}">
            <div class="card m-3" style="width: 22rem;">
                <div class="card-body">
                    <h5 class="card-title"><a class="NoDeco" href="http://localhost:8080/ads/showad?id=${ad.id}&uid=${ad.userId}"><c:out value="${ad.title}"/></a></h5>
                    <p class="card-text"><a class="NoDeco" href="http://localhost:8080/ads/showad?id=${ad.id}&uid=${ad.userId}"><c:out value="${ad.description}"/></a></p>
                    <p class="card-text"><a class="NoDeco" href="http://localhost:8080/ads/showad?id=${ad.id}&uid=${ad.userId}"><c:out value="${ad.category}"/></a></p>
                    <p class="card-subtitle mb-2 text-muted"><a class="NoDecoTags" href="http://localhost:8080/ads/showad?id=${ad.id}&uid=${ad.userId}"><c:out value="${ad.tags}"/></a></p>
                    <a class="card-link" href="http://localhost:8080/ads/showad?id=${ad.id}&uid=${ad.userId}">See Ad</a>
                </div>
            </div>
        </c:forEach>
    </div>

</div>
<jsp:include page="/WEB-INF/partials/bootstrap_js.jsp"/>
</body>
</html>
