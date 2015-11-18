package shoppingservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bank")
public class NetBankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public NetBankServlet() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		String cardno=request.getParameter("cardno");
		String bankname=request.getParameter("bankname");
		String name=request.getParameter("name");
		ServletContext ctx=getServletContext();
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		try
		{
			Connection c=(Connection)ctx.getAttribute("con");
			Statement s=c.createStatement();
			ResultSet rs=s.executeQuery("select * from bank where cardno='"+cardno+"'and name='"+name+"'");
			if(rs.next())
			{
				out.println("Matched");
				out.println("Thanks for buying.. Happy Shopping!!!");
				out.println("Payment Completed");
				response.setHeader("Refresh","4;welcome.html");
			}
			else
			{
				out.println("Invalid Details!!");
			}
			response.setHeader("Refresh","3,netbank.html");
		}
		catch(Exception e)
		{
			out.println(e);
		}
		out.println("</body></html>");
	}
}
