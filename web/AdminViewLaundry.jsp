<%@ page import="java.util.List" %>
<%@ page import="data.Order" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin View Laundry</title>
    <link rel="icon" href="images/logol.png" type="image/png">
</head>
<%@ include file="header.jsp" %>
<body>
    <h2>Order Details</h2>
    <table border="1">
        <thead>
            <tr>
                <th>Order ID</th>
                <th>User ID</th>
                <th>Pick Up</th>
                <th>Time</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Order> orders = (List<Order>) request.getAttribute("orders");
                if (orders != null) {
                    for (Order order : orders) {
            %>
            <tr>
                <td><%= order.getOrderID() %></td>
                <td><%= order.getUserID() %></td>
                <td><%= order.getPickUp() %></td>
                <td><%= order.getTime() %></td>
            </tr>
            <% 
                    }
                } else {
            %>
            <tr>
                <td colspan="4">No orders found.</td>
            </tr>
            <% 
                }
            %>
        </tbody>
    </table>
        <%@ include file="footers.jsp" %>
</body>
</html>
