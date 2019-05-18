package reglogin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class registrationservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public registrationservlet() {
        super();
        
    }

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("fullname");
		String email=request.getParameter("email");
		String userid=request.getParameter("username");
		String mobile=request.getParameter("contact");
		String address=request.getParameter("address");
		String password=request.getParameter("password");
		
		
		SessionFactory sf=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		
					User user=new User();
					user.setUserid(userid);
					user.setName(name);
					user.setAddress(address);
					user.setEmail(email);
					user.setMobile(mobile);
					user.setPassword(password);
					
			session.save(user);
			
			out.write("You are Successfully Registered");
			tx.commit();
			session.close();
					
	}




}
