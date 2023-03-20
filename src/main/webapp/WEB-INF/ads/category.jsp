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
    <div class="col-md-6">
      <h2><a href="http://localhost:8080/ads/showad?id=${ad.id}&uid=${ad.userId}">${ad.title}</a></h2>
      <p><a href="http://localhost:8080/ads/showad?id=${ad.id}&uid=${ad.userId}">${ad.description}</a></p>
      <a href="http://localhost:8080/ads/showad?id=${ad.id}&uid=${ad.userId}">See Ad</a>
    </div>
  </c:forEach>
</div>
<jsp:include page="/WEB-INF/partials/bootstrap_js.jsp" />

</body>
</html>
