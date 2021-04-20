package max.shgregistration;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SHGsDetailServlet")
public class SHGDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter out = response.getWriter();
    	SHGMemberData sHGMemberData=new SHGMemberData();
    	SHGBean shgmemdetail = sHGMemberData.setSHGMemeberDetail(request);
    	SHGMemberBO sHGMemberBO=new SHGMemberBO();
    	if(sHGMemberBO.getShgMemberDetails(shgmemdetail))
    	{
    		out.println("successs full ");
    	}
    	else
    	{
    		out.println("unsuccesss full ");
    	}
	}

}
