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

/**
 * Servlet implementation class Dashboard
 */
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dashboard() {
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
		String Tdoctor = null;
		String Adoctor = null;
		String Tmedicine = null;
		String Amedicine = null;

		response.setContentType("text/html");  
		PrintWriter out = response.getWriter(); 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url1 = "jdbc:mysql://localhost:3306/HealthcareProject";
			String username1 = "root";
			String pass1 = "20csu214";
			Connection con = DriverManager.getConnection(url1, username1, pass1);
			String query = "select * from dashboard";
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet r = pstmt.executeQuery();
			while(r.next())
			{
				Tdoctor = r.getString(1);
				Adoctor = r.getString(2);
				Tmedicine = r.getString(3);
				Amedicine = r.getString(4);
			}
			out.println("<!DOCTYPE html>\r\n"
					+ "<!-- Designined by CodingLab | www.youtube.com/codinglabyt -->\r\n"
					+ "<html lang=\"en\" dir=\"ltr\">\r\n"
					+ "  <head>\r\n"
					+ "  <style>\r\n"
					+ "  /* Googlefont Poppins CDN Link */\r\n"
					+ "@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap');\r\n"
					+ "*{\r\n"
					+ "  margin: 0;\r\n"
					+ "  padding: 0;\r\n"
					+ "  box-sizing: border-box;\r\n"
					+ "  font-family: 'Poppins', sans-serif;\r\n"
					+ "}\r\n"
					+ ".sidebar{\r\n"
					+ "  position: fixed;\r\n"
					+ "  height: 100%;\r\n"
					+ "  width: 240px;\r\n"
					+ "  background: #166bb9;\r\n"
					+ "  transition: all 0.5s ease;\r\n"
					+ "}\r\n"
					+ ".sidebar.active{\r\n"
					+ "  width: 60px;\r\n"
					+ "}\r\n"
					+ ".sidebar .logo-details{\r\n"
					+ "  height: 80px;\r\n"
					+ "  display: flex;\r\n"
					+ "  align-items: center;\r\n"
					+ "}\r\n"
					+ ".sidebar .logo-details i{\r\n"
					+ "  font-size: 28px;\r\n"
					+ "  font-weight: 500;\r\n"
					+ "  color: #fff;\r\n"
					+ "  min-width: 60px;\r\n"
					+ "  text-align: center\r\n"
					+ "}\r\n"
					+ ".sidebar .logo-details .logo_name{\r\n"
					+ "  color: #fff;\r\n"
					+ "  font-size: 24px;\r\n"
					+ "  font-weight: 500;\r\n"
					+ "}\r\n"
					+ ".sidebar .nav-links{\r\n"
					+ "  margin-top: 10px;\r\n"
					+ "}\r\n"
					+ ".sidebar .nav-links li{\r\n"
					+ "  position: relative;\r\n"
					+ "  list-style: none;\r\n"
					+ "  height: 50px;\r\n"
					+ "}\r\n"
					+ ".sidebar .nav-links li a{\r\n"
					+ "  height: 100%;\r\n"
					+ "  width: 100%;\r\n"
					+ "  display: flex;\r\n"
					+ "  align-items: center;\r\n"
					+ "  text-decoration: none;\r\n"
					+ "  transition: all 0.4s ease;\r\n"
					+ "}\r\n"
					+ ".sidebar .nav-links li a.active{\r\n"
					+ "  background:#0f4164;\r\n"
					+ "}\r\n"
					+ ".sidebar .nav-links li a:hover{\r\n"
					+ "  background: #0f4164;\r\n"
					+ "}\r\n"
					+ ".sidebar .nav-links li i{\r\n"
					+ "  min-width: 60px;\r\n"
					+ "  text-align: center;\r\n"
					+ "  font-size: 18px;\r\n"
					+ "  color: #fff;\r\n"
					+ "}\r\n"
					+ ".sidebar .nav-links li a .links_name{\r\n"
					+ "  color: #fff;\r\n"
					+ "  font-size: 15px;\r\n"
					+ "  font-weight: 400;\r\n"
					+ "  white-space: nowrap;\r\n"
					+ "}\r\n"
					+ ".sidebar .nav-links .log_out{\r\n"
					+ "  position: absolute;\r\n"
					+ "  bottom: 0;\r\n"
					+ "  width: 100%;\r\n"
					+ "}\r\n"
					+ ".home-section{\r\n"
					+ "  position: relative;\r\n"
					+ "  background: #f5f5f5;\r\n"
					+ "  min-height: 100vh;\r\n"
					+ "  width: calc(100% - 240px);\r\n"
					+ "  left: 240px;\r\n"
					+ "  transition: all 0.5s ease;\r\n"
					+ "}\r\n"
					+ ".sidebar.active ~ .home-section{\r\n"
					+ "  width: calc(100% - 60px);\r\n"
					+ "  left: 60px;\r\n"
					+ "}\r\n"
					+ ".home-section nav{\r\n"
					+ "  display: flex;\r\n"
					+ "  justify-content: space-between;\r\n"
					+ "  height: 80px;\r\n"
					+ "  background: #fff;\r\n"
					+ "  display: flex;\r\n"
					+ "  align-items: center;\r\n"
					+ "  position: fixed;\r\n"
					+ "  width: calc(100% - 240px);\r\n"
					+ "  left: 240px;\r\n"
					+ "  z-index: 100;\r\n"
					+ "  padding: 0 20px;\r\n"
					+ "  box-shadow: 0 1px 1px rgba(0, 0, 0, 0.1);\r\n"
					+ "  transition: all 0.5s ease;\r\n"
					+ "}\r\n"
					+ ".sidebar.active ~ .home-section nav{\r\n"
					+ "  left: 60px;\r\n"
					+ "  width: calc(100% - 60px);\r\n"
					+ "}\r\n"
					+ ".home-section nav .sidebar-button{\r\n"
					+ "  display: flex;\r\n"
					+ "  align-items: center;\r\n"
					+ "  font-size: 24px;\r\n"
					+ "  font-weight: 500;\r\n"
					+ "}\r\n"
					+ "nav .sidebar-button i{\r\n"
					+ "  font-size: 35px;\r\n"
					+ "  margin-right: 10px;\r\n"
					+ "}\r\n"
					+ ".home-section nav .search-box{\r\n"
					+ "  position: relative;\r\n"
					+ "  height: 50px;\r\n"
					+ "  max-width: 550px;\r\n"
					+ "  width: 100%;\r\n"
					+ "  margin: 0 20px;\r\n"
					+ "}\r\n"
					+ "nav .search-box input{\r\n"
					+ "  height: 100%;\r\n"
					+ "  width: 100%;\r\n"
					+ "  outline: none;\r\n"
					+ "  background: #F5F6FA;\r\n"
					+ "  border: 2px solid #EFEEF1;\r\n"
					+ "  border-radius: 6px;\r\n"
					+ "  font-size: 18px;\r\n"
					+ "  padding: 0 15px;\r\n"
					+ "}\r\n"
					+ "nav .search-box .bx-search{\r\n"
					+ "  position: absolute;\r\n"
					+ "  height: 40px;\r\n"
					+ "  width: 40px;\r\n"
					+ "  background: #2697FF;\r\n"
					+ "  right: 5px;\r\n"
					+ "  top: 50%;\r\n"
					+ "  transform: translateY(-50%);\r\n"
					+ "  border-radius: 4px;\r\n"
					+ "  line-height: 40px;\r\n"
					+ "  text-align: center;\r\n"
					+ "  color: #fff;\r\n"
					+ "  font-size: 22px;\r\n"
					+ "  transition: all 0.4 ease;\r\n"
					+ "}\r\n"
					+ ".home-section nav .profile-details{\r\n"
					+ "  display: flex;\r\n"
					+ "  align-items: center;\r\n"
					+ "  background: #F5F6FA;\r\n"
					+ "  border: 2px solid #EFEEF1;\r\n"
					+ "  border-radius: 6px;\r\n"
					+ "  height: 50px;\r\n"
					+ "  min-width: 190px;\r\n"
					+ "  padding: 0 15px 0 2px;\r\n"
					+ "}\r\n"
					+ "nav .profile-details img{\r\n"
					+ "  height: 40px;\r\n"
					+ "  width: 40px;\r\n"
					+ "  border-radius: 6px;\r\n"
					+ "  object-fit: cover;\r\n"
					+ "}\r\n"
					+ "nav .profile-details .admin_name{\r\n"
					+ "  font-size: 15px;\r\n"
					+ "  font-weight: 500;\r\n"
					+ "  color: #333;\r\n"
					+ "  margin: 0 10px;\r\n"
					+ "  white-space: nowrap;\r\n"
					+ "}\r\n"
					+ "nav .profile-details i{\r\n"
					+ "  font-size: 25px;\r\n"
					+ "  color: #333;\r\n"
					+ "}\r\n"
					+ ".home-section .home-content{\r\n"
					+ "  position: relative;\r\n"
					+ "  padding-top: 104px;\r\n"
					+ "}\r\n"
					+ ".home-content .overview-boxes{\r\n"
					+ "  display: flex;\r\n"
					+ "  align-items: center;\r\n"
					+ "  justify-content: space-between;\r\n"
					+ "  flex-wrap: wrap;\r\n"
					+ "  padding: 0 20px;\r\n"
					+ "  margin-bottom: 26px;\r\n"
					+ "}\r\n"
					+ ".overview-boxes .box{\r\n"
					+ "  display: flex;\r\n"
					+ "  align-items: center;\r\n"
					+ "  justify-content: center;\r\n"
					+ "  width: calc(100% / 4 - 15px);\r\n"
					+ "  background: #fff;\r\n"
					+ "  padding: 15px 14px;\r\n"
					+ "  border-radius: 12px;\r\n"
					+ "  box-shadow: 0 5px 10px rgba(0,0,0,0.1);\r\n"
					+ "}\r\n"
					+ ".overview-boxes .box-topic{\r\n"
					+ "  font-size: 20px;\r\n"
					+ "  font-weight: 500;\r\n"
					+ "}\r\n"
					+ ".home-content .box .number{\r\n"
					+ "  display: inline-block;\r\n"
					+ "  font-size: 35px;\r\n"
					+ "  margin-top: -6px;\r\n"
					+ "  font-weight: 500;\r\n"
					+ "}\r\n"
					+ ".home-content .box .indicator{\r\n"
					+ "  display: flex;\r\n"
					+ "  align-items: center;\r\n"
					+ "}\r\n"
					+ ".home-content .box .indicator i{\r\n"
					+ "  height: 20px;\r\n"
					+ "  width: 20px;\r\n"
					+ "  background: #8FDACB;\r\n"
					+ "  line-height: 20px;\r\n"
					+ "  text-align: center;\r\n"
					+ "  border-radius: 50%;\r\n"
					+ "  color: #fff;\r\n"
					+ "  font-size: 20px;\r\n"
					+ "  margin-right: 5px;\r\n"
					+ "}\r\n"
					+ ".box .indicator i.down{\r\n"
					+ "  background: #e87d88;\r\n"
					+ "}\r\n"
					+ ".home-content .box .indicator .text{\r\n"
					+ "  font-size: 12px;\r\n"
					+ "}\r\n"
					+ ".home-content .box .cart{\r\n"
					+ "  display: inline-block;\r\n"
					+ "  font-size: 32px;\r\n"
					+ "  height: 50px;\r\n"
					+ "  width: 50px;\r\n"
					+ "  background: #cce5ff;\r\n"
					+ "  line-height: 50px;\r\n"
					+ "  text-align: center;\r\n"
					+ "  color: #66b0ff;\r\n"
					+ "  border-radius: 12px;\r\n"
					+ "  margin: -15px 0 0 6px;\r\n"
					+ "}\r\n"
					+ ".home-content .box .cart.two{\r\n"
					+ "   color: #2BD47D;\r\n"
					+ "   background: #C0F2D8;\r\n"
					+ " }\r\n"
					+ ".home-content .box .cart.three{\r\n"
					+ "   color: #ffc233;\r\n"
					+ "   background: #ffe8b3;\r\n"
					+ " }\r\n"
					+ ".home-content .box .cart.four{\r\n"
					+ "   color: #e05260;\r\n"
					+ "   background: #f7d4d7;\r\n"
					+ " }\r\n"
					+ ".home-content .total-order{\r\n"
					+ "  font-size: 20px;\r\n"
					+ "  font-weight: 500;\r\n"
					+ "}\r\n"
					+ ".home-content .sales-boxes{\r\n"
					+ "  display: flex;\r\n"
					+ "  justify-content: space-between;\r\n"
					+ "  /* padding: 0 20px; */\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ "/* left box */\r\n"
					+ ".home-content .sales-boxes .recent-sales{\r\n"
					+ "  width: 65%;\r\n"
					+ "  background: #fff;\r\n"
					+ "  padding: 20px 30px;\r\n"
					+ "  margin: 0 20px;\r\n"
					+ "  border-radius: 12px;\r\n"
					+ "  box-shadow: 0 5px 10px rgba(0, 0, 0, 0.1);\r\n"
					+ "}\r\n"
					+ ".home-content .sales-boxes .sales-details{\r\n"
					+ "  display: flex;\r\n"
					+ "  align-items: center;\r\n"
					+ "  justify-content: space-between;\r\n"
					+ "}\r\n"
					+ ".sales-boxes .box .title{\r\n"
					+ "  font-size: 24px;\r\n"
					+ "  font-weight: 500;\r\n"
					+ "  /* margin-bottom: 10px; */\r\n"
					+ "}\r\n"
					+ ".sales-boxes .sales-details li.topic{\r\n"
					+ "  font-size: 20px;\r\n"
					+ "  font-weight: 500;\r\n"
					+ "}\r\n"
					+ ".sales-boxes .sales-details li{\r\n"
					+ "  list-style: none;\r\n"
					+ "  margin: 8px 0;\r\n"
					+ "}\r\n"
					+ ".sales-boxes .sales-details li a{\r\n"
					+ "  font-size: 18px;\r\n"
					+ "  color: #333;\r\n"
					+ "  font-size: 400;\r\n"
					+ "  text-decoration: none;\r\n"
					+ "}\r\n"
					+ ".sales-boxes .box .button{\r\n"
					+ "  width: 100%;\r\n"
					+ "  display: flex;\r\n"
					+ "  justify-content: flex-end;\r\n"
					+ "}\r\n"
					+ ".sales-boxes .box .button a{\r\n"
					+ "  color: #fff;\r\n"
					+ "  background: #0A2558;\r\n"
					+ "  padding: 4px 12px;\r\n"
					+ "  font-size: 15px;\r\n"
					+ "  font-weight: 400;\r\n"
					+ "  border-radius: 4px;\r\n"
					+ "  text-decoration: none;\r\n"
					+ "  transition: all 0.3s ease;\r\n"
					+ "}\r\n"
					+ ".sales-boxes .box .button a:hover{\r\n"
					+ "  background:  #0d3073;\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ "/* Right box */\r\n"
					+ ".home-content .sales-boxes .top-sales{\r\n"
					+ "  width: 35%;\r\n"
					+ "  background: #fff;\r\n"
					+ "  padding: 20px 30px;\r\n"
					+ "  margin: 0 20px 0 0;\r\n"
					+ "  border-radius: 12px;\r\n"
					+ "  box-shadow: 0 5px 10px rgba(0, 0, 0, 0.1);\r\n"
					+ "}\r\n"
					+ ".sales-boxes .top-sales li{\r\n"
					+ "  display: flex;\r\n"
					+ "  align-items: center;\r\n"
					+ "  justify-content: space-between;\r\n"
					+ "  margin: 10px 0;\r\n"
					+ "}\r\n"
					+ ".sales-boxes .top-sales li a img{\r\n"
					+ "  height: 40px;\r\n"
					+ "  width: 40px;\r\n"
					+ "  object-fit: cover;\r\n"
					+ "  border-radius: 12px;\r\n"
					+ "  margin-right: 10px;\r\n"
					+ "  background: #333;\r\n"
					+ "}\r\n"
					+ ".sales-boxes .top-sales li a{\r\n"
					+ "  display: flex;\r\n"
					+ "  align-items: center;\r\n"
					+ "  text-decoration: none;\r\n"
					+ "}\r\n"
					+ ".sales-boxes .top-sales li .product,\r\n"
					+ ".price{\r\n"
					+ "  font-size: 17px;\r\n"
					+ "  font-weight: 400;\r\n"
					+ "  color: #333;\r\n"
					+ "}\r\n"
					+ "/* Responsive Media Query */\r\n"
					+ "@media (max-width: 1240px) {\r\n"
					+ "  .sidebar{\r\n"
					+ "    width: 60px;\r\n"
					+ "  }\r\n"
					+ "  .sidebar.active{\r\n"
					+ "    width: 220px;\r\n"
					+ "  }\r\n"
					+ "  .home-section{\r\n"
					+ "    width: calc(100% - 60px);\r\n"
					+ "    left: 60px;\r\n"
					+ "  }\r\n"
					+ "  .sidebar.active ~ .home-section{\r\n"
					+ "    /* width: calc(100% - 220px); */\r\n"
					+ "    overflow: hidden;\r\n"
					+ "    left: 220px;\r\n"
					+ "  }\r\n"
					+ "  .home-section nav{\r\n"
					+ "    width: calc(100% - 60px);\r\n"
					+ "    left: 60px;\r\n"
					+ "  }\r\n"
					+ "  .sidebar.active ~ .home-section nav{\r\n"
					+ "    width: calc(100% - 220px);\r\n"
					+ "    left: 220px;\r\n"
					+ "  }\r\n"
					+ "}\r\n"
					+ "@media (max-width: 1150px) {\r\n"
					+ "  .home-content .sales-boxes{\r\n"
					+ "    flex-direction: column;\r\n"
					+ "  }\r\n"
					+ "  .home-content .sales-boxes .box{\r\n"
					+ "    width: 100%;\r\n"
					+ "    overflow-x: scroll;\r\n"
					+ "    margin-bottom: 30px;\r\n"
					+ "  }\r\n"
					+ "  .home-content .sales-boxes .top-sales{\r\n"
					+ "    margin: 0;\r\n"
					+ "  }\r\n"
					+ "}\r\n"
					+ "@media (max-width: 1000px) {\r\n"
					+ "  .overview-boxes .box{\r\n"
					+ "    width: calc(100% / 2 - 15px);\r\n"
					+ "    margin-bottom: 15px;\r\n"
					+ "  }\r\n"
					+ "}\r\n"
					+ "@media (max-width: 700px) {\r\n"
					+ "  nav .sidebar-button .dashboard,\r\n"
					+ "  nav .profile-details .admin_name,\r\n"
					+ "  nav .profile-details i{\r\n"
					+ "    display: none;\r\n"
					+ "  }\r\n"
					+ "  .home-section nav .profile-details{\r\n"
					+ "    height: 50px;\r\n"
					+ "    min-width: 40px;\r\n"
					+ "  }\r\n"
					+ "  .home-content .sales-boxes .sales-details{\r\n"
					+ "    width: 560px;\r\n"
					+ "  }\r\n"
					+ "}\r\n"
					+ "@media (max-width: 550px) {\r\n"
					+ "  .overview-boxes .box{\r\n"
					+ "    width: 100%;\r\n"
					+ "    margin-bottom: 15px;\r\n"
					+ "  }\r\n"
					+ "  .sidebar.active ~ .home-section nav .profile-details{\r\n"
					+ "    display: none;\r\n"
					+ "  }\r\n"
					+ "}\r\n"
					+ "  \r\n"
					+ "  </style>\r\n"
					+ "    <meta charset=\"UTF-8\">\r\n"
					+ "    <!--<title> Responsiive Admin Dashboard | CodingLab </title>-->\r\n"
					+ "    <link rel=\"stylesheet\" href=\"style.css\">\r\n"
					+ "    <!-- Boxicons CDN Link -->\r\n"
					+ "    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>\r\n"
					+ "     <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ "   </head>\r\n"
					+ "<body>\r\n"
					+ "  <div class=\"sidebar\">\r\n"
					+ "    <div class=\"logo-details\">\r\n"
					+ "      <i class='bx bxl-c-plus-plus'></i>\r\n"
					+ "      <span class=\"logo_name\">CodingLab</span>\r\n"
					+ "    </div>\r\n"
					+ "      <ul class=\"nav-links\">\r\n"
					+ "        <li>\r\n"
					+ "          <a href=\"#\" class=\"active\">\r\n"
					+ "            <i class='bx bx-grid-alt' ></i>\r\n"
					+ "            <span class=\"links_name\">Dashboard</span>\r\n"
					+ "          </a>\r\n"
					+ "        </li>\r\n"
					+ "        <li>\r\n"
					+ "          <a href=\"#\">\r\n"
					+ "            <i class='bx bxs-user-check' ></i>\r\n"
					+ "            <span class=\"links_name\">Admin</span>\r\n"
					+ "          </a>\r\n"
					+ "        </li>\r\n"
					+ "        \r\n"
					+ "        <li>\r\n"
					+ "          <a href=\"Doc_Login\">\r\n"
					+ "            <i class='bx bx-user' ></i>\r\n"
					+ "            <span class=\"links_name\">Login</span>\r\n"
					+ "          </a>\r\n"
					+ "        </li>\r\n"
					+ "        <li>\r\n"
					+ "          <a href=\"Registration.jsp\">\r\n"
					+ "            <i class='bx bx-log-in-circle'></i>\r\n"
					+ "            <span class=\"links_name\">SignUp</span>\r\n"
					+ "          </a>\r\n"
					+ "        </li>\r\n"
					+ "         <li>\r\n"
					+ "          <a href=\"Doc_Login\">\r\n"
					+ "            <i class='bx bx-clinic' ></i>\r\n"
					+ "            <span class=\"links_name\">Doctor</span>\r\n"
					+ "          </a>\r\n"
					+ "        <li class=\"log_out\">\r\n"
					+ "          <a href=\"#\">\r\n"
					+ "            <i class='bx bx-log-out'></i>\r\n"
					+ "            <span class=\"links_name\">Log out</span>\r\n"
					+ "          </a>\r\n"
					+ "        </li>\r\n"
					+ "         <li>\r\n"
					+ "          <a href=\"#\">\r\n"
					+ "            <i class='bx bx-help-circle' ></i>\r\n"
					+ "            <span class=\"links_name\">Help</span>\r\n"
					+ "          </a>\r\n"
					+ "        </li>\r\n"
					+ "      </ul>\r\n"
					+ "  </div>\r\n"
					+ "  <section class=\"home-section\">\r\n"
					+ "    <nav>\r\n"
					+ "      <div class=\"sidebar-button\">\r\n"
					+ "        <i class='bx bx-menu sidebarBtn'></i>\r\n"
					+ "        <span class=\"dashboard\">Dashboard</span>\r\n"
					+ "      </div>\r\n"
					+ "      <div class=\"search-box\">\r\n"
					+ "        <input type=\"text\" placeholder=\"Search...\">\r\n"
					+ "        <i class='bx bx-search' ></i>\r\n"
					+ "      </div>\r\n"
					+ "      <div class=\"profile-details\">\r\n"
					+ "        <!--<img src=\"images/profile.jpg\" alt=\"\">-->\r\n"
					+ "        <span class=\"admin_name\">Prem Shahi</span>\r\n"
					+ "        <i class='bx bx-chevron-down' ></i>\r\n"
					+ "      </div>\r\n"
					+ "    </nav>\r\n"
					+ "\r\n"
					+ "    <div class=\"home-content\">\r\n"
					+ "      <div class=\"overview-boxes\">\r\n"
					+ "        <div class=\"box\">\r\n"
					+ "          <div class=\"right-side\">\r\n"
					+ "            <div class=\"box-topic\">Total Doctor</div>\r\n"
					+ "            <div class=\"number\">"+Tdoctor+"</div>\r\n"
					+ "            <div class=\"indicator\">\r\n"
					+ "              <i class='bx bx-plus-medical'></i>\r\n"
					+ "              <span class=\"text\">Up from yesterday</span>\r\n"
					+ "            </div>\r\n"
					+ "          </div>\r\n"
					+ "          <i class='bx bx-cart-alt cart'></i>\r\n"
					+ "        </div>\r\n"
					+ "        <div class=\"box\">\r\n"
					+ "          <div class=\"right-side\">\r\n"
					+ "            <div class=\"box-topic\">Available Doctor</div>\r\n"
					+ "            <div class=\"number\">"+Adoctor+"</div>\r\n"
					+ "            <div class=\"indicator\">\r\n"
					+ "              <i class='bx bxs-injection'></i>\r\n"
					+ "              <span class=\"text\">Up from yesterday</span>\r\n"
					+ "            </div>\r\n"
					+ "          </div>\r\n"
					+ "          <i class='bx bxs-cart-add cart two' ></i>\r\n"
					+ "        </div>\r\n"
					+ "        <div class=\"box\">\r\n"
					+ "          <div class=\"right-side\">\r\n"
					+ "            <div class=\"box-topic\">Total Medicine</div>\r\n"
					+ "            <div class=\"number\">"+Tmedicine+"</div>\r\n"
					+ "            <div class=\"indicator\">\r\n"
					+ "              <i class='bx bxs-capsule' ></i>\r\n"
					+ "              <span class=\"text\">Up from yesterday</span>\r\n"
					+ "            </div>\r\n"
					+ "          </div>\r\n"
					+ "          <i class='bx bx-cart cart three' ></i>\r\n"
					+ "        </div>\r\n"
					+ "        <div class=\"box\">\r\n"
					+ "          <div class=\"right-side\">\r\n"
					+ "            <div class=\"box-topic\">Available Medicine</div>\r\n"
					+ "            <div class=\"number\">"+Amedicine+"</div>\r\n"
					+ "            <div class=\"indicator\">\r\n"
					+ "              <i class='bx bx-capsule'></i>\r\n"
					+ "              <span class=\"text\">Down From Today</span>\r\n"
					+ "            </div>\r\n"
					+ "          </div>\r\n"
					+ "          <i class='bx bxs-cart-download cart four' ></i>\r\n"
					+ "        </div>\r\n"
					+ "      </div>\r\n"
					+ "\r\n"
					+ "      <div class=\"sales-boxes\">\r\n"
					+ "        <div class=\"recent-sales box\">\r\n"
					+ "          <div class=\"title\">Recent Sales</div>\r\n"
					+ "          <div class=\"sales-details\">\r\n"
					+ "            <ul class=\"details\">\r\n"
					+ "              <li class=\"topic\">Date</li>\r\n"
					+ "              <li><a href=\"#\">02 Jan 2021</a></li>\r\n"
					+ "              <li><a href=\"#\">02 Jan 2021</a></li>\r\n"
					+ "              <li><a href=\"#\">02 Jan 2021</a></li>\r\n"
					+ "              <li><a href=\"#\">02 Jan 2021</a></li>\r\n"
					+ "              <li><a href=\"#\">02 Jan 2021</a></li>\r\n"
					+ "              <li><a href=\"#\">02 Jan 2021</a></li>\r\n"
					+ "              <li><a href=\"#\">02 Jan 2021</a></li>\r\n"
					+ "            </ul>\r\n"
					+ "            <ul class=\"details\">\r\n"
					+ "            <li class=\"topic\">Customer</li>\r\n"
					+ "            <li><a href=\"#\">Alex Doe</a></li>\r\n"
					+ "            <li><a href=\"#\">David Mart</a></li>\r\n"
					+ "            <li><a href=\"#\">Roe Parter</a></li>\r\n"
					+ "            <li><a href=\"#\">Diana Penty</a></li>\r\n"
					+ "            <li><a href=\"#\">Martin Paw</a></li>\r\n"
					+ "            <li><a href=\"#\">Doe Alex</a></li>\r\n"
					+ "            <li><a href=\"#\">Aiana Lexa</a></li>\r\n"
					+ "            <li><a href=\"#\">Rexel Mags</a></li>\r\n"
					+ "             <li><a href=\"#\">Tiana Loths</a></li>\r\n"
					+ "          </ul>\r\n"
					+ "          <ul class=\"details\">\r\n"
					+ "            <li class=\"topic\">Sales</li>\r\n"
					+ "            <li><a href=\"#\">Delivered</a></li>\r\n"
					+ "            <li><a href=\"#\">Pending</a></li>\r\n"
					+ "            <li><a href=\"#\">Returned</a></li>\r\n"
					+ "            <li><a href=\"#\">Delivered</a></li>\r\n"
					+ "            <li><a href=\"#\">Pending</a></li>\r\n"
					+ "            <li><a href=\"#\">Returned</a></li>\r\n"
					+ "            <li><a href=\"#\">Delivered</a></li>\r\n"
					+ "             <li><a href=\"#\">Pending</a></li>\r\n"
					+ "            <li><a href=\"#\">Delivered</a></li>\r\n"
					+ "          </ul>\r\n"
					+ "          <ul class=\"details\">\r\n"
					+ "            <li class=\"topic\">Total</li>\r\n"
					+ "            <li><a href=\"#\">$204.98</a></li>\r\n"
					+ "            <li><a href=\"#\">$24.55</a></li>\r\n"
					+ "            <li><a href=\"#\">$25.88</a></li>\r\n"
					+ "            <li><a href=\"#\">$170.66</a></li>\r\n"
					+ "            <li><a href=\"#\">$56.56</a></li>\r\n"
					+ "            <li><a href=\"#\">$44.95</a></li>\r\n"
					+ "            <li><a href=\"#\">$67.33</a></li>\r\n"
					+ "             <li><a href=\"#\">$23.53</a></li>\r\n"
					+ "             <li><a href=\"#\">$46.52</a></li>\r\n"
					+ "          </ul>\r\n"
					+ "          </div>\r\n"
					+ "          <div class=\"button\">\r\n"
					+ "            <a href=\"#\">See All</a>\r\n"
					+ "          </div>\r\n"
					+ "        </div>\r\n"
					+ "        <div class=\"top-sales box\">\r\n"
					+ "          <div class=\"title\">Top Seling Product</div>\r\n"
					+ "          <ul class=\"top-sales-details\">\r\n"
					+ "            <li>\r\n"
					+ "            <a href=\"#\">\r\n"
					+ "              <!--<img src=\"images/sunglasses.jpg\" alt=\"\">-->\r\n"
					+ "              <span class=\"product\">Vuitton Sunglasses</span>\r\n"
					+ "            </a>\r\n"
					+ "            <span class=\"price\">$1107</span>\r\n"
					+ "          </li>\r\n"
					+ "          <li>\r\n"
					+ "            <a href=\"#\">\r\n"
					+ "               <!--<img src=\"images/jeans.jpg\" alt=\"\">-->\r\n"
					+ "              <span class=\"product\">Hourglass Jeans </span>\r\n"
					+ "            </a>\r\n"
					+ "            <span class=\"price\">$1567</span>\r\n"
					+ "          </li>\r\n"
					+ "          <li>\r\n"
					+ "            <a href=\"#\">\r\n"
					+ "             <!-- <img src=\"images/nike.jpg\" alt=\"\">-->\r\n"
					+ "              <span class=\"product\">Nike Sport Shoe</span>\r\n"
					+ "            </a>\r\n"
					+ "            <span class=\"price\">$1234</span>\r\n"
					+ "          </li>\r\n"
					+ "          <li>\r\n"
					+ "            <a href=\"#\">\r\n"
					+ "              <!--<img src=\"images/scarves.jpg\" alt=\"\">-->\r\n"
					+ "              <span class=\"product\">Hermes Silk Scarves.</span>\r\n"
					+ "            </a>\r\n"
					+ "            <span class=\"price\">$2312</span>\r\n"
					+ "          </li>\r\n"
					+ "          <li>\r\n"
					+ "            <a href=\"#\">\r\n"
					+ "              <!--<img src=\"images/blueBag.jpg\" alt=\"\">-->\r\n"
					+ "              <span class=\"product\">Succi Ladies Bag</span>\r\n"
					+ "            </a>\r\n"
					+ "            <span class=\"price\">$1456</span>\r\n"
					+ "          </li>\r\n"
					+ "          <li>\r\n"
					+ "            <a href=\"#\">\r\n"
					+ "              <!--<img src=\"images/bag.jpg\" alt=\"\">-->\r\n"
					+ "              <span class=\"product\">Gucci Womens's Bags</span>\r\n"
					+ "            </a>\r\n"
					+ "            <span class=\"price\">$2345</span>\r\n"
					+ "          <li>\r\n"
					+ "            <a href=\"#\">\r\n"
					+ "              <!--<img src=\"images/addidas.jpg\" alt=\"\">-->\r\n"
					+ "              <span class=\"product\">Addidas Running Shoe</span>\r\n"
					+ "            </a>\r\n"
					+ "            <span class=\"price\">$2345</span>\r\n"
					+ "          </li>\r\n"
					+ "<li>\r\n"
					+ "            <a href=\"#\">\r\n"
					+ "             <!--<img src=\"images/shirt.jpg\" alt=\"\">-->\r\n"
					+ "              <span class=\"product\">Bilack Wear's Shirt</span>\r\n"
					+ "            </a>\r\n"
					+ "            <span class=\"price\">$1245</span>\r\n"
					+ "          </li>\r\n"
					+ "          </ul>\r\n"
					+ "        </div>\r\n"
					+ "      </div>\r\n"
					+ "    </div>\r\n"
					+ "  </section>\r\n"
					+ "\r\n"
					+ "  <script>\r\n"
					+ "   let sidebar = document.querySelector(\".sidebar\");\r\n"
					+ "let sidebarBtn = document.querySelector(\".sidebarBtn\");\r\n"
					+ "sidebarBtn.onclick = function() {\r\n"
					+ "  sidebar.classList.toggle(\"active\");\r\n"
					+ "  if(sidebar.classList.contains(\"active\")){\r\n"
					+ "  sidebarBtn.classList.replace(\"bx-menu\" ,\"bx-menu-alt-right\");\r\n"
					+ "}else\r\n"
					+ "  sidebarBtn.classList.replace(\"bx-menu-alt-right\", \"bx-menu\");\r\n"
					+ "}\r\n"
					+ " </script>\r\n"
					+ "\r\n"
					+ "</body>\r\n"
					+ "</html>\r\n"
					+ "");
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

