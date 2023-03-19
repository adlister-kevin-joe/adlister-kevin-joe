<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-dark bg-dark navbar-expand-lg">
    <div class="container-fluid">

        <a class="navbar-brand" href="/homepage">Adlister.com</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                <c:choose>
                    <c:when test="${sessionScope.user == null}">
                        <li class="nav-item">
                            <a class="nav-link" href="/login">Login</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/register">Register</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown">
                                Profile
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="/myads">My Ads</a></li>
                                <li><a class="dropdown-item" href="/ads/create">Create an Ad</a></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item" href="/profile">My Account</a></li>
                            </ul>
                        </li>
                    </c:otherwise>
                </c:choose>

            </ul>

            <form class="d-flex m-0" method="post" action="/navbarsearch">
                <input name="search-input" class="form-control me-2" type="search" placeholder="Search">
                <button class="btn btn-danger" type="submit">Search</button>
            </form>

        </div>

    </div>
</nav>
