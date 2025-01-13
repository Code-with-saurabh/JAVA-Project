    import java.io.IOException;
    import javax.servlet.ServletException;
    import javax.servlet.annotation.WebServlet;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    import javax.servlet.http.HttpSession;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.sql.SQLException;

    @WebServlet("/DeleteUser")
    public class DeleteUser extends HttpServlet {

        protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
            HttpSession session = req.getSession(false);
            String username = (session != null) ? (String) session.getAttribute("Username") : null;

            if (username != null) {
                String DB_URL = "jdbc:mysql://db4free.net:3306/smaple";
                String USER = "qwertyui";
                String PASS = "qwertyui";
                
                Connection connection = null;
                PreparedStatement preparedStatement = null;
                
                try {
                    connection = DriverManager.getConnection(DB_URL, USER, PASS);
                    String sql = "DELETE FROM users WHERE username = ?";
                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, username);
                    
                    int rowsAffected = preparedStatement.executeUpdate();
                    System.out.println("Rows deleted: " + rowsAffected);
                    
                    session.invalidate();
                    
                    res.sendRedirect("index.html");
                    
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
            } else {
                res.sendRedirect("index.html");
            }
        }
    }
