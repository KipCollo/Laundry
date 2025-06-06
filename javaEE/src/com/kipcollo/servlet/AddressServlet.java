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

@WebServlet("/AddressServlet")
public class AddressServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String streetAddress = request.getParameter("streetAddress");
        String apartmentNumber = request.getParameter("apartmentNumber");
        String city = request.getParameter("city");
        String zipCode = request.getParameter("zipCode");
        String additionalNotes = request.getParameter("additionalNotes");

        // JDBC Database Connection Information
        String url = "jdbc:mysql://localhost:3306/laundry_users";
        String user = "root";
        String dbPassword = "yourDB password";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(url, user, dbPassword)) {
                String query = "INSERT INTO user_address (street_address, apartment_number, city, zip_code, additional_notes) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement pst = con.prepareStatement(query)) {
                    pst.setString(1, streetAddress);
                    pst.setString(2, apartmentNumber);
                    pst.setString(3, city);
                    pst.setString(4, zipCode);
                    pst.setString(5, additionalNotes);

                    int rowsAffected = pst.executeUpdate();
                    if (rowsAffected > 0) {
                        response.sendRedirect("MpesaPayment.jsp");
                    } else {
                        response.sendRedirect("address.jsp");
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            out.println("<h2>Error: " + e.getMessage() + "</h2>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("address.jsp");
    }
}
