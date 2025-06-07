package com.kipcollo.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.io.IOException;

@Controller
@RequestMapping("/Profiles")
public class Profiles extends HttpServlet {

    
    protected void processRequest(@SessionAttribute("username") String user,
                                  HttpServletResponse response) throws IOException {

        if(user == null){
            response.sendRedirect("index.html");
          
        }else{
            response.sendRedirect("userProfile.jsp");
            
        }
    }
}
