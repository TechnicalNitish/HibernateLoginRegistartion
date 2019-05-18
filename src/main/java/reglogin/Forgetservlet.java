package reglogin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Forgetservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Object mobile;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			User user=new User();
			
			
		String userid=request.getParameter("username");
		String mobile=request.getParameter("mobile");
		System.out.println(userid);
		SessionFactory sf=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		HttpSession session1=request.getSession();
		session1.setAttribute("userid", userid);
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		
			user=session.get(User.class,userid);
				
				if(user.getUserid().equals(userid)&& (user.getMobile().equals(mobile)))
				{
					RequestDispatcher rd=request.getRequestDispatcher("reset.jsp");
							rd.forward(request, response);
					
					
				}
		
		
		
	}

}
