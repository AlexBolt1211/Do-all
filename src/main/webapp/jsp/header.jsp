<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
    <a href="<c:url value="/do-all"/>"
       class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none">
        <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap">
            <img src="<c:url value="/svg/logo.svg"/> " width="32" height="32" alt="do-all-logo"/>
        </svg>
    </a>

    <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
        <li><a href="<c:url value="/do-all"/>" class="nav-link px-2 link-secondary">Home</a></li>
        <li><a href="<c:url value="/jsp/advertisement.jsp"/>" class="nav-link px-2 link-dark">New Advertisement</a></li>
    </ul>

    <c:import url="search.jsp"/>

    <div class="col-md-2 text-end">
        <a class="btn btn-outline-primary me-2" href="<c:url value="/jsp/signin.jsp"/>">Login</a>
        <a class="btn btn-primary" href="<c:url value="/jsp/signup.jsp"/>">Sign-up</a>
    </div>
</header>