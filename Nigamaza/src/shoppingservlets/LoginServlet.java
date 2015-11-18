package shoppingservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    public LoginServlet() 
    {
        super();
    }
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String userId=request.getParameter("userId");
		String pass=request.getParameter("pass");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("i am servlet");
		try
		{
			HttpSession session=request.getSession();
			session.setAttribute("userId", userId);
			session.setAttribute("pass", pass);
		}
		catch(Exception e){out.println(e);}
	}

}
