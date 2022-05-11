<%@page import ="java.sql.Statement"%>
<%@page import ="java.sql.DriverManager"%>
<%@page import ="java.sql.Connection"%>
<%
	String id = request.getParameter("d");
	String no = (String)id;
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcareproject","root","20csu214");
	Statement stat = conn.createStatement();
	stat.executeUpdate("delete from products where id='"+no+"'");
	response.sendRedirect("UpdateProduct.jsp");
	%>