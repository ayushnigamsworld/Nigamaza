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

@WebServlet("/watches")
public class WatchesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WatchesServlet() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(false);
		if(session!=null)
		{
			String[] watches=request.getParameterValues("watch");
			session.setAttribute("watches", watches);
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
