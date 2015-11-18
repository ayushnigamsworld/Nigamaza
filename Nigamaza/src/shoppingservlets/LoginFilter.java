package shoppingservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName="LoginFilter",urlPatterns={"/login"})
public class LoginFilter implements Filter 
{
	FilterConfig config;
	public void destroy() {
		
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		String userId=request.getParameter("userId");
		String pass=request.getParameter("pass");
		PrintWriter out=response.getWriter();
		//out.println("i am the filter");
		ServletContext ctx=config.getServletContext();
		try{
			//Connection c=(Connection)ctx.getAttribute("con");
			Connection c=ConnectionProvider.getConn();
			Statement s=c.createStatement();
			ResultSet rs=s.executeQuery("select * from cust where userId='"+userId+"' and pass='"+pass+"'");
			if(rs.next())
			{
				if(rs.getString("status").equals("F"))
					{
					s.executeUpdate("update cust set status='T' where userId='"+userId+"' and pass='"+pass+"'");
					chain.doFilter(request, response);
					HttpServletResponse rss=(HttpServletResponse)response;
					rss.setHeader("Refresh", "0;welcome.html");
					}
			else
			{
				out.println("<html><body>User already logged in </body><html>");
				HttpServletResponse rss=(HttpServletResponse)response;
				rss.setHeader("Refresh","4;index.html");
			}
			}
				else
				{
					RequestDispatcher rd=request.getRequestDispatcher("/index.html");
					rd.forward(request,response);
				}
		}
		catch(Exception e){}
	}
	public void init(FilterConfig config) throws ServletException 
	{
	  this.config=config;
	}
}
