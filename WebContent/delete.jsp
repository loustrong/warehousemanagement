<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Query</title>
</head>
<body style="text-align: center;">
		<form action="${pageContext.request.contextPath}/ProductDeleteServlet" method="post">
<table width="60%" border="1">

<tr><td>ID</td><td><input type="text" name="id" ></td></tr>
<tr><td>keeper</td><td><input type="text" name="keeper" ></td></tr>
<tr><td>location</td><td><input type="text" name="location" ></td></tr>
<tr><td>modifiedTime</td><td><input type="text" name="modifiedTime" ></td></tr>
<tr><td>name</td><td><input type="text" name="name" ></td></tr>
<tr><td>price</td><td><input type="text" name="price" ></td></tr>
<tr><td>quantity</td><td><input type="text" name="quantity" ></td></tr>
<tr><td>type</td><td><input type="text" name="type" ></td></tr>


<tr><td><input type="reset" value="qingkong"></td>
    <td><input type="submit" value="tijiao"></td>
</tr>

</table>
		</form>
</body>
</html>