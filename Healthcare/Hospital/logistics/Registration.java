package logistics;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration1
 */
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String age = request.getParameter("age");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter(); 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url1 = "jdbc:mysql://localhost:3306/healthcareproject";
			String username1 = "root";
			String pass1 = "20csu214";
			Connection con = DriverManager.getConnection(url1, username1, pass1);
			String query = "insert into registration values(?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, email);
			pstmt.setString(4, age);
			pstmt.setString(5, gender);
			int i = pstmt.executeUpdate();
			if(i>0)
			{
				System.out.println("Registration successfull");
				response.sendRedirect("index.jsp");
			}
			else
			{
				System.out.println("Not registered");
			}
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
