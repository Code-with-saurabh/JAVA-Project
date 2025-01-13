import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Main extends HttpServlet{
	protected void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException,ServletException{
		
		HttpSession Session = req.getSession();
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		 
		String Username = req.getParameter("username");
		String Password = req.getParameter("password");
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/smaple","qwertyui","qwertyui");
			String Query = "SELECT * FROM users WHERE username =? AND password=?";
			PreparedStatement pstmt = con.prepareStatement(Query);
			
			pstmt.setString(1,Username);
			pstmt.setString(2,Password);
			
			ResultSet rs  = pstmt.executeQuery();
			 
			if(rs.next()){
				Session.setAttribute("Username",Username);
				
				Session.setAttribute("Password",Password);
				
				Session.setAttribute("Email",rs.getString("email"));
				
				Session.setAttribute("Phone",rs.getString("phone"));
				Session.setAttribute("Firstname",rs.getString("firstname"));
				Session.setAttribute("Lastname",rs.getString("lastname"));
				
				
				
				 
				res.sendRedirect("Home.jsp");
			}else{
				  // out.println("<h3 style='color:red;'>Invalid username or password</h3>");
				// res.sendRedirect("Error.jsp");
				   res.sendRedirect("Error.jsp?message=Invalid username or password");
			}
			
			 
		}catch(Exception e){
				  // out.println("<h3 style='color:red;'>Error </h3>");
				  res.sendRedirect("Error.jsp?message=Error occurred during login");
		}
		
		
		out.close();
		
	}
}
 