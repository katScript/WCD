<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"></head>
<style>
    html, body {
        height: 100%;
    }
</style>
<body>

<div class="container w-100 h-100 d-flex align-items-center justify-content-center">
    <section class="border border-primary rounded w-100">
        <div class="w-100 bg-primary p-3">
            <h4 class="text-light">Add new Product</h4>
        </div>
        <div class="container p-3">
            <form method="post" action="product">
                <div class="form-group">
                    <label for="code">Product code</label>
                    <input type="text" class="form-control" id="code" placeholder="Product code" name="code">
                </div>

                <div class="form-group">
                    <label for="name">Product name</label>
                    <input type="text" class="form-control" id="name" placeholder="Product name" name="name">
                </div>

                <div class="form-group">
                    <label for="price">Price</label>
                    <input type="number" class="form-control" id="price" placeholder="Price" name="price">
                </div>

                <div class="form-group">
                    <label for="des">Description</label>
                    <textarea class="form-control" id="des" rows="3" name="des"></textarea>
                </div>
                <br>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
            <hr>
            <form method="get" action="product">
                <div class="form-group">
                    <label for="scode">Search by code</label>
                    <input type="text" class="form-control" id="scode" placeholder="Product code" name="scode">
                </div>
                <br>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
            <hr>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Code</th>
                    <th scope="col">Name</th>
                    <th scope="col">Price</th>
                    <th scope="col">Description</th>
                    <th scope="col">Create Time</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="p" items="${products}" varStatus="loop">
                    <c:set var="i" value="${loop.index}"/>
                    <c:set var="pr" value="${p.value}"/>
                <tr>
                    <th scope="row">${i + 1}</th>
                    <td>${pr.getCode()}</td>
                    <td>${pr.getName()}</td>
                    <td>${pr.getPrice()}</td>
                    <td>${pr.getDescription()}</td>
                    <td>${pr.getDateTime()}</td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </section>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>

</body>
</html>