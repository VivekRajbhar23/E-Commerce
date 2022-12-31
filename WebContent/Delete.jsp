<%@page errorPage="error.jsp" %>
<%@include file="db.jsp" %>
<%
String id=request.getParameter("id");
String qr="delete from product where id=?";
PreparedStatement ps=con.prepareStatement(qr);
ps.setString(1, id);
ps.executeUpdate();
response.sendRedirect("Show.jsp");
%>