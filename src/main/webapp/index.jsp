<%@ page contentType="text/html; charset=UTF-8"     
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>CD List</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css">
</head>

<body>
    <main class="container">
        <h1>CD List</h1>
        <table class="product-table">
            <thead>
                <tr>
                    <th>Description</th>
                    <th>Price</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="product" items="${products}">
                    <tr>
                        <td>
                            <c:out value="${product.description}"/>
                        </td>
                        <td class="price">
                            $<c:out value="${product.price}"/>
                        </td>
                        <td>
                            <form action="${pageContext.request.contextPath}/addToCart" method="post">
                                <input type="hidden"   
                                       name="productId"
                                       value="${product.id}">
                                <button type="submit">Add To Cart</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </main>
</body>
</html>