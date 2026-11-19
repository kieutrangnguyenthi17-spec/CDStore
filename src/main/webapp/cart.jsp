<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Shopping Cart</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css">
</head>
<body>
    <h1>Your shopping cart</h1>
    <c:choose>
        <c:when test="${empty cart.items}">
            <p>Your cart is empty.</p>
        </c:when>
        <c:otherwise>
        <table class="product-table">
            <thead>
                <tr>
                    <th>Quantity</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Amount</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${cart.items}">
                    <tr>
                        <td>
                            <form action="${pageContext.request.contextPath}/updateCart" method="post">
                                <input type="hidden"
                                    name="productId"
                                    value="${item.product.id}">

                                <input type="number"
                                    name="quantity"
                                    value="${item.quantity}"
                                    min="1">
                                <button type="submit">Update</button>
                            </form>
                        </td>
                
                        <td>${item.product.description}</td>
                        <td>$${item.product.price}</td>
                        <td>$${item.total}</td>
                        <td>
                            <form action="${pageContext.request.contextPath}/removeFromCart"
                                method="post">
                                <input type="hidden"
                                    name="productId"
                                    value="${item.product.id}">

                                <button type="submit">Remove Item</button>
                            </form>
                        </td>        
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <h3>Cart Total: $${cart.total}</h3>
        <p>
            To change the quantity, enter the new quantity and click on the Update button.
        </p>
        </c:otherwise>
    </c:choose>
    <p>
        <a href="${pageContext.request.contextPath}/index">
            Continue Shopping
        </a>
    </p>
    <form action="${pageContext.request.contextPath}/checkout" method="post">
        <button type="submit">Checkout</button>
    </form>
</body>
</html>