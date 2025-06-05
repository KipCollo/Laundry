import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.data.Address;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdminViewUserAddressesServlet")
public class AdminViewUserAddressesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        // JDBC Database Connection Information
        String url = "jdbc:mysql://localhost:3306/laundry_users";
        String user = "root";
        String dbPassword = "yourDB password";

        List<Address> addresses = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(url, user, dbPassword)) {
                String query = "SELECT * FROM user_address";
                try (PreparedStatement pst = con.prepareStatement(query);
                     ResultSet rs = pst.executeQuery()) {

                    while (rs.next()) {
                        Address address = new Address();
                        address.setAddressID(rs.getInt("id"));
                        address.setUserID(rs.getInt("User_id")); // Ensure your Address class has this field
                        address.setStreetAddress(rs.getString("street_address"));
                        address.setApartmentNumber(rs.getString("apartment_number"));
                        address.setCity(rs.getString("city"));
                        address.setZipCode(rs.getString("zip_code"));
                        address.setAdditionalNotes(rs.getString("additional_notes"));
                        addresses.add(address);
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            PrintWriter out = response.getWriter();
            out.println("<h2>Error: " + e.getMessage() + "</h2>");
        }

        request.setAttribute("addresses", addresses);
        request.getRequestDispatcher("AdminViewUserAddresses.jsp").forward(request, response);
    }
}
