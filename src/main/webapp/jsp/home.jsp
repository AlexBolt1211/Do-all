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

    <c:forEach begin="0" end="15" var="i">
        <c:import url="card.jsp">
            <c:param name="pageTitle" value="${i}"/>
        </c:import>
    </c:forEach>

</div>

<c:import url="footer.jsp"/>
</body>
</html>
