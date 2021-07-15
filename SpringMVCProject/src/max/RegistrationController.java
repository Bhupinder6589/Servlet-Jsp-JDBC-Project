package max;



import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import max.location.DistBean;
import max.location.LocationDAO;
import max.location.State;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {
	@Autowired
	RegistrationBean registrationBean;
	@Autowired
	RegistrationBO registrationBO;
	@Autowired
	RegistValidation registValidation;
	@Autowired
	LocationDAO locationDAO;
	@Autowired
	State state;

	@RequestMapping(value="regist" , method=RequestMethod.GET)
	public ModelAndView registration()
	{
		
	 return new ModelAndView("Regist","rgt",registrationBean);
	}
	@ModelAttribute("stateList")
	public List<State> getStateDetails(Model m)
	{
		  List<State> list = locationDAO.getStateDetails();
		  System.out.println("stlist "+list.size());
		 	
		  return list;
	}
	
	
	
	
@RequestMapping(value="registSub" , method=RequestMethod.POST)

public String registData(@ModelAttribute("rgt")RegistrationBean registrationBean,BindingResult br)
{
	
	System.out.println("in c");
	if(br.hasErrors())
	{
		return "Regist";
	}
	
	registrationBO.getResistration(registrationBean);
	
	return "S";
	
}

@RequestMapping(value="view", method=RequestMethod.GET)
public ModelAndView fatchRecords(ModelMap map)
{
	List<RegistrationDTO> list = registrationBO.fatchRecords();
	System.out.println("lst "+list.size());
	//map.addAttribute("lst", list);
	
	return new ModelAndView("View","lst",list);
	
	
	
	
}
@RequestMapping(value="dist", method=RequestMethod.GET)
public @ResponseBody String getDist(@RequestParam("stCode")String stateCode) throws JsonGenerationException, JsonMappingException, IOException
{ System.out.println("om "+stateCode);
	 List<DistBean> lst = locationDAO.getDistDetails(stateCode);
	   System.out.println("in");
	ObjectMapper m = new ObjectMapper();
	 String str = m.writeValueAsString(lst);
	   
	 System.out.println("con "+str);
	return str;
}

	
	
}
