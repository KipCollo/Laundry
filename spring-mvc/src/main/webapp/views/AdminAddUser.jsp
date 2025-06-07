<!-- AdminAddUser.jsp -->
<%@ include file="header.jsp" %>
<head><link rel="icon" href="images/logol.png" type="image/png"></head>
<main>
    <h2>Add New User</h2>
    <form action="AdminAddUserServlet" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>
        <label for="confirmPassword">Confirm Password:</label>
        <input type="password" id="confirmPassword" name="confirmPassword" required><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>
        <label for="phone">Phone:</label>
        <input type="text" id="phone" name="phone" required><br>
        <input type="submit" value="Add User">
    </form>
</main>

