package com.kipcollo.servlet;

import java.io.IOException;
//import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Profiles")
public class Profiles extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        if(session.getAttribute("username") == null){
            response.sendRedirect("index.html");
          
        }else{
            response.sendRedirect("userProfile.jsp");
            
        }
    }
}
