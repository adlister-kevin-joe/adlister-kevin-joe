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

    <div class="container">
        <div id="categories" class="row">

            <c:forEach var="categories" items="${categories}">
                <div class="col-md-6">
                    <h2><a href="http://localhost:8080/ads/showad?id=${ad.id}&uid=${ad.userId}">${ad.title}</a></h2>
                    <p><a href="http://localhost:8080/ads/showad?id=${ad.id}&uid=${ad.userId}">${ad.description}</a></p>
                    <a href="http://localhost:8080/ads/showad?id=${ad.id}&uid=${ad.userId}">See Ad</a>
                </div>
            </c:forEach>

            <a href="/category"><div class="category col-6">Appliances</div></a>
            <a href="/category?category=Clothing"><div class="category col-6">Clothing</div></a>
            <a href="/category?category=Collectibles"><div class="category col-6">Collectibles</div></a>
            <a href="/category?category=Electronics"><div class="category col-6">Electronics</div></a>
            <a href="/category?category=Furniture"><div class="category col-6">Furniture</div></a>
            <a href="/category?category=Home & Garden"><div class="category col-6">Home & Garden</div></a>
            <a href="/category?category=Jewelry & Wathces"><div class="category col-6">Jewelry & Wathces</div></a>
            <a href="/category?category=Sporting Goods"><div class="category col-6">Sporting Goods</div></a>
            <a href="/category?category=Toys"><div class="category col-6">Toys</div></a>

        </div>
    </div>


</div>
</div>
<jsp:include page="/WEB-INF/partials/bootstrap_js.jsp"/>
</body>
</html>