
import java.io.IOException;
//import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Logout")
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


