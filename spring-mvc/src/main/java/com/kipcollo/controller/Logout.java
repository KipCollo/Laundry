package com.kipcollo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;


@Controller
@RequestMapping("/Logout")
public class Logout extends HttpServlet {


     @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException
            {
    
//            HttpSession session = request.getSession();
//            session.invalidate();
//                
//            response.sendRedirect("Login.jsp");
                HttpSession session = request.getSession(false); // Retrieve session, if exists
                if (session != null) {
                    session.invalidate(); // Invalidate session
                }
                response.sendRedirect("Login.jsp"); // Redirect to login page after logout
                
                
            }
}


