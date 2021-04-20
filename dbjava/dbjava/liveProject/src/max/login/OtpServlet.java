package max.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import max.login.bo.UserOTP;

/**
 * Servlet implementation class OtpServlet
 */
@WebServlet("/OtpServlet")
public class OtpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	   UserOTP userOTP=new UserOTP();
    	   String mob = request.getParameter("mobile");
    	   String otp = userOTP.generateOTP(mob);
    	  PrintWriter out = response.getWriter();
    	  out.println(otp);
	}

}
