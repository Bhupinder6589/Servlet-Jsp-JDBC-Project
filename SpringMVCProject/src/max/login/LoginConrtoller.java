package max.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class LoginConrtoller {
	
@RequestMapping(value="login.do" , method=RequestMethod.GET)
	public ModelAndView registration()
	{
	 return new ModelAndView("A","l",null);
	}
}
