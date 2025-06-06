<!--<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registration</title>
    <link rel="stylesheet" href="style1.css">
    <link rel="icon" href="images/logo.png" type="image/png">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
    <title>User Profile</title>
     
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
        p {
            margin: 10px 0;
        }
        strong {
            font-weight: bold;
        }
        .btn-logout {
            background-color: #ff4c4c;
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
            margin-top: 20px;
            display: block;
            width: 90%;
            text-align: center;
            text-decoration: none;
        }
        .homepage-link {
            display: block;
            text-align: center;
            margin-top: 20px;
            text-decoration: none;
            color: #07a737;
        }
    </style>
</head>

<body>
    
    
    <div class="container">
        <h1>User Profile</h1>
        <p><strong>Username:</strong> <%= session.getAttribute("user") %></p>
        <p><strong>Email:</strong> <%= session.getAttribute("email") %></p>
        <p><strong>Phone:</strong> <%= session.getAttribute("phone") %></p>
        <a href="Logout" class="btn-logout">Logout</a>
        <a href="index.jsp" class="homepage-link">Go to Homepage</a>
        <a href="viewCookies.jsp" class="homepage-link">View Cookies</a>
        <p>Click here to delete all persistent cookies</p>
        <a href="delete_cookies.jsp" class="homepage-link">DELETE ALL COOKIES!</a>
    </div>
       
               
</body>
 
</html>

-->



<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User Profile</title>
    <link rel="stylesheet" href="style1.css">
    <link rel="icon" href="images/logol.png" type="image/png">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }
        
        .container {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 30px;
            width: 300px;
            
            margin: 100px auto 40px;
            margin-top: 100px;
            text-align: center;
            flex: 1;
        }
        h1 {
            margin-bottom: 20px;
        }
        p {
            margin: 10px 0;
        }
        strong {
            font-weight: bold;
        }
        .btn-logout, .homepage-link {
            background-color: #ff4c4c;
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
            margin-top: 20px;
            text-decoration: none;
            display: block;
            width: 90%;
            text-align: center;
        }
        .homepage-link {
            background-color: #07a737;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <div class="head">
    <%@ include file = "header.html" %>
    </div>
    <div class="container">
        <h1>User Profile</h1>
        <p><strong>Username:</strong> <%= session.getAttribute("user") %></p>
        <p><strong>Email:</strong> <%= session.getAttribute("email") %></p>
        <p><strong>Phone:</strong> <%= session.getAttribute("phone") %></p>
        <a href="Logout" class="btn-logout">Logout</a>
        <a href="index.jsp" class="homepage-link">Go to Homepage</a>
        <a href="viewCookies.jsp" class="homepage-link">View Cookies</a>
        <p>Click here to delete all persistent cookies</p>
        <a href="delete_cookies.jsp" class="homepage-link">DELETE ALL COOKIES!</a>
    </div>

</body>
</html>
