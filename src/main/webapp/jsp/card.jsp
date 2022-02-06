<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="card  mb-3">
    <div class="card-header">
        ${param.pageCreatedAt}
    </div>
    <div class="card-body">
        <h5 class="card-title">${param.pageTitle}</h5>
        <p class="card-text">${param.pageDescription}</p>
        <a href="#" class="btn btn-primary">Edit</a>
    </div>
</div>