package p1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class B
 */
@WebServlet("/B")
public class B extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public B() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
				"    <input name=\"t3\" type=\"password\"  class=\"form-control\" id=\"exampleInputPassword2\" placeholder=\"Confirm Password\">\r\n" + 
				"    \r\n" + 
				"  </div>\r\n" + 
				"  \r\n" + 
				" <button type=\"submit\" class=\"btn btn-primary\">Submit!</button>\r\n" + 
				"</form>\r\n" + 
				"</div>\r\n" + 
				"</body>\r\n" + 
				"</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
