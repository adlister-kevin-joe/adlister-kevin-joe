<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <jsp:include page="/WEB-INF/partials/head.jsp">
    <jsp:param name="title" value="Category" />
  </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<h1>Here Are The Ads for: "<c:out value="${category}" />"</h1>

<div class="container d-flex flex-wrap">

  <c:forEach var="ad" items="${ads}">
    <div class="card m-5" style="width: 22rem;">
      <div class="card-body">
        <h2><a class="NoDeco" href="http://localhost:8080/ads/showad?id=<c:out value="${ad.id}" />&uid=<c:out value="${ad.userId}" />"><c:out value="${ad.title}" /></a></h2>
        <p><a class="NoDeco" href="http://localhost:8080/ads/showad?id=<c:out value="${ad.id}" />&uid=<c:out value="${ad.userId}" />"><c:out value="${ad.description}" /></a></p>
        <p><a class="NoDeco" href="http://localhost:8080/ads/showad?id=<c:out value="${ad.id}" />&uid=<c:out value="${ad.userId}" />"><c:out value="${ad.category}" /></a></p>
        <p><a class="NoDeco" href="http://localhost:8080/ads/showad?id=<c:out value="${ad.id}" />&uid=<c:out value="${ad.userId}" />"><c:out value="${ad.tags}" /></a></p>
        <a href="http://localhost:8080/ads/showad?id=<c:out value="${ad.id}" />&uid=<c:out value="${ad.userId}" />">See Ad</a>
      </div>
    </div>
  </c:forEach>
</div>
<jsp:include page="/WEB-INF/partials/bootstrap_js.jsp" />
</body>
</html>
