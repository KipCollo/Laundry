<%@ page import="java.util.List" %>
<%@ page import="data.Contact" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin View Contact Details</title>
    <link rel="icon" href="images/logol.png" type="image/png">
</head>
<%@ include file="header.jsp" %>
<body>
    <h2>Contact Details</h2>
    <table border="1">
        <thead>
            <tr>
                <th>Contact ID</th>
                <th>User ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Phone Number</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Contact> contacts = (List<Contact>) request.getAttribute("contacts");
                if (contacts != null) {
                    for (Contact contact : contacts) {
            %>
            <tr>
                <td><%= contact.getContactID() %></td>
                <td><%= contact.getUserID() %></td>
                <td><%= contact.getFirstName() %></td>
                <td><%= contact.getLastName() %></td>
                <td><%= contact.getPhoneNumber() %></td>
            </tr>
            <% 
                    }
                } else {
            %>
            <tr>
                <td colspan="5">No contacts found.</td>
            </tr>
            <% 
                }
            %>
        </tbody>
    </table>
        <%@ include file="footers.jsp" %>
</body>
</html>
