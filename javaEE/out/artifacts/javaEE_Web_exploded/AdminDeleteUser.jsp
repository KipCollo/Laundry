<!-- AdminDeleteUser.jsp -->
<%@ include file="header.jsp" %>
<head><link rel="icon" href="images/logol.png" type="image/png"></head>
<main>
    <h2>Delete User</h2>
    <form action="AdminDeleteUserServlet" method="post">
        <label for="userID">User ID:</label>
        <input type="text" id="userID" name="userID" required><br>
        <input type="submit" value="Delete User">
    </form>
</main>
<%@ include file="footers.jsp" %>
