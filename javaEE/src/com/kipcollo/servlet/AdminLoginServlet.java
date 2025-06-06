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
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String dbURL = "jdbc:mysql://localhost:3306/laundry_users";
        String dbUser = "root";
        String dbPassword = "yourDB password";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(dbURL, dbUser, dbPassword)) {
                String sql = "SELECT * FROM admin WHERE username=? AND password=?";
                try (PreparedStatement statement = con.prepareStatement(sql)) {
                    statement.setString(1, username);
                    statement.setString(2, password);
                    try (ResultSet rs = statement.executeQuery()) {
                        if (rs.next()) {
                            HttpSession session = request.getSession(true); // Create new session if not exists
                            session.setAttribute("admin", username);
                            response.sendRedirect("AdminDashboard.jsp");
                        } else {
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
