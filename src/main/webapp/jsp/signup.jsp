<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Do All</title>
    <c:import url="meta.jsp"/>
</head>

<body class="bg-light">

<div class="container">
    <main>
        <div class="py-5 text-center">
            <img class="d-block mx-auto mb-4" src="<c:url value="/svg/logo.svg"/>" alt="do-all" width="72" height="57">
            <h2>Sign up</h2>
        </div>

        <div class="row g-5">

            <div class="col-md-5 col-lg-4 order-md-last">
                <img class="rounded" src="<c:url value="/img/signup-img.jpeg"/>" width="700" alt="do-all">
            </div>

            <div class="col-md-5 col-lg-5">
                <h4 class="mb-3">Account Info</h4>
                <form class="needs-validation" novalidate>
                    <div class="row g-3">
                        <div class="col-sm-6">
                            <label for="firstName" class="form-label">First name</label>
                            <input type="text" class="form-control" id="firstName" placeholder="" value="" required>
                            <div class="invalid-feedback">
                                Valid first name is required.
                            </div>
                        </div>

                        <div class="col-sm-6">
                            <label for="lastName" class="form-label">Last name</label>
                            <input type="text" class="form-control" id="lastName" placeholder="" value="" required>
                            <div class="invalid-feedback">
                                Valid last name is required.
                            </div>
                        </div>

                        <div class="col-12">
                            <label for="username" class="form-label">Username</label>
                            <div class="input-group has-validation">
                                <span class="input-group-text">@</span>
                                <input type="text" class="form-control" id="username" placeholder="Username" required>
                                <div class="invalid-feedback">
                                    Your username is required.
                                </div>
                            </div>
                        </div>

                        <div class="col-12">
                            <label for="email" class="form-label">Email <span
                                    class="text-muted">(Optional)</span></label>
                            <input type="email" class="form-control" id="email" placeholder="you@example.com">
                            <div class="invalid-feedback">
                                Please enter a valid email address.
                            </div>
                        </div>

                        <div class="col-12">
                            <label for="password1" class="form-label">Password</label>
                            <input type="text" class="form-control" id="password1" placeholder="Enter your password"
                                   required>
                            <div class="invalid-feedback">
                                Please enter your password.
                            </div>
                        </div>

                        <div class="col-12">
                            <label for="password2" class="form-label">Confirm Password</label>
                            <input type="text" class="form-control" id="password2" placeholder="Confirm password"
                                   required>
                        </div>
                    </div>

                    <div class="col-12" style="margin-top: 2em">
                        <button class="w-100 btn btn-lg btn-primary" type="submit">Sign up</button>
                    </div>
                </form>
            </div>
        </div>
    </main>

    <c:import url="footer.jsp"/>
</div>

<script src="<c:url value="/js/bootstrap.bundle.min.js"/>"></script>
<script src="<c:url value="/js/validation.js"/>"></script>
</body>

</html>
