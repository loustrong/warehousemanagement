<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="BIG5"%>
    <%@ page import="java.util.List" %>
     <%@ page import="java.util.ArrayList" %>
     <%@ page import="com.wistron.warehousemanagement.domain.Product" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>QueryResultPage</title>
</head>
<body>
<% 
List<Product> list= (ArrayList<Product>)request.getAttribute("list"); 
%>

<table>
   
 <tr><th>ID</th><th>Type</th></tr>

<%for(int i=0;i<list.size();i++){
 Product p=(Product)list.get(i);
 %>
 
<tr><td><%=p.getId() %></td>

<td><%=p.getType() %></td>
</tr>


 <%} %>
 
 </table>



</body>
</html>