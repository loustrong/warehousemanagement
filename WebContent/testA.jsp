<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script src="jquery/jquery-3.3.1.js" type="text/javascript">
	
</script>
</head>

<body>
	<table>
		<tr>
			<td>UserName:</td>
			<td><input type="text" id="txt" /></td>
			<td id="tip"></td>
		</tr>
		<tr>
	</table>
</body>
<script type="text/javascript">
	$(function() {
		$("#txt").keyup(function() {
			showtxt();
		});
	});

	function showtxt() {
		var name=$.trim($("#txt").val());
		$.ajax({
			type : "get",
			url : "show",
			data:"name="+name,
			success : function(m) {
				
				var object = eval("(" + m + ")");
				$("#tip").html("<p>"+object.message+"</p>");
			}
		});
	}

</script>

</html>
