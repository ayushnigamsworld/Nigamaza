package shoppingservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RegisterServlet() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		out.println("i am register servlet   X  ");
		response.setContentType("text/html");
		out.println("<html><body><br><h1>User Already exists!! Try Again</h1>");
		out.println("<br><h2>Registration Page Reloading .... </h2></body></html>");
		response.setHeader("Refresh", "4;register.html");
		/*try{
		 RequestDispatcher rd=request.getRequestDispatcher("/userExist");
		 rd.forward(request,response);
		 }
		 */
		//catch(Exception e){out.println(e);}
		out.println("</body></html>");
	}

}
