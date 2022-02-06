<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Do All</title>
    <c:import url="meta.jsp"/>
</head>

<style>
    .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
    }

    @media (min-width: 768px) {
        .bd-placeholder-img-lg {
            font-size: 3.5rem;
        }
    }
</style>

</head>

<body class="bg-light">

<div class="container">
    <main>
        <div class="py-5 text-center">
            <img class="d-block mx-auto mb-4" src="<c:url value="/svg/logo.svg"/>" alt="" width="72" height="57">
            <h2>Create New Advertisement</h2>
        </div>

        <div class="row g-5">

            <div class="col-md-7 col-lg-8">
                <h4 class="mb-3">Advertisement details</h4>
                <form class="needs-validation" novalidate>
                    <div class="row g-3">

                        <div class="col-12">
                            <label for="title" class="form-label">Title</label>
                            <input type="text" class="form-control" id="title" placeholder="title">
                            <div class="invalid-feedback">
                                Please enter title.
                            </div>
                        </div>

                        <div class="col-12">
                            <label for="description" class="form-label">Description</label>
                            <textarea rows="4" class="form-control" id="description" placeholder="1234 Main St"
                                      required></textarea>
                            <div class="invalid-feedback">
                                Please enter your shipping address.
                            </div>
                        </div>

                        <hr class="my-4">
                    </div>

                    <button class="w-100 btn btn-primary btn-lg" type="submit">Create New Advertisement</button>
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
