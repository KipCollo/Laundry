package com.kipcollo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Controller
public class Order extends HttpServlet {

    @RequestMapping("/orders")
    protected void order(@RequestParam("serviceType")String serviceType,
                         @RequestParam("itemsCount")int itemsCount,
                         @RequestParam("pickupTime") String pickupTime,
                         @RequestParam("dropoffTime") String dropoffTime,

                         @SessionAttribute("user") String username,
                         HttpServletResponse response) throws IOException {

        if (username != null) {

            String dbURL = "jdbc:mysql://localhost:3306/laundry_users";
            String user = "root";
            String dbPassword = "yourDB password";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                try (Connection con = DriverManager.getConnection(dbURL, user, dbPassword)) {
                    String sql = "INSERT INTO orders (user_id, service_type, items_count, pickup_time, dropoff_time, status) VALUES ((SELECT user_id FROM users WHERE Username=?), ?, ?, ?, ?, 'received')";
                    try (PreparedStatement statement = con.prepareStatement(sql)) {
                        statement.setString(1, username);
                        statement.setString(2, serviceType);
                        statement.setInt(3, itemsCount);
                        statement.setString(4, pickupTime);
                        statement.setString(5, dropoffTime);
                        statement.executeUpdate();
                        response.sendRedirect("OrderSuccess.jsp");
                    }
                }
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                response.sendRedirect("OrderError.jsp");
            }
        } else {
            response.sendRedirect("Login.jsp");
        }
    }


    @RequestMapping("/DeleteOrder")
    protected void doPost(@RequestParam("orderID") String orderID,
                          HttpServletResponse response) throws IOException, ServletException {

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

    @RequestMapping("/order-details")
    protected void orderDetails(@RequestParam("pickUp") String pickUp,
                                @RequestParam("time") String time,
                                HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // JDBC Database Connection Information
        String url = "jdbc:mysql://localhost:3306/laundry_users ";
        String user = "root";
        String dbPassword = "yourDB password";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(url, user, dbPassword)) {
                String query = "INSERT INTO order_details(pickUp, time) VALUES (?, ?)";
                try (PreparedStatement pst = con.prepareStatement(query)) {
                    pst.setString(1, pickUp);
                    pst.setString(2, time);

                    int rowsaffected = pst.executeUpdate();
                    if(rowsaffected > 0){
                        response.sendRedirect("address.jsp");
                    }else{
                        response.sendRedirect("order_details.jsp");
                    }




                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            out.println("<h2>Error: " + e.getMessage() + "</h2>");
        }
    }
}
