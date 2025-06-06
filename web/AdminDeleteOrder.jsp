<!-- AdminDeleteOrder.jsp -->
<%@ include file="header.jsp" %>
<main>
    <h2>Delete Order</h2>
    <form action="AdminDeleteOrderServlet" method="post">
        <label for="orderID">Order ID:</label>
        <input type="text" id="orderID" name="orderID" required><br>
        <input type="submit" value="Delete Order">
    </form>
</main>
<%@ include file="footers.jsp" %>
