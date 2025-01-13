import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Create extends HttpServlet{
	protected void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException,ServletException{
		
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		
		String First_Name = req.getParameter("firstname");
		String Last_Name = req.getParameter("lastname");
		String Phone = req.getParameter("phone");
		String Email = req.getParameter("email");
		String Username = req.getParameter("username");
		String Password = req.getParameter("password");
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/smaple","qwertyui","qwertyui");
			String Query = "INSERT INTO users(firstname,lastname,phone,email,username,password) Values(?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(Query);
			pstmt.setString(1,First_Name);
			pstmt.setString(2,Last_Name);
			pstmt.setString(3,Phone);
			pstmt.setString(4,Email);
			pstmt.setString(5,Username);
			pstmt.setString(6,Password);
			
			int rs = pstmt.executeUpdate();
			if(rs>0){
				// out.println(rs+" rows effected!");
				res.sendRedirect("index.html");
			}else{
				// out.println("0 rows effected!");
				  res.sendRedirect("Error.jsp?message=Error occurred during creating account");
			}
		}catch(Exception e){
				// out.println("Error : "+e);
				  res.sendRedirect("Error.jsp?message=Error occurred Because of Internate Connection");
		}
		
		
		out.close();
		
	}
}
 