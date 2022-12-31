

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Alogin
 */
@WebServlet("/Alogin")
public class Alogin extends HttpServlet {
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		if(id.equals("admin") && pwd.equals("12345"))
		{
//			RequestDispatcher rd=request.getRequestDispatcher("AdminHome");
//			rd.include(request, response);
			response.sendRedirect("adminhome.html");
//			Cookie ck=new Cookie("aid",id);
//			response.addCookie(ck);
//			response.sendRedirect("AdminHome");
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("admin.html");
			rd.include(request, response);
			out.println("Invalid id and password");
		}
	}

}
