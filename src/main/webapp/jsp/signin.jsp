<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Do All</title>
    <c:import url="meta.jsp"/>
    <link href="<c:url value="/css/signin.css"/>" rel="stylesheet" type="text/css">

</head>
<body>

<main class="form-signin">
    <div class="row g-5">

        <form>
            <div class="py-5 text-center">
                <img class="d-block mx-auto mb-4" src="<c:url value="/svg/logo.svg"/>" alt="do-all" width="72"
                     height="57">
                <h2>Sign in</h2>
            </div>

            <div class="col-12">
                <label for="username" class="form-label">Username</label>
                <input type="text" class="form-control" id="username" placeholder="Enter username"
                       required>
                <div class="invalid-feedback">
                    Please enter your Username.
                </div>
            </div>

            <div class="col-12">
                <label for="password" class="form-label">Password</label>
                <input type="text" class="form-control" id="password" placeholder="Enter password" required>
            </div>

            <div class="col-12" style="margin-top: 2em">
                <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
            </div>
            <c:import url="footer.jsp"/>
        </form>
    </div>
</main>

</body>
</html>
