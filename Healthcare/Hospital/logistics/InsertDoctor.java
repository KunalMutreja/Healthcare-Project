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
 * Servlet implementation class Insert_Doctor
 */
public class InsertDoctor extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertDoctor() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
//        response.getWriter().append("Served at: ").append(request.getContextPath());
         String id = request.getParameter("Id");
            String doc_name = request.getParameter("name");
            String speciality = request.getParameter("special");
            String timing = request.getParameter("time");
            response.setContentType("text/html");
            PrintWriter out = response.getWriter(); 
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url1 = "jdbc:mysql://localhost:3306/healthcareproject";
                String username1 = "root";
                String pass1 = "20csu214";
                Connection con = DriverManager.getConnection(url1, username1, pass1);
                String query = "insert into specialists values(?,?,?,?)";
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1, id);
                pstmt.setString(2, doc_name);
                pstmt.setString(3, speciality);
                pstmt.setString(4, timing);
                int i = pstmt.executeUpdate();
                if(i>0)
                {

                	response.sendRedirect("Delete.jsp");
                }
                else
                {
                    out.println("Error Occured");
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

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}