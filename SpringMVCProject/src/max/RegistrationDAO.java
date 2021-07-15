package max;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegistrationDAO {
  @Autowired
	SessionFactory sessionFactory;
	public boolean insertData(RegistrationDTO registrationDTO)
	{  System.out.println("in dao");
		
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		 Integer t = (Integer) s.save(registrationDTO);
		 tx.commit();
		 if(t>0)
		return true;
		 else
			 return false;
		
	}
	
	
	public List<RegistrationDTO> fatch()
	{  
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		Criteria cr = s.createCriteria(RegistrationDTO.class);
		List<RegistrationDTO> list = cr.list();
		 tx.commit();
		 return list;
		
	}
}
           