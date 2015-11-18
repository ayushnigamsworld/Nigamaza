package shoppingservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		   response.setContentType("text/html");
		   PrintWriter out=response.getWriter();
		   out.println("<html><body>");
		   HttpSession session=request.getSession(false);
		   
		   
		   
		   System.out.println("I am logout servlet   1 ");
		   String userId=(String)session.getAttribute("userId");
			String pass=(String)session.getAttribute("pass");
			System.out.println("userid in logout is "+userId);
			System.out.println("pass in logout is "+pass);
			System.out.println("I am logout servlet   2 ");
			try
			{
				System.out.println("I am logout servlet   3 ");
			Connection c=ConnectionProvider.getConn();
			Statement s=c.createStatement();
			System.out.println("I am logout servlet   4 ");
			s.executeUpdate("update cust set status='F' where userId='"+userId+"' and pass='"+pass+"'");
			System.out.println("I am logout servlet   5 ");
			}
			catch(Exception e){System.out.println("I am logout error "+e);}
			
		   
			out.println("</body></html>");
			
			
			
			
		   if(session!=null)
		   {
			  session.invalidate();
		   }
		   //RequestDispatcher rd=request.getRequestDispatcher("/index.html");
		   
		   
		   
		   
		   
		   RequestDispatcher rd=request.getRequestDispatcher("/index.html");
		   rd.forward(request, response);
		   
	}

}
