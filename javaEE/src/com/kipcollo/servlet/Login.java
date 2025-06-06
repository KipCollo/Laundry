package com.kipcollo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String dbURL = "jdbc:mysql://localhost:3306/laundry_users";
        String user = "root";
        String dbPassword = "yourDB password";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(dbURL, user, dbPassword)) {
                String sql = "SELECT * FROM users WHERE Username=? AND Password=?";
                try (PreparedStatement statement = con.prepareStatement(sql)) {
                    statement.setString(1, username);
                    statement.setString(2, password);
                    try (ResultSet rs = statement.executeQuery()) {
                        if (rs.next()) {
                            // Username and password match, create session and redirect
                            HttpSession session = request.getSession(true); // Create new session if not exists
                            session.setAttribute("user", username);
                            String email = rs.getString("Email");
                            //String userType = rs.getString("UserType");
                            String phone = rs.getString("Phone");
                            
                            // Set additional user data in session attributes
                            session.setAttribute("email", email);
                            //session.setAttribute("userType", userType);
                            session.setAttribute("phone", phone);
                            
                            // Create cookie with username
                            Cookie userCookie = new Cookie("userCookie", username);
                            userCookie.setMaxAge(60*60*24*365*2); // Set age to 2 years
                            userCookie.setPath("/"); // Allow the entire application to access it
                            response.addCookie(userCookie);
                            
                            // Create cookie with email
                            Cookie emailCookie = new Cookie("emailCookie", email);
                            emailCookie.setMaxAge(60*60*24*365*2); // Set age to 2 years
                            emailCookie.setPath("/"); // Allow the entire application to access it
                            response.addCookie(emailCookie);

                            response.sendRedirect("Profile.jsp");
                        } else {
                            // Invalid username or password
                            out.println("Invalid username or password. Please try again.");
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            out.println("<h2>Error: " + e.getMessage() + "</h2>");
        }
    }
}
