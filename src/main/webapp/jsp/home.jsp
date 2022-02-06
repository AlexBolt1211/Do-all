<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>

<html lang="en">
<head>
    <title>Do All</title>
    <c:import url="meta.jsp"/>

</head>

<body>
<div class="container">
    <c:import url="header.jsp"/>


    <c:forEach  items="${advertisementList}" var="advertisement">
        <c:import url="card.jsp">
            <c:param name="pageTitle" value="${advertisement.title}"/>
            <c:param name="pageDescription" value="${advertisement.description}"/>
            <c:param name="pageCreatedAt" value="${advertisement.createdAt}"/>
        </c:import>
    </c:forEach>

</div>

<c:import url="footer.jsp"/>
</body>
</html>
