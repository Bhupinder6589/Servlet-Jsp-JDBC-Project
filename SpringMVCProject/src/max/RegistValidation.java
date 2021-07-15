package max;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class RegistValidation implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object r, Errors e) {
		
		 RegistrationBean rb = (RegistrationBean)r;
		 if(rb.getMobile().length()!=10)
		 {
			 e.rejectValue("mobile", "rgt.mobile");
		 }
		 if(rb.getUname().length()<3)
		 {
			 
			 e.rejectValue("uname", "r.uname");
		 }
	}

}
