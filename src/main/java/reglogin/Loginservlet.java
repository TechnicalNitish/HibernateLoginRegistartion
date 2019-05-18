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


public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 PrintWriter out=response.getWriter();
		
		String userid=request.getParameter("uname");
		String password=request.getParameter("pass");
		
		SessionFactory sf=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session =sf.openSession();
		Transaction tx=session.beginTransaction();
		
		User user=new User();
		
		user=session.get(User.class, userid);
		if(password.equals(user.getPassword())) {
			out.write("You Are Login Now");
			
		}
		else {
			out.write("userid and password is incorrect : Or Register First");
		}
		
		
		
		
		
		
		
	}

}
