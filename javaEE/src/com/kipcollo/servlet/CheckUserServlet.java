package com.kipcollo.servlet;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import models.business.User;
import models.business.UserIO;
import  com.kipcollo.util.CookieUtil;


public class CheckUserServlet extends HttpServlet
{
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException
    {
        String productCode = request.getParameter("productCode");
        HttpSession session = request.getSession();
        synchronized(session)
        {
            session.setAttribute("productCode", productCode);
        }
        User user = (User) session.getAttribute("user");

        String url = "";

        // if the User object doesn't exist, check for the email cookie
        if (user == null)
        {
            Cookie[] cookies = request.getCookies();
            String emailAddress =
                    CookieUtil.getCookieValue(cookies, "emailCookie");

            // if the email cookie doesn't exist, go to the registration page
            if (emailAddress == null || emailAddress.equals(""))
            {
                url = "/register.jsp";
            }
            // otherwise, create the User object from the email cookie
            // and skip the registration page
            else
            {
                ServletContext sc = getServletContext();
                String path = sc.getRealPath("WEB-INF/EmailList.txt");
                user = UserIO.getUser(emailAddress, path);
                session.setAttribute("user", user);
                url = "/" + productCode + "_download.jsp";
            }
        }
        // if the User object exists, skip the registration page
        else
        {
            url = "/" + productCode + "_download.jsp";
        }

        // forward to the view
        RequestDispatcher dispatcher =
            getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
