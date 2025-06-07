package com.kipcollo.controller;


import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Controller
public class customerInfoServlet{
//    protected void doPost(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException{
        // JDBC URL, username, and password
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/laundry_users";
    private static final String USERNAME = "root";
    String PASSWORD = "yourDB password";

    // JDBC driver class name
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    static {
        try {
            // Load JDBC driver
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Failed to load JDBC driver: " + JDBC_DRIVER);
        }
    }

    @RequestMapping("/customerInfoServlet")
    protected void doPost(@RequestParam("firstName")String firstName,
                          @RequestParam("lastName")String lastName,
                          @RequestParam("phoneNumber") String phoneNumber,
                          HttpServletResponse response) throws IOException {
        // Insert data into the database
        if (registerUser(firstName, lastName, phoneNumber)) {
            // Registration successful, redirect to success.jsp
            response.sendRedirect("order_details.jsp");
        } else {
            // Registration failed, redirect to failure.jsp
            response.sendRedirect("contact_details.jsp");
        }
    }

    private boolean registerUser(String firstName, String lastName, String phoneNumber) {
        // SQL statement to insert user data
        String sql = "INSERT INTO contact_details (firstName, lastName, phoneNumber) VALUES (?, ?, ? )";

        try (
            // Get database connection
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            // Create prepared statement with SQL
            PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            // Set parameters in the prepared statement
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, phoneNumber);
            //preparedStatement.setString(5, message);

            // Execute the SQL statement and check if rows were affected
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
// Handle database errors
                        return false;
        }
    }
}
    
