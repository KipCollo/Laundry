<%-- 
    Document   : ManageUsers
    Created on : May 31, 2024, 11:03:23 AM
    Author     : Krafty Coder
--%>

<%@ page import="java.util.List" %>
<%@ page import="models.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="jakarta.servlet.http.HttpServletRequest" %>
<%@ page import="jakarta.servlet.http.HttpServletResponse" %>
<%@ page import="jakarta.servlet.ServletException" %>
<%@ page import="java.io.IOException" %>

<!DOCTYPE html>
<html>
<head>
    <title>Manage Users</title>
    <style>
        /* Add your CSS styles */
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
    </style>
</head>
<body>
    <h1>Manage Users</h1>
    <form action="UserServlet" method="post">
        <input type="hidden" name="action" value="add">
        <input type="text" name="username" placeholder="Username" required>
        <input type="email" name="email" placeholder="Email" required>
        <input type="password" name="password" placeholder="Password" required>
        <input type="text" name="userType" placeholder="User Type" required>
        <input type="text" name="phone" placeholder="Phone">
        <button type="submit">Add User</button>
    </form>

    <h2>User List</h2>
    <%
        List<User> userList = (List<User>) request.getAttribute("userList");
        if (userList == null) {
            userList = new ArrayList<>();
        }
    %>
    <table>
        <tr>
            <th>ID</th>
            <th>Username</th>
            <th>Email</th>
            <th>User Type</th>
            <th>Phone</th>
            <th>Actions</th>
        </tr>
        <%
            for (User user : userList) {
        %>
        <tr>
            <td><%= user.getId() %></td>
            <td><%= user.getUsername() %></td>
            <td><%= user.getEmail() %></td>
            <td><%= user.getUserType() %></td>
            <td><%= user.getPhone() %></td>
            <td>
                <form action="UserServlet" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="edit">
                    <input type="hidden" name="id" value="<%= user.getId() %>">
                    <button type="submit">Edit</button>
                </form>
                <form action="UserServlet" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" value="<%= user.getId() %>">
                    <button type="submit">Delete</button>
                </form>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
