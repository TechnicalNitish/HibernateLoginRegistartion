package reglogin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RegLoginMain {

	public static void main(String[] args) {
		
		SessionFactory sf=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session=sf.openSession();
		Transaction ts=session.beginTransaction();
		User user=new User();
			user.setUserid("101");
			user.setName("Nitish");
			user.setAddress("pune");
			user.setEmail("nk@gmail.com");
			user.setMobile("89282921");
			user.setPassword("hello");
			
			session.save(user);
			ts.commit();
			session.close();
		
		
		
	}

}
