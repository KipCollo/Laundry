package com.kipcollo.controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/MpesaCallbackServlet")
public class MpesaCallbackServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }

        String mpesaResponse = sb.toString();

        // Log the response (optional)
        // You can also write this to a file like in PHP example
        System.out.println("Mpesa Callback Response: " + mpesaResponse);

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print("{\"ResultCode\":0,\"ResultDesc\":\"Confirmation Received Successfully\"}");
        out.flush();
    }
}
