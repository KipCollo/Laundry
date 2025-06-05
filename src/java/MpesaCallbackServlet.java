import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import javax.servlet.annotation.WebServlet;

@WebServlet("/MpesaCallbackServlet")
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
