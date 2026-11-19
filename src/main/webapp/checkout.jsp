
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Checkout</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/styles/main.css">
</head>
<body>

    <h1>Checkout</h1>

    <h2>Order Summary</h2>

    <table class="product-table">
        <thead>
            <tr>
                <th>Quantity</th>
                <th>Description</th>
                <th>Price</th>
                <th>Amount</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="item" items="${cart.items}">
                <tr>
                    <td>${item.quantity}</td>
                    <td>${item.product.description}</td>
                    <td>$${item.product.price}</td>
                    <td>$${item.total}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <h3>Cart Total: $${cart.total}</h3>

    <p>
        <a href="${pageContext.request.contextPath}/cart">
            Return to Cart
        </a>
    </p>
    <form action="${pageContext.request.contextPath}/placeOrder" method="post">
        <button type="submit">Place Order</button>
    </form>

</body>
</html>
