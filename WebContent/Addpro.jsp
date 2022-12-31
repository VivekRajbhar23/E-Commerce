<%@page errorPage="error.jsp" %>
<%@include file="db.jsp" %>
<%
String id=request.getParameter("id");
String name=request.getParameter("name");
String p=request.getParameter("price");
int price=Integer.parseInt(p);
String cat=request.getParameter("cat");
String cmp=request.getParameter("cmp");
String qr="insert into product values(?,?,?,?,?)";
PreparedStatement ps=con.prepareStatement(qr);
ps.setString(1, id);
ps.setString(2, name);
ps.setInt(3, price);
ps.setString(4, cat);
ps.setString(5, cmp);
int i=ps.executeUpdate();
out.println(i+" product added:");
con.close();
%>