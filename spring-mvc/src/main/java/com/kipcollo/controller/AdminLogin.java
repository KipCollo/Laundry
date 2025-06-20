package com.kipcollo.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@Controller
public class AdminLogin{

    @RequestMapping("/AdminLogin")
    protected void login(@RequestParam("username") String username,
                         @RequestParam("password") String password,
                         HttpServletResponse response,
                         HttpServletRequest request) throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String dbURL = "jdbc:mysql://localhost:3306/laundry_users";
        String user = "root";
        String dbPassword = "yourDB password";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(dbURL, user, dbPassword)) {
                String sql = "SELECT * FROM admin_login WHERE Username=? AND Password=?";
                try (PreparedStatement statement = con.prepareStatement(sql)) {
                    statement.setString(1, username);
                    statement.setString(2, password);
                    try (ResultSet rs = statement.executeQuery()) {
                        if (rs.next()) {
                            // Username and password match, create session and redirect
                            HttpSession session = request.getSession(true); // Create new session if not exists
                            session.setAttribute("admin", username);
                            String email = rs.getString("Email");

                            // Set additional admin data in session attributes
                            session.setAttribute("email", email);

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

                            response.sendRedirect("AdminDashboard.jsp");
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
