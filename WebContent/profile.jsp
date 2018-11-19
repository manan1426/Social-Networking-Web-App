<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    
<!DOCTYPE>
<html>
<head>
<meta charset="ISO-8859-1">
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Poodle</title>
    <link rel="stylesheet" type="text/css" href="poodle.css">

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

  <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

  <link href="https://fonts.googleapis.com/css?family=Righteous" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Marmelad" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Merriweather:900i" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Paytone+One" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Gochi+Hand" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Monoton" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Acme|Monoton" rel="stylesheet">
  


</head>
<body>
    
  <nav class="navbar fixed-top navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#"> Poodle   <i class="fas fa-paw"></a></i>
   <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
    </div>
</nav>

    <div class="container">
      <div class="jumbotron">
  <h1 class="display-4"><center><b>Poodle Portfolio!<i class="fas fa-paw"></i></b></center></h1>
  <h3 class="caption"><center>We capture your memories forever</center></h3>
</div>
<br>
<br>
<br>
     <div id="b" class="col-lg-12 col-md-12 col-sm-4 ">
    <div id="s" class="col-lg-12 col-md-12 col-sm-12 bottomDiv">
     </div>
    <center>
    <%String name=session.getAttribute("H").toString();
    String u=name;%>
     <h1 id="head">Hii!<br> <%=name.substring(0,13) %></h1>
     <h5 id="tail">Welcome to the beautiful world of Poodle!</h5>
    </center> 
</div>

<br>

<hr class="h">
<hr class="hb">
<br>
<div class="xyz">
  <br>
  <br>
  <div class="row ">
  <%
            try {String username;
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/poodle", "root", "");
                Statement st = con.createStatement();
                String sql = "SELECT userdetails.username,image_table.filename,image_table.path FROM userdetails, image_table WHERE userdetails.username=usernamee";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                	username=rs.getString("username");
                    String filename = rs.getString("filename");
                    String path = rs.getString("path");
        %>
        <%if(username.equals(u)){ %>
  <div class="col-lg-4 col-md-6 col-sm-12 row-eq-height">
   

      <image class="img-thumbnail" src="<%=filename%>" /><%}else{ %>
 <div >
   

      <image  src="" /><%} %>

</div>
<%
                }
            } catch (Exception e) {
                out.println(e);
            }
        %>
<br>
<br>
</div>
<br>
<br>
<br>
<div class="footer col-lg-12 col-md-12 col-sm-12-">
  <i class="fas fa-paw a">
            <h1><b>Poodle</b></h1>
          </i>
            <div class="box1">
                <br>
        <h6>BackEnd Developer- Manan Mehta|FrontEnd Developer- Mudita Vohra </h6>
        <h6>&copy; for more info contact- <i class="fa fa-phone">  8930851331|9910233640 </i></h6>
          </div>  
        </div>





<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</body>
</html>