<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Homepage"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<div class="container">
    <h1>Welcome to the Adlister!</h1>

    <div class="container-fluid mx-auto">
        <div class="row">
            <c:forEach var="category" items="${categories}">
                <a href="/category?category=${category.category}" class="col-5 category text-center">
                    <div>
                        <c:out value="${category.category}" />
                    </div>
                </a>
            </c:forEach>
        </div>
    </div>

</div>
</div>
<jsp:include page="/WEB-INF/partials/bootstrap_js.jsp"/>
</body>
</html>