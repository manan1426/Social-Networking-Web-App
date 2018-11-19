package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class A
 */
@WebServlet("/A")
public class A extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("t1");
		String pass = request.getParameter("t2");
		String s1="Hello",s2;
		boolean b=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/poodle", "root", "");
			System.out.println("Connection Establish");
			PreparedStatement pt=con.prepareStatement("select * from userdetails where username=?");
			pt.setString(1, email);
			ResultSet rs=pt.executeQuery();
			if(rs.next())
			{
				s1=rs.getString("username");
				s2=rs.getString("password");
				if(s1.equals(email)&&s2.equals(pass))
				{
					b=true;
					
				}
					
			}
			rs.close();
			pt.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException r) {
			// TODO Auto-generated catch block
			r.printStackTrace();
		}
		if(b==true) {
			HttpSession session=request.getSession();
			session.setAttribute("H",s1);
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("<!DOCTYPE>\r\n" + 
					"<html>\r\n" + 
					"<head>\r\n" + 
					"	<title>Sign Up</title>\r\n" + 
					"	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
					"\r\n" + 
					"	<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\r\n" + 
					"	<link rel=\"stylesheet\" type=\"text/css\" href=\"content.css\">\r\n" + 
					"\r\n" + 
					"	<link href=\"https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\" rel=\"stylesheet\" integrity=\"sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN\" crossorigin=\"anonymous\">\r\n" + 
					"	<link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.3.1/css/all.css\" integrity=\"sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU\" crossorigin=\"anonymous\">\r\n" + 
					"\r\n" + 
					"	<link href=\"https://fonts.googleapis.com/css?family=Fredericka+the+Great\" rel=\"stylesheet\">\r\n" + 
					"	<link href=\"https://fonts.googleapis.com/css?family=Righteous\" rel=\"stylesheet\">\r\n" + 
					"	<link href=\"https://fonts.googleapis.com/css?family=Marmelad\" rel=\"stylesheet\">\r\n" + 
					"	<link href=\"https://fonts.googleapis.com/css?family=Merriweather:900i\" rel=\"stylesheet\">\r\n" + 
					"	<link href=\"https://fonts.googleapis.com/css?family=Merriweather:900i\" rel=\"stylesheet\">\r\n" + 
					"	\r\n" + 
					"	<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"	\r\n" + 
					"<nav class=\"navbar fixed-top navbar-expand-lg navbar-light bg-light\">\r\n" + 
					"        <a class=\"navbar-brand\" href=\"#\"> Poodle   <i class=\"fas fa-paw\"></a></i>\r\n" + 
					" 	 <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n" + 
					"    		<span class=\"navbar-toggler-icon\"></span>\r\n" + 
					"  	</button>\r\n" + 
					"  	<div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n" + 
					"    	<ul class=\"navbar-nav mr-auto\">\r\n" + 
					"    		<form class=\"form-inline\">\r\n" + 
					"                <script>\r\n" + 
					"  (function() {\r\n" + 
					"    var cx = '003407735805326339297:juxipvnfjjk';\r\n" + 
					"    var gcse = document.createElement('script');\r\n" + 
					"    gcse.type = 'text/javascript';\r\n" + 
					"    gcse.async = true;\r\n" + 
					"    gcse.src = 'https://cse.google.com/cse.js?cx=' + cx;\r\n" + 
					"    var s = document.getElementsByTagName('script')[0];\r\n" + 
					"    s.parentNode.insertBefore(gcse, s);\r\n" + 
					"  })();\r\n" + 
					"</script>\r\n" + 
					"<gcse:search></gcse:search>"+ 
					"            </form>\r\n" + 
					"        </ul>\r\n" + 
					"            <ul class=\"navbar-nav ml-auto\">\r\n" + 
					"    		<li class=\"nav-item active\">\r\n" + 
					"    			<form action=\"profile.jsp\" method=\"post\"><button type=\"submit\" class=\"btn btn-default \">My Profile <i class=\"fas fa-user-circle\"></i></button></form>\r\n" + 
					"    		</li>\r\n" + 
					"			<form action=\"./index.html\" ><button type=\"submit\" class=\"btn btn-default l\">  Logout <i class=\"fas fa-angle-double-right\"></i></button></form>\r\n" + 
					"    	</ul>\r\n" + 
					"  	</div>\r\n" + 
					"</nav>\r\n" + 
					"<div class=\"jumbotron\">\r\n" + 
					"  <h1 class=\"display-4\"><center><b>Welcome to the world of poodle!<i class=\"fas fa-paw\"></i></b></center></h1>\r\n" + 
					"</div>\r\n" + 
					"	\r\n" + 
					"<center>\r\n" + 
					"\r\n" + 
					"<div id=\"container\">\r\n" + 
					"<div id=\"sliderbox\">\r\n" + 
					"		\r\n" + 
					"		<img id=\"z\" src=\"https://i.pinimg.com/564x/db/c1/d3/dbc1d32149428c51f80f9f600a5c396a.jpg\">\r\n" + 
					"		<img  id=\"z\" src=\"https://i.pinimg.com/564x/a8/5a/f6/a85af6edb617b51a3ea66aee1242577a.jpg\">\r\n" + 
					"		<img id=\"z\" src=\"https://i.pinimg.com/564x/4b/58/10/4b5810dbf71dc2c14ec0d81acfa4b376.jpg\">\r\n" + 
					"		<img id=\"z\" src=\"https://i.pinimg.com/564x/f4/5b/d0/f45bd0dfca7c2f7037a7b80456ee8c80.jpg\">\r\n" + 
					"		<img id=\"z\" src=\"https://i.pinimg.com/564x/3c/86/e9/3c86e95fb2a6870a6c2441da497b477e.jpg\">\r\n" + 
					"	</center>\r\n" + 
					"	</div>\r\n" + 
					"</div>\r\n" + 
					"<div>\r\n" + 
					"<h1 id=\"head\"><center><b><em>#Trending Tags</em></b></center></h1>\r\n" + 
					"<div class=\"polaroids\">\r\n" + 
					"    \r\n" + 
					"    <div class=\"polaroid\">\r\n" + 
					"      <img src=\"https://i.pinimg.com/564x/04/e0/52/04e0524d891999c1c435c1b1a707da5e.jpg\">\r\n" + 
					"      <p>#fooddle</p>\r\n" + 
					"    </div>\r\n" + 
					"    \r\n" + 
					"    <div class=\"polaroid\">\r\n" + 
					"      <img src=\"https://i.pinimg.com/564x/58/0c/a5/580ca5b5b0079cea9385e1e015b2a333.jpg\">\r\n" + 
					"      <p>#dressdbest</p>\r\n" + 
					"    </div>\r\n" + 
					"    <div class=\"polaroid\">\r\n" + 
					"      <img src=\"https://i.pinimg.com/564x/d4/70/d0/d470d00a28b559d1eff890d67e209f98.jpg\">\r\n" + 
					"      <p>#serenity</p>\r\n" + 
					"    </div>\r\n" + 
					"    <div class=\"polaroid\">\r\n" + 
					"      <img src=\"https://i.pinimg.com/564x/20/31/e8/2031e862be0a546a591008099e090ed4.jpg\">\r\n" + 
					"      <p>#lovemelikeudo</p>\r\n" + 
					"    </div>\r\n" + 
					"\r\n" + 
					"  </div>\r\n" + 
					"</div>\r\n" + 
					"<br>\r\n" + 
					"<form action=\"open.jsp\" method=\"get\">\r\n" + 
					"<div class=\"images\">\r\n" + 
					"	<center>\r\n" + 
					"		<br>\r\n" + 
					"		<button class=\"btn btn-default w3-button w3-teal ab\">Add Photos <i class=\"far fa-images\"></i></button>\r\n" + 
					"	</center>\r\n" + 
					"</div>\r\n" + 
					"</form>\r\n" + 
					"<br>\r\n" + 
					"<center>\r\n" + 
					"<hr class=\"h\">\r\n" + 
					"<hr class=\"hb\">\r\n" + 
					"</center>\r\n" + 
					"<br>\r\n" + 
					"<br>\r\n" + 
					"<br>\r\n" + 
					"<div class=\"xyz\">\r\n" + 
					"<center>\r\n" + 
					"	<br>\r\n" + 
					"<h2><b>Live Love Laugh!</b></h2>\r\n" + 
					"    <p> Live today with joy. Don't wait for tomorrow. Tomorrow may never come ~Debasish Mridha M.D</p>\r\n" + 
					"  <br>\r\n" + 
					"  <br>\r\n" + 
					"  <br>\r\n" + 
					"</center>\r\n" + 
					"</div>\r\n" + 
					"\r\n" + 
					"<div class=\"footer\">\r\n" + 
					"  <i class=\"fas fa-paw a\">\r\n" + 
					"            <h1><b>Poodle</b></h1>\r\n" + 
					"          </i>\r\n" + 
					"            <div class=\"box1\">\r\n" + 
					"                <br>\r\n" + 
					"        <h6>BackEnd Developer- Manan Mehta|FrontEnd Developer- Mudita Vohra </h6>\r\n" + 
					"        <h6>&copy; for more info contact- <i class=\"fa fa-phone\">  8930851331|9910233640 </i></h6>\r\n" + 
					"          </div>  \r\n" + 
					"        </div>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\r\n" + 
					"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\" integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\" crossorigin=\"anonymous\"></script>\r\n" + 
					"<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\" integrity=\"sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy\" crossorigin=\"anonymous\"></script>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"</body>\r\n" + 
					"</html>\r\n" + 
					"");
		}
		else
		{
			
			RequestDispatcher rd=request.getRequestDispatcher("/index.html");
			rd.include(request, response);
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
