package shoppingservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName="RegisterFilter",urlPatterns={"/register"})
public class RegisterFilter implements Filter {

	FilterConfig config;
	public void destroy() 
	{		
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		PrintWriter out=response.getWriter();
		String userId=request.getParameter("userId");
		String pass=request.getParameter("pass");
		String repass=request.getParameter("repass");
		if(pass.equals(repass))
		{
			out.println("i am register filter   1  ");
			ServletContext ctx=config.getServletContext();
		try
		{
			out.println("i am register filter    2  ");
			//Connection c=(Connection)ctx.getAttribute("con");
			Connection c=ConnectionProvider.getConn();
			Statement s=c.createStatement();
			out.println("i am register filter    3  ");
			ResultSet rs=s.executeQuery("select * from cust where userId='"+userId+"' and pass='"+pass+"'");
			out.println("i am register filter    4  ");
			if(rs.next())
			{
				out.println("i am register filter   5  ");
				chain.doFilter(request, response);
				out.println("i am register filter   6  ");
			}
			else
			{
				out.println("i am register filter    7  ");
				int x=s.executeUpdate("insert into cust values('"+userId+"','"+pass+"','F')");
				out.println("<html><body><br><h1>Registered Successfully!! Login now </h1>");
				out.println("<br><h2>Login page Reloading</h2></body></html>");
				HttpServletResponse rss=(HttpServletResponse)response;
				rss.setHeader("Refresh", "4;index.html");
				out.println("i am register filter   8  ");
				//RequestDispatcher rd=request.getRequestDispatcher("/registered");
				//rd.forward(request,response);
			}
			out.println("i am register filter   9  ");
		}
		catch(Exception e){out.print(e);}
		}
		else
		{
			out.println("i am register filter   10  ");
			out.println("<html><body><br><h1>Password and Rentered Password rematch!! Try Again</h1>");
			out.println("<br><h2>Registered Page Reloading</h1></body></html>");
			HttpServletResponse rss=(HttpServletResponse)response;
			rss.setHeader("Refresh", "4;register.html");
		}	
	}
	public void init(FilterConfig config) throws ServletException 
	{
		this.config=config;
	}

}
