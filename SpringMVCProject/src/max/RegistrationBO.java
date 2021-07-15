package max;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationBO {
	@Autowired
	RegistrationDAO registrationDAO;
	@Autowired
	RegistrationDTO registrationDTO;
	public boolean getResistration(RegistrationBean registrationBean)
	{
		BeanUtils.copyProperties(registrationBean, registrationDTO);
		return registrationDAO.insertData(registrationDTO);
		
	}
	
	public List<RegistrationDTO> fatchRecords()
	{
		return registrationDAO.fatch();
	}
	
}
