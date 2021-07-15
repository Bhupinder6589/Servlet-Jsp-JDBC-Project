package max.location;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class LocationDAO {
	 @Autowired
	SessionFactory sessionFactory;
	
	public List<State> getStateDetails()
	{
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		Criteria cr = s.createCriteria(State.class);
		List<State> list = cr.list();
		tx.commit();
		return list;
		
		
	}
	
	
	public List<DistBean> getDistDetails(String stateCode)
	{
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		Criteria cr = s.createCriteria(DistBean.class);
		  cr.add(Restrictions.eq("stateCode", stateCode));
		List<DistBean> list = cr.list();
		System.out.println(list.size());
		tx.commit();
		return list;
		
		
	}

}
