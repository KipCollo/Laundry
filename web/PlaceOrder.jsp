<%-- 
    Document   : PlaceOrder
    Created on : May 31, 2024, 9:56:11 AM
    Author     : Krafty Coder
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Place Order</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            width: 400px;
        }
        h1 {
            text-align: center;
            margin-bottom: 20px;
        }
        form {
            display: flex;
            flex-direction: column;
        }
        input, select, textarea {
            margin-bottom: 10px;
            padding: 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }
        .btn-submit {
            background-color: #07a737;
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Place Order</h1>
        <form action="PlaceOrderServlet" method="post">
            <label for="service">Service:</label>
            <select id="service" name="service">
                <option value="wash">Wash</option>
                <option value="dry_clean">Dry Clean</option>
                <option value="iron">Iron</option>
            </select>
            
            <label for="quantity">Quantity:</label>
            <input type="number" id="quantity" name="quantity" min="1" required>
            
            <label for="address">Pickup Address:</label>
            <textarea id="address" name="address" rows="4" required></textarea>
            
            <button type="submit" class="btn-submit">Place Order</button>
        </form>
    </div>
</body>
</html>

