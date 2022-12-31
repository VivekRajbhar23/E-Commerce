<h1>welcome to userhome</h1>
<%!int total=0; %>
<%
String email=(String) session.getAttribute("uid");
%>
<%= "welcome=" +email%>
<a href="Logout">Logout</a>

<%@page import="java.sql.ResultSet"%>
<%@page import ="java.sql.Statement" %>
<%@page errorPage="error.jsp" %>
<%@include file="db.jsp" %>
<br>
<%
String qr="select * from cart where email=?";
PreparedStatement ps=con.prepareStatement(qr);
ps.setString(1, email);
ResultSet rs=ps.executeQuery();
if(rs.next())
{
   do
   {
	    String id=rs.getString("id");
		String name=rs.getString("name");
		int price=rs.getInt("price");
		String cat=rs.getString("cat");
		String cmp=rs.getString("cmp");
		total=total+price;
		%>
		<div style="height: 450px; width: 400px; background-color: rgb(100, 100, 100); text-align: center;margin: 5px;color: white;display: inline-block;">
	<img height="180px" width="390px" src="https://petapixel.com/assets/uploads/2017/03/product1.jpeg">
	<h5>Product Id : <%=id %></h5>
	<h3>Name :<%=name %></h3>
	<h4>Price :<%=price %></h4>
	<h5>Category :<%=cat %></h5>
	<h5>Company :<%=cmp %></h5>
	
</div>
		<%
   }while(rs.next());
   	
}
else
{
	out.println("no records found");
}
%>
<h1 align="center">Total Amount :<%=total %></h1>
<center><a href="https://www.paypal.com/in/signin" style="color: red">checkout Cart</a></center>