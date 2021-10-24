<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>

<html>
    <head>
        <title>Do All</title>
        <c:import url="meta.jsp"/>
    </head>

    <body>
        <c:import url="header.jsp"/>

        <div class="container">

            <c:forEach var = "user"  items="${users}">
                    <p><c:out value = "${user.id} ${user.username}"/> </p>
            </c:forEach>

        </div>

    <c:import url="footer.jsp"/>
    </body>
</html>
