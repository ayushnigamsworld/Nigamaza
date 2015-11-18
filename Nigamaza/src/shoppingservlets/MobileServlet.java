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

@WebServlet("/mobiles")
public class MobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MobileServlet() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(false);
		if(session!=null)
		{
			String[] mobiles=request.getParameterValues("mobile");
			session.setAttribute("mobiles", mobiles);
			RequestDispatcher rd=request.getRequestDispatcher("/welcome.html");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("/index.html");
			rd.forward(request, response);
		}
	}

}
