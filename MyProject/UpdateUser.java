import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;

@WebServlet("/updateUser")
public class UpdateUser extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");

        String DB_URL = "jdbc:mysql://db4free.net:3306/smaple";
        String USER = "qwertyui";
        String PASS = "qwertyui";

        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");

        HttpSession sessionG = req.getSession(false);
        String username = (String) sessionG.getAttribute("Username");

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to the database successfully!");

            String sql = "UPDATE users SET firstname = ?, lastname = ?, email = ?, phone = ? WHERE username = ?";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, firstname);
            preparedStatement.setString(2, lastname);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, phone);
            preparedStatement.setString(5, username);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);
            
            
            sessionG.setAttribute("Firstname", firstname);
            sessionG.setAttribute("Lastname", lastname);
            sessionG.setAttribute("Email", email);
            sessionG.setAttribute("Phone", phone);

            
            res.sendRedirect("Home.jsp"); 

        } catch (SQLException e) {
            e.printStackTrace();
            
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
