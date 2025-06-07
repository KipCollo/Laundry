package com.kipcollo.controller;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Controller
public class AdminDeleteOrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @RequestMapping("/AdminDeleteOrderServlet")
    protected void doPost(@RequestParam("orderID") String orderID,
                          HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // JDBC Database Connection Information
        String url = "jdbc:mysql://localhost:3306/laundry_users";
        String user = "root";
        String dbPassword = "yourDB password";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(url, user, dbPassword)) {
                String query = "DELETE FROM order_details WHERE Order_id = ?";
                try (PreparedStatement pst = con.prepareStatement(query)) {
                    pst.setInt(1, Integer.parseInt(orderID));

                    int rowsAffected = pst.executeUpdate();
                    if (rowsAffected > 0) {
                        response.sendRedirect("AdminDashboard.jsp");
                    } else {
                        response.sendRedirect("AdminDeleteOrder.jsp");
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            out.println("<h2>Error: " + e.getMessage() + "</h2>");
        }
    }
}
