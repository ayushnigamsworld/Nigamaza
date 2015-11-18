package shoppingservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CartServlet() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		if(session!=null)
		{
			String[] watches=(String[])session.getAttribute("watches");
			String cars[]=(String[])session.getAttribute("cars");
			String mobiles[]=(String[])session.getAttribute("mobiles");
			String laptops[]=(String[])session.getAttribute("laptops");
			String men[]=(String[])session.getAttribute("men");
			String women[]=(String[])session.getAttribute("women");
			out.println("<html><body>");
			out.println("<table bgcolor='yellow' border=1 width=400>");
			if(mobiles!=null)
			{
				out.println("<tr>");
				for(int m=0;m<mobiles.length;m++)
				{
					out.println("<td>"+mobiles[m]+"</td>");
					out.println("</tr>");
				}		
			}
			if(laptops!=null)
			{
				out.println("<tr>");
				for(int m=0;m<laptops.length;m++)
				{
					out.println("<td>"+laptops[m]+"</td>");
					out.println("</tr>");
				}		
			}
			if(cars!=null)
			{
				out.println("<tr>");
				for(int m=0;m<cars.length;m++)
				{
					out.println("<td>"+cars[m]+"</td>");
					out.println("</tr>");
				}		
			}
			if(watches!=null)
			{
				out.println("<tr>");
				for(int m=0;m<watches.length;m++)
				{
					out.println("<td>"+watches[m]+"</td>");
					out.println("</tr>");
				}		
			}
			if(men!=null)
			{
				out.println("<tr>");
				for(int m=0;m<men.length;m++)
				{
					out.println("<td>"+men[m]+"</td>");
					out.println("</tr>");
				}		
			}
			if(women!=null)
			{
				out.println("<tr>");
				for(int m=0;m<women.length;m++)
				{
					out.println("<td>"+women[m]+"</td>");
					out.println("</tr>");
				}		
			}
			out.println("/table");
			out.println("<br><br><a href='netbank.html' <input type='submit' value='Buy Now'/> </a>");
			out.println("<br><br><a href='welcome.html' <input type='submit' value='Back'/> </a>");
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("/index.html");
			rd.forward(request,response);
		}
	}
}