package com.kipcollo.servlet;

import java.io.IOException;
//import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/logout")
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


