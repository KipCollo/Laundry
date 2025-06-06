package com.kipcollo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AdminAddUserServlet")
public class AdminAddUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        // JDBC Database Connection Information
        String url = "jdbc:mysql://localhost:3306/laundry_users";
        String user = "root";
        String dbPassword = "yourDB password";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(url, user, dbPassword)) {
                String query = "INSERT INTO users (Username, Password, ConfirmPassword, Email, Phone) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement pst = con.prepareStatement(query)) {
                    pst.setString(1, username);
                    pst.setString(2, password);
                    pst.setString(3, confirmPassword);
                    pst.setString(4, email);
                    pst.setString(5, phone);

                    int rowsAffected = pst.executeUpdate();
                    if (rowsAffected > 0) {
                        response.sendRedirect("AdminDashboard.jsp");
                    } else {
                        response.sendRedirect("AdminAddUser.jsp");
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            out.println("<h2>Error: " + e.getMessage() + "</h2>");
        }
    }
}
