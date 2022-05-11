<!DOCTYPE html>
<!-- Designined by CodingLab | www.youtube.com/codinglabyt -->
<%@page import="java.sql.DriverManager" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.sql.*"%>
<%@page import="java.util.Date"%>

<html lang="en" dir="ltr">
  <head>
  <script
      src="https://kit.fontawesome.com/64d58efce2.js"
      crossorigin="anonymous"
    ></script>
  <%
		Class.forName("com.mysql.cj.jdbc.Driver");

	
	
	 String url = "jdbc:mysql://localhost:3306/healthcareproject";
      String username = "root";
      String password = "20csu214";
     
			Connection con = DriverManager.getConnection(url, username, password);
     
			 %>
    <style>
 /* Googlefont Poppins CDN Link */
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap');
*{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: 'Poppins', sans-serif;
}
.sidebar{
  position: fixed;
  height: 100%;
  width: 240px;
  background: #289d75;
  transition: all 0.5s ease;
}
.sidebar.active{
  width: 60px;
}
.sidebar .logo-details{
  height: 80px;
  display: flex;
  align-items: center;
}
.sidebar .logo-details i{
  font-size: 28px;
  font-weight: 500;
  color: #fff;
  min-width: 60px;
  text-align: center
}
.sidebar .logo-details .logo_name{
  color: #fff;
  font-size: 24px;
  font-weight: 500;
}
.sidebar .nav-links{
  margin-top: 10px;
}
.sidebar .nav-links li{
  position: relative;
  list-style: none;
  height: 50px;
}
.sidebar .nav-links li a{
  height: 100%;
  width: 100%;
  display: flex;
  align-items: center;
  text-decoration: none;
  transition: all 0.4s ease;
}
.sidebar .nav-links li a.active{
  background:#08563c;
}
.sidebar .nav-links li a:hover{
  background: #08563c;
}
.sidebar .nav-links li i{
  min-width: 60px;
  text-align: center;
  font-size: 18px;
  color: #fff;
}
.sidebar .nav-links li a .links_name{
  color: #fff;
  font-size: 15px;
  font-weight: 400;
  white-space: nowrap;
}
.sidebar .nav-links .log_out{
  position: absolute;
  bottom: 0;
  width: 100%;
}
.home-section{
  position: relative;
  background: #f5f5f5;
  min-height: 100vh;
  width: calc(100% - 240px);
  left: 240px;
  transition: all 0.5s ease;
}
.sidebar.active ~ .home-section{
  width: calc(100% - 60px);
  left: 60px;
}
.home-section nav{
  display: flex;
  justify-content: space-between;
  height: 80px;
  background: #fff;
  display: flex;
  align-items: center;
  position: fixed;
  width: calc(100% - 240px);
  left: 240px;
  z-index: 100;
  padding: 0 20px;
  box-shadow: 0 1px 1px rgba(0, 0, 0, 0.1);
  transition: all 0.5s ease;
}
.sidebar.active ~ .home-section nav{
  left: 60px;
  width: calc(100% - 60px);
}
.home-section nav .sidebar-button{
  display: flex;
  align-items: center;
  font-size: 24px;
  font-weight: 500;
}
nav .sidebar-button i{
  font-size: 35px;
  margin-right: 10px;
}
.home-section nav .search-box{
  position: relative;
  height: 50px;
  max-width: 550px;
  width: 100%;
  margin: 0 20px;
}
nav .search-box input{
  height: 100%;
  width: 100%;
  outline: none;
  background: #F5F6FA;
  border: 2px solid #EFEEF1;
  border-radius: 6px;
  font-size: 18px;
  padding: 0 15px;
}
nav .search-box .bx-search{
  position: absolute;
  height: 40px;
  width: 40px;
  background: #2697FF;
  right: 5px;
  top: 50%;
  transform: translateY(-50%);
  border-radius: 4px;
  line-height: 40px;
  text-align: center;
  color: #fff;
  font-size: 22px;
  transition: all 0.4 ease;
}
.home-section nav .profile-details{
  display: flex;
  align-items: center;
  background: #F5F6FA;
  border: 2px solid #EFEEF1;
  border-radius: 6px;
  height: 50px;
  min-width: 190px;
  padding: 0 15px 0 2px;
}
nav .profile-details img{
  height: 40px;
  width: 40px;
  border-radius: 6px;
  object-fit: cover;
}
nav .profile-details .admin_name{
  font-size: 15px;
  font-weight: 500;
  color: #333;
  margin: 0 10px;
  white-space: nowrap;
}
nav .profile-details i{
  font-size: 25px;
  color: #333;
}
.home-section .home-content{
  position: relative;
  padding-top: 104px;
}
.home-content .overview-boxes{
  display: flex;
  align-items: center;
  justify-content: space-between;
  flex-wrap: wrap;
  padding: 0 20px;
  margin-bottom: 26px;
}
.overview-boxes .box{
  display: flex;
  align-items: center;
  justify-content: center;
  width: calc(100% / 4 - 15px);
  background: #fff;
  padding: 15px 14px;
  border-radius: 12px;
  box-shadow: 0 5px 10px rgba(0,0,0,0.1);
}
.overview-boxes .box-topic{
  font-size: 20px;
  font-weight: 500;
}
.home-content .box .number{
  display: inline-block;
  font-size: 35px;
  margin-top: -6px;
  font-weight: 500;
}
.home-content .box .indicator{
  display: flex;
  align-items: center;
}
.home-content .box .indicator i{
  height: 20px;
  width: 20px;
  background: #8FDACB;
  line-height: 20px;
  text-align: center;
  border-radius: 50%;
  color: #fff;
  font-size: 20px;
  margin-right: 5px;
}
.box .indicator i.down{
  background: #e87d88;
}
.home-content .box .indicator .text{
  font-size: 12px;
}
.home-content .box .cart{
  display: inline-block;
  font-size: 32px;
  height: 50px;
  width: 50px;
  background: #cce5ff;
  line-height: 50px;
  text-align: center;
  color: #66b0ff;
  border-radius: 12px;
  margin: -15px 0 0 6px;
}
.home-content .box .cart.two{
   color: #2BD47D;
   background: #C0F2D8;
 }
.home-content .box .cart.three{
   color: #ffc233;
   background: #ffe8b3;
 }
.home-content .box .cart.four{
   color: #e05260;
   background: #f7d4d7;
 }
.home-content .total-order{
  font-size: 20px;
  font-weight: 500;
}
.home-content .sales-boxes{
  display: flex;
  justify-content: space-between;
  /* padding: 0 20px; */
}

/* left box */
.home-content .sales-boxes .recent-sales{
  width: 65%;
  background: #fff;
  padding: 20px 30px;
  margin: 0 20px;
  border-radius: 12px;
  box-shadow: 0 5px 10px rgba(0, 0, 0, 0.1);
}
.home-content .sales-boxes .sales-details{
  display: flex;
  align-items: center;
  justify-content: space-between;
}
.sales-boxes .box .title{
  font-size: 24px;
  font-weight: 500;
  /* margin-bottom: 10px; */
}
.sales-boxes .sales-details li.topic{
  font-size: 20px;
  font-weight: 500;
}
.sales-boxes .sales-details li{
  list-style: none;
  margin: 8px 0;
}
.sales-boxes .sales-details li a{
  font-size: 18px;
  color: #333;
  font-size: 400;
  text-decoration: none;
}
.sales-boxes .box .button{
  width: 100%;
  display: flex;
  justify-content: flex-end;
}
.sales-boxes .box .button a{
  color: #fff;
  background: #0A2558;
  padding: 4px 12px;
  font-size: 15px;
  font-weight: 400;
  border-radius: 4px;
  text-decoration: none;
  transition: all 0.3s ease;
}
.sales-boxes .box .button a:hover{
  background:  #0d3073;
}

/* Right box */
.home-content .sales-boxes .top-sales{
  width: 35%;
  background: #fff;
  padding: 20px 30px;
  margin: 0 20px 0 0;
  border-radius: 12px;
  box-shadow: 0 5px 10px rgba(0, 0, 0, 0.1);
}
.sales-boxes .top-sales li{
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin: 10px 0;
}
.sales-boxes .top-sales li a img{
  height: 40px;
  width: 40px;
  object-fit: cover;
  border-radius: 12px;
  margin-right: 10px;
  background: #333;
}
.sales-boxes .top-sales li a{
  display: flex;
  align-items: center;
  text-decoration: none;
}
.sales-boxes .top-sales li .product,
.price{
  font-size: 17px;
  font-weight: 400;
  color: #333;
}
/* Responsive Media Query */
@media (max-width: 1240px) {
  .sidebar{
    width: 60px;
  }
  .sidebar.active{
    width: 220px;
  }
  .home-section{
    width: calc(100% - 60px);
    left: 60px;
  }
  .sidebar.active ~ .home-section{
    /* width: calc(100% - 220px); */
    overflow: hidden;
    left: 220px;
  }
  .home-section nav{
    width: calc(100% - 60px);
    left: 60px;
  }
  .sidebar.active ~ .home-section nav{
    width: calc(100% - 220px);
    left: 220px;
  }
}
@media (max-width: 1150px) {
  .home-content .sales-boxes{
    flex-direction: column;
  }
  .home-content .sales-boxes .box{
    width: 100%;
    overflow-x: scroll;
    margin-bottom: 30px;
  }
  .home-content .sales-boxes .top-sales{
    margin: 0;
  }
}
@media (max-width: 1000px) {
  .overview-boxes .box{
    width: calc(100% / 2 - 15px);
    margin-bottom: 15px;
  }
}
@media (max-width: 700px) {
  nav .sidebar-button .dashboard,
  nav .profile-details .admin_name,
  nav .profile-details i{
    display: none;
  }
  .home-section nav .profile-details{
    height: 50px;
    min-width: 40px;
  }
  .home-content .sales-boxes .sales-details{
    width: 560px;
  }
}
@media (max-width: 550px) {
  .overview-boxes .box{
    width: 100%;
    margin-bottom: 15px;
  }
  .sidebar.active ~ .home-section nav .profile-details{
    display: none;
  }
}
  
  </style>
    <meta charset="UTF-8">
    <!--<title> Responsiive Admin Dashboard | CodingLab </title>-->
    <link rel="stylesheet" href="style.css">
    <!-- Boxicons CDN Link -->
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
   </head>
<body>
  <div class="sidebar">
    <div class="logo-details">
       <i class='bx bxs-user-check' ></i>
      <span class="logo_name">Admin</span>
    </div>
    <hr>
      <ul class="nav-links">
        
        <li>
          <a href="UpdateProduct.jsp">
            <i class='bx bxs-cart-add'></i>
            <span class="links_name">Medicine Panel</span>
          </a>
        </li>
        <li>
          <a href="Delete.jsp">
            <i class='bx bxs-chevrons-up'></i>
            <span class="links_name">Doctor Panel</span>
          </a>
        </li>
        
        <li>
          <a href="MedicineView.jsp">
            <i class='bx bx-plus-medical'></i>
            <span class="links_name">View Medicine</span>
          </a>
        </li>
        <li>
          <a href="AdminView.jsp">
            <i class='bx bx-donate-heart'></i>
            <span class="links_name">View Doctor</span>
          </a>
        </li>
        <li class="log_out">
          <a href="index.jsp">
            <i class='bx bx-log-out'></i>
            <span class="links_name">Log out</span>
          </a>
        </li>
         <li>
          <a href="help.jsp">
            <i class='bx bx-help-circle' ></i>
            <span class="links_name">Help</span>
          </a>
        </li>
      </ul>
  </div>
  <section class="home-section">
    
      
<!DOCTYPE html>
<html>
<head>
 <title></title>
 <link rel="stylesheet" type="text/css" href="css/style.css">
 <link href="https://fonts.googleapis.com/css?family=Josefin+Sans&display=swap" rel="stylesheet">
</head>
<body>
<style>
writeup{
margin: 0; padding: 0;
box-sizing: border-box;
font-family: 'Josefin Sans', sans-serif;
}

header{
 width: 100%;
 height: 100vh;
 background-image: url('bg.png');
 background-repeat: no-repeat;
 background-size: 100% 100%;

}

.mainheader{
 width: 100%;
 height: 100px;
 display: flex;
 justify-content: space-between;
 align-items: center;
}

.mainheader .logo img{
 width: 250px; height: 70px;
 padding-left: 60px;
}

.mainheader nav{
 width: 450px;
 display: flex;
 justify-content: space-around;
 align-items: center;
}

.mainheader nav a{
 text-decoration: none;
 color: black;
 text-transform: uppercase;
}

.menubtn{
 margin-right: 60px;
}
.mainheader button{
 padding: 10px 45px;
 text-align: center;
 font-size: 14px;
 color: #fff;
 border: none;
 background-image: linear-gradient(to right,#649bff,#0070fa,#649bff);
 border-radius: 10px;
}


main{
 width: 100%;
 display: flex;
 justify-content: space-between;
 align-items: center;
}

main .right-sec1{
 padding-right: 70px;
}

main .left-sec1{
 padding-left: 100px;
}

.left-sec1 h2{
 font-size: 20px;
 text-transform: capitalize;
 font-weight: lighter;
 color: #242424;
 margin-top: 100px;
}

.left-sec1 h1{
 font-size: 55px;
 text-transform: capitalize;
 font-weight: 700;
 margin: 15px 0;
}

.left-sec1 p{
 margin-bottom: 20px;
}

.left-sec1 button{
 padding: 15px 45px;
 text-align: center;
 font-size: 14px;
 color: #fff;
 border: none;
 background-image: linear-gradient(to right,#649bff,#0070fa,#649bff);
 border-radius: 10px;
}</style>
<header>
<nav>
     <div class="sidebar-button">
        <i class='bx bx-menu sidebarBtn'></i>
        <span class="dashboard">Dashboard</span>
      </div>
      <div class="search-box">
        <input type="text" placeholder="Search...">
        <i class='bx bx-search' ></i>
      </div>
      <div class="profile-details">
        <!--<img src="images/profile.jpg" alt="">-->
        <span class="admin_name">Prem Shahi</span>
        <i class='bx bx-chevron-down' ></i>
      </div>
    </nav>

    <div class="home-content">
 <div class="mainheader1">
  
<div class="overview-boxes">
       <div class="box">
          <div class="right-side">
            <div class="box-topic">Total Doctors</div>
            <% String query = "select count(*) from specialists";
            Statement ps=con.createStatement();
            ResultSet i = ps.executeQuery(query);
		   String Countrow="";
				while(i.next()){
				
				

				
            %>
            <div class="number"><%=  Countrow = i.getString(1) %></div>
            <% } %>
            
          </div>
          <i class="fas fa-user-nurse"></i>
        </div>
        <div class="box">
          <div class="right-side">
            <div class="box-topic">Total Products</div>
                <% String query1 = "select count(*) from products";
            Statement s=con.createStatement();
            ResultSet j = s.executeQuery(query1);
		   String Countrow1="";
				while(j.next()){
				
				

				
            %>
            <div class="number"><%=  Countrow1 = j.getString(1) %></div>
             <% } %>
            
          </div>
          <i class="fas fa-capsules"></i>
        </div>
        <div class="box">
          <div class="right-side">
            <div class="box-topic">Current Date</div>
            <%! Date dNow = new Date( ); 
             
            final static String DATE_FORMAT_NOW = "dd/MM/yy";  
            SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT_NOW);
            String date_print = df.format(dNow);
            %>
            <div class="number"><%= date_print %> </div>
            
          </div>
          
        </div>
        <div class="box">
          <div class="right-side">
            <div class="box-topic">Current Time</div>
            <%! Date tNow = new Date( ); 
             
            final static String TIME_FORMAT_NOW = "hh:mm:ss";  
            SimpleDateFormat df1 = new SimpleDateFormat(TIME_FORMAT_NOW);
            String time = df1.format(dNow);
            %>
            <div class="number"><%= time %></div>
           
          </div>
         
        </div>
      </div>


</div>
 <main>
  <section class="left-sec1">
   <h2> We Are Here For Your Care</h2>
   <h1>  We The Best Doctors</h1>
   <p>We are here for your care 24/7. Any help just call us.</p>
   <button>
    Contact Us
   </button>
  </section>

  <section class="right-sec1">
   <figure>
    <img src="mainbg.png">
   </figure>
  </section>
 </main>
</header>
</body>
</html>

 
     </div>
  </section>

  <script>
   let sidebar = document.querySelector(".sidebar");
let sidebarBtn = document.querySelector(".sidebarBtn");
sidebarBtn.onclick = function() {
  sidebar.classList.toggle("active");
  if(sidebar.classList.contains("active")){
  sidebarBtn.classList.replace("bx-menu" ,"bx-menu-alt-right");
}else
  sidebarBtn.classList.replace("bx-menu-alt-right", "bx-menu");
}
 </script>

</body>
</html>
