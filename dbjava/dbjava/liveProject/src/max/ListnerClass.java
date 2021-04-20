package max;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import max.login.dl.UserDAO;

public class ListnerClass implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent sd) {
		
		HttpSession s = sd.getSession();
		String uid=(String)s.getAttribute("uid");
		UserDAO userDAO=new UserDAO();
		System.out.println("-------hi----");
		userDAO.logout(uid);
	}
}
