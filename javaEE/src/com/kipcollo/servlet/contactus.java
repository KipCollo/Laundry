package com.kipcollo.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//import org.apache.derby.client.am.ResultSet;


@WebServlet("/contactus")
public class contactus extends HttpServlet {
//    protected void doPost(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException{
        // JDBC URL, username, and password
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/laundry_users";
    private static final String USERNAME = "root";
    String PASSWORD = "yourDB password";

    // JDBC driver class name
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    static {
        try {
            // Load JDBC driver
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Failed to load JDBC driver: " + JDBC_DRIVER);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form parameters
        String firstName = request.getParameter("firstName");
        String lastName= request.getParameter("lastName");
//        String emailAddress= request.getParameter("emailAddress");
        String phone = request.getParameter("phoneNumber");
        //String email= request.getParameter("email");
        //String message= request.getParameter("message");

        // Insert data into the database
        if (contactus(firstName, lastName, phone)) {
            // Registration successful, redirect to success.jsp
            response.sendRedirect("messagesuccess.jsp");
        } else {
            // Registration failed, redirect to failure.jsp
            response.sendRedirect("contact.jsp");
        }
    }

    private boolean contactus(String firstName, String lastName, String phone) {
        // SQL statement to insert user data
        String sql = "INSERT INTO contact_details (firstName, lastName,  phoneNumber) VALUES (?, ?, ? )";

        try (
            // Get database connection
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            // Create prepared statement with SQL
            PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            // Set parameters in the prepared statement
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
//            preparedStatement.setString(3, emailAddress);
            preparedStatement.setString(3, phone);
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
    
