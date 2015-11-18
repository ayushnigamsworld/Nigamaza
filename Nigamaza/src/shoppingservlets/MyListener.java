package shoppingservlets;

import java.sql.*;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener
{
	Connection c;
	public void contextInitialized(ServletContextEvent e)
	{
		try
		{
			ServletContext ctx=e.getServletContext();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","nigamoracle");
			ctx.setAttribute("con", c);
			System.out.println("context created");
		}
		catch(Exception ee)
		{
			System.out.println("errrorrrwaaaaaa "+ee);
		}
	}
	public void contextDestroyed(ServletContextEvent e)
	{
		try
		{
			c.close();
		}
		catch(Exception eee){}
	}
}
