package com.kipcollo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Controller
public class User {

    @PostMapping("/add-user")
    protected String addUser(@RequestParam("username") String username,
                          @RequestParam("email") String email,
                          @RequestParam("password") String password,
                          @RequestParam("phone") String phone){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ARC_laundry", "root", "mAjimaji21!!");

            String sql = "INSERT INTO users (Username, Email, Password, Phone) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            pstmt.setString(4, phone);
            pstmt.executeUpdate();

            pstmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/AdminDashboard.jsp";
    }

    @RequestMapping("/delete-user")
    protected String delete(@RequestParam("userID") String userID) throws Exception {

        String dbURL = "jdbc:mysql://localhost:3306/ARC_laundry";
        String dbUser = "root";
        String dbPassword = "yourDB password";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(dbURL, dbUser, dbPassword)) {
                String sql = "DELETE FROM users WHERE UserID=?";
                try (PreparedStatement stmt = con.prepareStatement(sql)) {
                    stmt.setInt(1, Integer.parseInt(userID));
                    stmt.executeUpdate();
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new Exception("Database connection error", e);
        }

        return "redirect:/AdminDashboard";

    }
}
