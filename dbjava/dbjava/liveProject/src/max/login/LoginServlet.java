package max.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import max.login.bo.UserOTP;
import max.login.dl.DistBean;
import max.login.dl.LocationDAO;
import max.login.dl.StateBean;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter out = response.getWriter();
    	String uid = request.getParameter("uid");
    	String pass = request.getParameter("pass");
    	String mobile = request.getParameter("mobile");
    	String otp = request.getParameter("otp1")+request.getParameter("otp2")+request.getParameter("otp3")+request.getParameter("otp4");
    	UserOTP userOTP=new UserOTP();
    	String st = userOTP.setLoginDeatils(uid, pass, mobile, otp);
    	if(st.equalsIgnoreCase(uid))
    	{
    		HttpSession s = request.getSession();
    		s.setAttribute("uid", uid);
    		StateBean sb = LocationDAO.getStateDetails(uid.substring(0, 2));
    		request.setAttribute("stName", sb.getStateName());
    		request.setAttribute("stCode", sb.getStateCode());
    		
    		List<DistBean> list = LocationDAO.getDistDetails(sb.getStateCode());
    		request.setAttribute("lst", list);
    		request.getRequestDispatcher("W.jsp").forward(request, response);
    	}
    	else if(st.equalsIgnoreCase("L"))
    	{
    		out.println("User Locked PLZ contract Admin !");
    		request.getRequestDispatcher("login.jsp").include(request, response);
    		   	
    	}
    	else if(st.equalsIgnoreCase("AL"))
    	{
    		out.println("User Already login PLZ contract Admin !");
    		request.getRequestDispatcher("login.jsp").include(request, response);
    			
    	}
    	else if(st.equalsIgnoreCase("W"))
    	{
    		out.println("Wrong User ID and Pass");
    		request.getRequestDispatcher("login.jsp").include(request, response);
    		
    	}
    	else if(st.equalsIgnoreCase("WP"))
    	{
    		
    		out.println("Wrong Pass ");
    			request.getRequestDispatcher("login.jsp").include(request, response);
    		
    	}
    	
    	
    }

}
