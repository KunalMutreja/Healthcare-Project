package logistics;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
public class Admin_login extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_login() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
//        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
//        doGet(request, response);
        String Uname =null;
        String Passw =null;
        HttpSession session  = request.getSession();
        String user=request.getParameter("username");  
        String pass=request.getParameter("password");  
        PrintWriter out = response.getWriter();  

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
         String url = "jdbc:mysql://localhost:3306/healthcareproject";
            String username = "root";
            String password = "20csu214";
            try {
                Connection con = DriverManager.getConnection(url, username, password);
                
                PreparedStatement ps=con.prepareStatement(  
                        "select * from A_Login where username =? and password =?");  
            
                ps.setString(1,user);  
                ps.setString(2,pass); 
                
                ResultSet  i=ps.executeQuery();  
                
                
                while(i.next()) 
                {
                    Uname = i.getString("Username");
                    Passw = i.getString("Password");
               }
                if(user.equals(Uname) && pass.equals(Passw)) {
//                    out.println("<html><body>"+
//                            "<h2>Logged in Succesfully!! </h2>"+"<h3>Welcome "+user+"</h3>"+
//                                    "<h2><a href = 'Insertion'>Insertion</a></h2><h4><a href = 'session2'>Deletion</a></h4><h5><a href = 'session2'>View</a></h5><h7><a href = 'session2'>Update</a></h7>"
//                                    +"</body></html>");
                    response.sendRedirect("Admin.jsp");
                    
            }
                else
                {
                    response.sendRedirect("Adminlogin.jsp");
                }
            }
                catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            out.close();
    }
    
}