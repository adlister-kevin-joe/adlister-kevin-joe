<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="/WEB-INF/partials/head.jsp">
    <jsp:param name="title" value="Search Ads" />
  </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
  <h1>Search Results</h1>

  <c:forEach var="ad" items="${ads}">

    <div class="card m-5" style="width: 22rem;">
      <div class="card-body">
        <h2><a class="NoDeco" href="http://localhost:8080/ads/showad?id=${ad.id}&uid=${ad.userId}"><c:out value="${ad.title}" /></a></h2>
        <p><a class="NoDeco" href="http://localhost:8080/ads/showad?id=${ad.id}&uid=${ad.userId}"><c:out value="${ad.description}" /></a></p>
        <p><a class="NoDeco" href="http://localhost:8080/ads/showad?id=${ad.id}&uid=${ad.userId}"><c:out value="${ad.category}" /></a></p>
        <p><a class="NoDeco" href="http://localhost:8080/ads/showad?id=${ad.id}&uid=${ad.userId}"><c:out value="${ad.tags}" /></a></p>
      </div>
    </div>
  </c:forEach>
</div>
<jsp:include page="/WEB-INF/partials/bootstrap_js.jsp" />
</body>
</html>