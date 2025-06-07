package com.kipcollo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
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
public class Address extends HttpServlet {
//    private static final long serialVersionUID = 1L;

    @RequestMapping("/address")
    protected void addAddress(@RequestParam("blockName") String blockName,
                                @RequestParam("hostelName") String hostelName,
                                @RequestParam("roomNumber") String roomNumber,
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
                String query = "INSERT INTO address_details(blockName, hostelName, roomNumber) VALUES (?, ?, ?)";
                try (PreparedStatement pst = con.prepareStatement(query)) {
                    pst.setString(1, blockName);
                    pst.setString(2, hostelName);
                    pst.setString(3, roomNumber);
                    
                    int rowsaffected = pst.executeUpdate();
                 if(rowsaffected > 0){
                     response.sendRedirect("success.jsp");
                 }else{
                     response.sendRedirect("student_address.jsp");
                 }   

                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            out.println("<h2>Error: " + e.getMessage() + "</h2>");
        }
    }


    @RequestMapping("/address-info")
    protected void doPost(@RequestParam("streetAddress") String streetAddress,
                          @RequestParam("apartmentNumber") String apartmentNumber,
                          @RequestParam("city") String city,
                          @RequestParam("zipCode") String zipCode,
                          @RequestParam("additionalNotes") String additionalNotes,
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
