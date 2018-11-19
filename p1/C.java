package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class C
 */
@WebServlet("/C")
public class C extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public C() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String s1=request.getParameter("t1");
			String s2=request.getParameter("t2");
			String s3=request.getParameter("t3");
			
			int d=40;
			if(s2.equals(s3))
			{
				HttpSession g=request.getSession();
				g.setAttribute("pass", s2);
				g.setAttribute("email", s1);
				int c=s2.length();
				int e=(d+c)*c;
				int f=e+8;
				int Otp=f;
				g.setAttribute("OTP",Otp);
				Properties props = new Properties();
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.port", "587");


				
				Session session =Session.getInstance(props, new javax.mail.Authenticator() 
				{
					@Override
					protected PasswordAuthentication getPasswordAuthentication()
					{
						return new PasswordAuthentication("poodleservices@gmail.com","mudman1426");
					}
				});
				try {
					MimeMessage message=new MimeMessage(session);
					message.setFrom(new InternetAddress("poodleservices@gmail.com"));
					message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(s1));
					message.setSubject("Otp-for getting started with Poodle.");
					message.setText("the Poodle OTP verification code is "+Otp+" .\n Regards: \n Team Poodle");
					Transport trans=session.getTransport("smtp");
					Transport.send(message);
					System.out.println("Mail sent");
				}
				catch(Exception t) {
					t.printStackTrace();
				}
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
						"<form action=\"./nextfour\" method=\"post\"><button type=\"submit\" id=\"a\" class=\"btn btn-primary \"> HomePage </button></form>\r\n" + 
						"\r\n" + 
						"	<div class=\"container\">\r\n" + 
						"	<form class=\"boxed\" action=\"./nextfive\" method=\"post\">\r\n" + 
						"		<h2>  Poodle <i class=\"fas fa-paw a\"> </h2></i>\r\n" + 
						"		<h4>Create your poodle account here! </h4>\r\n" + 
						"  <div class=\"form-group\">\r\n" + 
						"    <label for=\"exampleInputEmail1\">Email address </label>\r\n" + 
						"    <input name=\"t1\" type=\"email\" class=\"form-control\" id=\"exampleInputEmail1\" aria-describedby=\"emailHelp\" placeholder=\"enter email\">\r\n" + 
						"    <small id=\"emailHelp\" class=\"form-text text-muted\">The email addreses you provided us before</small>\r\n" + 
						"  </div>\r\n" + 
						"  <div class=\"form-group\">\r\n" + 
						"    <label for=\"exampleInputPassword1\"> Password  <i class=\"fas fa-key\"></label></i>\r\n" + 
						"    <input name=\"t2\" type=\"password\" class=\"form-control\" id=\"exampleInputPassword2\" placeholder=\"password\">\r\n" + 
						"     <small id=\"passwordHelp\" class=\"form-text text-muted\">The password you entered before</small>\r\n" + 
						"   <div class=\"form-group\">\r\n" + 
						"    <input  name=\"t4\" type=\"text\"  class=\"form-control\" id=\"exampleInputPassword2\" placeholder=\"enter OTP That is send to your mail\">\r\n" + 
						"  </div>\r\n" + 
						"  \r\n" + 
						" <button type=\"submit\" class=\"btn btn-primary\">Submit!</button>\r\n" + 
						"</form>\r\n" + 
						"</div>\r\n" + 
						"</body>\r\n" + 
						"</html>");
			}
			else
			{
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
						"<form action=\"./nextfour\" method=\"post\"><button type=\"submit\" id=\"a\" class=\"btn btn-primary \"> HomePage </button></form>\r\n" + 
						"\r\n" + 
						"	<div class=\"container\">\r\n" + 
						"	<form class=\"boxed\" action=\"./nextthree\" method=\"post\">\r\n" + 
						"		<h2>  Poodle <i class=\"fas fa-paw a\"> </h2></i>\r\n" + 
						"		<h4>Create your poodle account here! </h4>\r\n" + 
						"  <div class=\"form-group\">\r\n" + 
						"    <label for=\"exampleInputEmail1\">Email address </label>\r\n" + 
						"    <input name=\"t1\" type=\"email\" class=\"form-control\" id=\"exampleInputEmail1\" aria-describedby=\"emailHelp\" placeholder=\" email@example.com \">\r\n" + 
						"    <small id=\"emailHelp\" class=\"form-text text-muted\">We'll never share your email with anyone else.</small>\r\n" + 
						"  </div>\r\n" + 
						"  <div class=\"form-group\">\r\n" + 
						"    <label for=\"exampleInputPassword1\"> Password  <i class=\"fas fa-key\"></label></i>\r\n" + 
						"    <input name=\"t2\" type=\"password\" class=\"form-control\" id=\"exampleInputPassword2\" placeholder=\"Password\">\r\n" + 
						"     <small id=\"passwordHelp\" class=\"form-text text-muted\">To make your password strong use characters with a mix of letters, numbers & symbols</small>\r\n" + 
						"  </div>\r\n" + 
						"  <div class=\"form-group\">\r\n" + 
						"    <label for=\"exampleInputPassword2\"> Confirm Password <i class=\"fas fa-eye-slash\"></label></i>\r\n" + 
						"    <input name=\"t3\" type=\"password\"  class=\"form-control\" id=\"exampleInputPassword2\" placeholder=\"the above field doesn't match\">\r\n" + 
						"    \r\n" + 
						"  </div>\r\n" + 
						"  \r\n" + 
						" <button type=\"submit\" class=\"btn btn-primary\">Submit!</button>\r\n" + 
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
