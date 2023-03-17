<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-default">
    <div class="container-fluid">

            <a class="navbar-brand" href="/ads">Adlister.com</a>

        <form method="post" action="/navbarsearch" class="container">
            <input name="search-input" class="form-control me-2" type="search" placeholder="Search">
            <button class="btn btn-outline-success" type="submit">Search</button>
        </form>

        <div>
        <c:choose>
            <c:when test="${sessionScope.user == null}">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/login">Login</a></li>
                    <li><a href="/register">Register</a></li>
                </ul>
            </c:when>
            <c:otherwise>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/ads/create">Create Ad</a></li>
                    <li><a href="/myads">My Ads</a></li>
                    <li><a href="/profile">Profile</a></li>
                    <li><a href="/logout">Logout</a></li>
                </ul>
            </c:otherwise>
        </c:choose>
        </div>
    </div>
    </div>
</nav>