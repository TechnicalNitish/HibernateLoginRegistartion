package reglogin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class resetservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		String newpassword=request.getParameter("newpassword");
		String cpassword=request.getParameter("confirmpassword");
		HttpSession hsession=request.getSession();
		String userid=(String) hsession.getAttribute("userid");
		System.out.println(userid);
		SessionFactory sf=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session=sf.openSession();
		Transaction transaction=session.beginTransaction();
		
		User user=session.get(User.class, userid);
		
		user.setPassword(newpassword);
		session.save(user);
		transaction.commit();
		out.write("Password Changed Successfully");
		session.close();
		
		
	}

}
