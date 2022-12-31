

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Update")
public class Update extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String p=request.getParameter("price");
		int price=Integer.parseInt(p);
		String cat=request.getParameter("cat");
		String cmp=request.getParameter("cmp");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adjv630","root","xplor");
			String qr="update product set name=?,price=?,cat=?,cmp=? where id=?";
			PreparedStatement ps=con.prepareStatement(qr);
			ps.setString(5, id);
			ps.setString(1, name);
			ps.setInt(2, price);
			ps.setString(3, cat);
			ps.setString(4, cmp);
			int i=ps.executeUpdate();
			RequestDispatcher rd=request.getRequestDispatcher("Show");
			if(i>0)
			{
				rd.include(request, response);
				out.println(i+" product updated");
			}
			else
			{
				rd.include(request, response);
				out.println("no product updated:");
			}
			
			con.close();
		} catch (Exception e) {
			out.println(e);
		}
	}

}
