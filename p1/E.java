package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class E
 */
@WebServlet("/E")
public class E extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public E() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s1=request.getParameter("t1");
		String s2=request.getParameter("t2");
		String s3=request.getParameter("t4"); 
		
		HttpSession session=request.getSession(false);
		String Otp=session.getAttribute("OTP").toString();
		String email=(String)session.getAttribute("email");
		String pass=(String)session.getAttribute("pass");
		if(s1.equals(email) && s2.equals(pass)) {
		if(s3.equals(Otp)) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/poodle", "root", "");
				System.out.println("Connection Establish");
				PreparedStatement pt=con.prepareStatement("insert into userdetails values(?,?)");
				pt.setString(1,request.getParameter("t1"));
				pt.setString(2,request.getParameter("t2"));
			    pt.executeUpdate();
				pt.close();
				con.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException r) {
				// TODO Auto-generated catch block
				r.printStackTrace();
			}
			session.invalidate();
				
			
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"<head>\r\n" + 
					"<title>Sign Up</title>\r\n" + 
					"	 <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
					"         <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3pro.css\">\r\n" + 
					"	 <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\r\n" + 
					"	 <link href=\"https://fonts.googleapis.com/css?family=Courgette\" rel=\"stylesheet\">\r\n" + 
					"\r\n" + 
					"	 <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.3.1/css/all.css\" integrity=\"sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU\" crossorigin=\"anonymous\">\r\n" + 
					"\r\n" + 
					"         <link rel=\"stylesheet\" type=\"text/css\" href=\"signUpStyle.css\">\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"</head>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"<body>\r\n" + 
					"<form action=\"./nextfour\" method=\"post\"><button type=\"submit\" id=\"a\" class=\"btn btn-primary \"> Next >> </button></form>\r\n" + 
					"\r\n" + 
					"	<div class=\"container\">\r\n" + 
					"	<form class=\"boxed\">\r\n" + 
					"		<h2>  Poodle <i class=\"fas fa-paw a\"> </h2></i>\r\n" + 
					"		<h4>Poodle account Generated Successfully!</h4>\r\n" + 
					"		<h4>Go to HomePage for Login.</h4>\r\n" + 
					"\r\n" + 
					"</form>\r\n" + 
					"</div>\r\n" + 
					"</body>\r\n" + 
					"</html>");
		}
		else {response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"<head>\r\n" + 
					"<title>Sign Up</title>\r\n" + 
					"	 <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
					"         <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3pro.css\">\r\n" + 
					"	 <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\r\n" + 
					"	 <link href=\"https://fonts.googleapis.com/css?family=Courgette\" rel=\"stylesheet\">\r\n" + 
					"\r\n" + 
					"	 <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.3.1/css/all.css\" integrity=\"sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU\" crossorigin=\"anonymous\">\r\n" + 
					"\r\n" + 
					"         <link rel=\"stylesheet\" type=\"text/css\" href=\"signUpStyle.css\">\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"</head>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"<body>\r\n" + 
					"<form action=\"./nextfour\" method=\"post\"><button type=\"submit\" id=\"a\" class=\"btn btn-primary \"> Next >> </button></form>\r\n" + 
					"\r\n" + 
					"	<div class=\"container\">\r\n" + 
					"	<form class=\"boxed\">\r\n" + 
					"		<h2>  Poodle <i class=\"fas fa-paw a\"> </h2></i>\r\n" + 
					"		<h4>Poodle account not Generated,as OTP doesnt match!</h4>\r\n" + 
					"		<h4>Go to HomePage for SignUp.</h4>\r\n" + 
					"\r\n" + 
					"</form>\r\n" + 
					"</div>\r\n" + 
					"</body>\r\n" + 
					"</html>");
		}}else {response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"<head>\r\n" + 
					"<title>Sign Up</title>\r\n" + 
					"	 <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
					"         <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3pro.css\">\r\n" + 
					"	 <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\r\n" + 
					"	 <link href=\"https://fonts.googleapis.com/css?family=Courgette\" rel=\"stylesheet\">\r\n" + 
					"\r\n" + 
					"	 <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.3.1/css/all.css\" integrity=\"sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU\" crossorigin=\"anonymous\">\r\n" + 
					"\r\n" + 
					"         <link rel=\"stylesheet\" type=\"text/css\" href=\"signUpStyle.css\">\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"</head>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"<body>\r\n" + 
					"<form action=\"./nextfour\" method=\"post\"><button type=\"submit\" id=\"a\" class=\"btn btn-primary \"> Next >> </button></form>\r\n" + 
					"\r\n" + 
					"	<div class=\"container\">\r\n" + 
					"	<form class=\"boxed\">\r\n" + 
					"		<h2>  Poodle <i class=\"fas fa-paw a\"> </h2></i>\r\n" + 
					"		<h4>Poodle account not Generated as the email or password doesn't match!</h4>\r\n" + 
					"		<h4>Go to HomePage for SignUp.</h4>\r\n" + 
					"\r\n" + 
					"</form>\r\n" + 
					"</div>\r\n" + 
					"</body>\r\n" + 
					"</html>");
			
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
