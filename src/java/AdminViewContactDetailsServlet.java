import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.data.Contact;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdminViewContactDetailsServlet")
public class AdminViewContactDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        List<Contact> contacts = new ArrayList<>();
        
        // JDBC Database Connection Information
        String url = "jdbc:mysql://localhost:3306/laundry_users";
        String user = "root";
        String dbPassword = "yourDB password";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(url, user, dbPassword)) {
                String query = "SELECT * FROM contacts";
                try (PreparedStatement pst = conn.prepareStatement(query);
                     ResultSet rs = pst.executeQuery()) {

                    while (rs.next()) {
                        Contact contact = new Contact();
                        contact.setContactID(rs.getInt("ContactID"));
                        contact.setUserID(rs.getInt("UserID"));
                        contact.setFirstName(rs.getString("FirstName"));
                        contact.setLastName(rs.getString("LastName"));
                        contact.setPhoneNumber(rs.getString("PhoneNumber"));

                        contacts.add(contact);
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            out.println("<h2>Error: " + e.getMessage() + "</h2>");
        }

        request.setAttribute("contacts", contacts);
        request.getRequestDispatcher("AdminViewContactDetails.jsp").forward(request, response);
    }
}
