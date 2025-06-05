import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/OrdersServlet")
public class OrdersServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("user");

        if (username != null) {
            String serviceType = request.getParameter("serviceType");
            int itemsCount = Integer.parseInt(request.getParameter("itemsCount"));
            String pickupTime = request.getParameter("pickupTime");
            String dropoffTime = request.getParameter("dropoffTime");

            String dbURL = "jdbc:mysql://localhost:3306/laundry_users";
            String user = "root";
            String dbPassword = "yourDB password";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                try (Connection con = DriverManager.getConnection(dbURL, user, dbPassword)) {
                    String sql = "INSERT INTO orders (user_id, service_type, items_count, pickup_time, dropoff_time, status) VALUES ((SELECT user_id FROM users WHERE Username=?), ?, ?, ?, ?, 'received')";
                    try (PreparedStatement statement = con.prepareStatement(sql)) {
                        statement.setString(1, username);
                        statement.setString(2, serviceType);
                        statement.setInt(3, itemsCount);
                        statement.setString(4, pickupTime);
                        statement.setString(5, dropoffTime);
                        statement.executeUpdate();
                        response.sendRedirect("OrderSuccess.jsp");
                    }
                }
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                response.sendRedirect("OrderError.jsp");
            }
        } else {
            response.sendRedirect("Login.jsp");
        }
    }
}
