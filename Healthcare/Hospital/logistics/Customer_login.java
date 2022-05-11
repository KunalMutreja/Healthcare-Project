package logistics;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
public class Customer_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Customer_login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter(); 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url1 = "jdbc:mysql://localhost:3306/healthcareproject";
			String username1 = "root";
			String pass1 = "20csu214";
			String sqname=null;
			String sqpass=null;
			Connection con = DriverManager.getConnection(url1, username1, pass1);
			String query = "select * from registration where Name = ? and Password = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				sqname = rs.getString(1);
				sqpass = rs.getString(2);
			}
			if(username.equals(sqname)&&password.equals(sqpass))
			{
				System.out.println("Login successfull");
				response.sendRedirect("Customer.jsp");
//				out.println("<html><body>"+
//						"<h2>Logged in Succesfully!! </h2>"+"<h3>Welcome "+username+"</h3>"+
//								"<h2><a href = 'Insertion'>Insertion</a></h2><h4><a href = 'Deletion'>Deletion</a></h4><h5><a href = 'View'>View</a></h5><h7><a href = 'Updation'>Update</a></h7>"
//								+"</body></html>");
			}
			else
			{
				System.out.println("Login unsuccessfull");
				response.sendRedirect("C_Login.jsp");
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
