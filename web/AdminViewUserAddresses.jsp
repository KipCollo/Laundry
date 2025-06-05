<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="data.Address" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin View User Addresses</title>
    <link rel="icon" href="images/logol.png" type="image/png">
</head>
<%@ include file="header.jsp" %>
<body>
    <table>
        <thead>
            <tr>
                <th>Address ID</th>
                <!-- Add other headers -->
            </tr>
        </thead>
        <tbody>
            <%
                List<Address> addresses = (List<Address>) request.getAttribute("addresses");
                if (addresses != null) {
                    for (Address address : addresses) {
            %>
            <tr>
                <td><%= address.getAddressID() %></td>
                <!-- Add other data cells -->
            </tr>
            <% 
                    }
                } else {
            %>
            <tr>
                <td colspan="5">No addresses found.</td>
            </tr>
            <% 
                }
            %>
        </tbody>
    </table>
        <%@ include file="footers.jsp" %>
</body>
</html>
