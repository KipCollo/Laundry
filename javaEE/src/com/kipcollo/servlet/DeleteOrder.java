package com.kipcollo.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/DeleteOrder")
public class DeleteOrder extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderID = request.getParameter("orderID");

        String dbURL = "jdbc:mysql://localhost:3306/ARC_laundry";
        String dbUser = "root";
        String dbPassword = "yourDB password";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(dbURL, dbUser, dbPassword)) {
                String sql = "DELETE FROM laundry_bookings WHERE OrderID=?";
                try (PreparedStatement stmt = con.prepareStatement(sql)) {
                    stmt.setInt(1, Integer.parseInt(orderID));
                    stmt.executeUpdate();
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new ServletException("Database connection error", e);
        }

        response.sendRedirect("AdminDashboard");
    }
}
