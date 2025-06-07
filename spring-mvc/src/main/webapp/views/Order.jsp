
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
            padding: 30px;
            width: 400px;
            text-align: center;
        }
        h2 {
            margin-bottom: 20px;
            color: #333;
        }
        form {
            display: flex;
            flex-direction: column;
            align-items: flex-start;
        }
        label {
            margin-top: 10px;
            margin-bottom: 5px;
            color: #555;
        }
        input[type="number"],
        input[type="datetime-local"],
        select {
            width: calc(100% - 20px);
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            background-color: #fafafa;
        }
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #28a745;
            border: none;
            border-radius: 5px;
            color: #fff;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s;
        }
        input[type="submit"]:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Place Order</h2>
        <form action="PlaceOrder" method="post">
            <label for="serviceType">Service Type:</label>
            <select name="serviceType" id="serviceType">
                <option value="wash">Wash</option>
                <option value="dry_clean">Dry Clean</option>
                <option value="iron">Iron</option>
            </select>
            <label for="itemsCount">Number of Items:</label>
            <input type="number" name="itemsCount" id="itemsCount" required>
            <label for="pickupTime">Pickup Time:</label>
            <input type="datetime-local" name="pickupTime" id="pickupTime" required>
            <label for="dropoffTime">Dropoff Time:</label>
            <input type="datetime-local" name="dropoffTime" id="dropoffTime" required>
            <input type="submit" value="Place Order">
        </form>
    </div>
</body>
</html>
