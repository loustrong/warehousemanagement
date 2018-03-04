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
<script src="jquery/jquery-1.4.2.min.js" type="text/javascript">
	
</script>
</head>

<body>
	<table>
		<tr>
			<td>id:</td>
			<td><input type="text" id="txt" /></td>
			
			<td><button type="button" id="button">刪除</button></td>
			<td id="tip"></td>
		</tr>
		
				<tr>
			<td>id:</td>
			<td><input type="text" id="id1" /></td>
			<td>type:</td>
			<td><input type="text" id="type1" /></td>
			<td>name:</td>
			<td><input type="text" id="name1" /></td>
			<td>price:</td>
			<td><input type="text" id="price1" /></td>
			<td>modifiedTime:</td>
			<td><input type="text" id="modifiedTime1" /></td>
			<td>keeper:</td>
			<td><input type="text" id="keeper1" /></td>
			<td>location:</td>
			<td><input type="text" id="location1" /></td>
			<td>quantity:</td>
			<td><input type="text" id="quantity1" /></td>
			
			
			
			<td><button type="button" id="btnupt">修改</button></td>
			<td id="tip"></td>
		</tr>
		
		<!-- ADD THE PRODUCT -->
						<tr>
			<td>id:</td>
			<td><input type="text" id="id2" /></td>
			<td>type:</td>
			<td><input type="text" id="type2" /></td>
			<td>name:</td>
			<td><input type="text" id="name2" /></td>
			<td>price:</td>
			<td><input type="text" id="price2" /></td>
			<td>modifiedTime:</td>
			<td><input type="text" id="modifiedTime2" /></td>
			<td>keeper:</td>
			<td><input type="text" id="keeper2" /></td>
			<td>location:</td>
			<td><input type="text" id="location2" /></td>
			<td>quantity:</td>
			<td><input type="text" id="quantity2" /></td>
			
			
			
			<td><button type="button" id="btnadd">增加</button></td>
			<td id="tip"></td>
		</tr>
		<tr>
		 <td id="id0">23</td><td><button  class="btn btn-warning" id="_btn_del0"> 刪除</button></td>
		</tr>
		
		
	</table>
</body>
<script type="text/javascript">

$(function() {
	$("#_btn_del0").click(function() {
		
		alert("hELO");
		del();
});}



	$(function() {
		$("#button").click(function() {
			showtxt();
		});
		
		$("#btnupt").click(function() {
			update();
		});
		
		$("#btnadd").click(function() {
			add();
		});
		
	});

	
function del() {
		
		var id=$.trim($("#id0").html());
		alert(id);
		$.ajax({
			type:"post",
			url:"ProductDeleteServlet",
			dataType:'json',
			data:{"id":$.trim($("#id0").html())},
			success : function(m) {
				
				var object = eval("(" + m + ")");
				$("#tip").html("<p>"+object.message+"</p>");
			}
		});
	}
	
	function showtxt() {
		var id=$.trim($("#txt").val());
		alert(id);
		$.ajax({
			type : "post",
			url : "ProductDeleteServlet",
			data:"id="+id,
			success : function(m) {
				
				var object = eval("(" + m + ")");
				$("#tip").html("<p>"+object.message+"</p>");
			}
		});
	}

	function update() {
		var id=$.trim($("#id1").val());
		var type=$.trim($("#type1").val());
		var price=$.trim($("#price1").val());
		var name=$.trim($("#name1").val());
		var modifiedTime=$.trim($("#modifiedTime1").val());
		var keeper=$.trim($("#keeper1").val());
		var location=$.trim($("#location1").val());
		var quantity=$.trim($("#quantity1").val());
		
		
		
		$.ajax({
			type : "post",
			url : "ProductUpdateServlet",
			dataType:"json",
			data:{"id":$.trim($("#id1").val()),
				"keeper":$.trim($("#keeper1").val()),
				 "location":$.trim($("#location1").val()),
				 "modifiedTime":$.trim($("#modifiedTime1").val()),
				 "name":$.trim($("#name1").val()),
				 "price":$.trim($("#price1").val()),
				 "quantity":$.trim($("#quantity1").val()), 
				  "type":$.trim($("#type1").val())},
				 
			success : function(m) {
				
				var object = eval("(" + m + ")");
				$("#tip").html("<p>"+object.message+"</p>");
			}
		});
	}

	function add() {
		var id=$.trim($("#id2").val());
		var type=$.trim($("#type2").val());
		var price=$.trim($("#price2").val());
		var name=$.trim($("#name2").val());
		var modifiedTime=$.trim($("#modifiedTime2").val());
		var keeper=$.trim($("#keeper2").val());
		var location=$.trim($("#location2").val());
		var quantity=$.trim($("#quantity2").val());
		
		
		
		$.ajax({
			type : "post",
			url : "AddProductServlet",
			dataType:"json",
			data:{"id":$.trim($("#id2").val()),
				"keeper":$.trim($("#keeper2").val()),
				 "location":$.trim($("#location2").val()),
				 "modifiedTime":$.trim($("#modifiedTime2").val()),
				 "name":$.trim($("#name2").val()),
				 "price":$.trim($("#price2").val()),
				 "quantity":$.trim($("#quantity2").val()), 
				  "type":$.trim($("#type2").val())},
				 
			success : function(m) {
				
				var object = eval("(" + m + ")");
				$("#tip").html("<p>"+object.message+"</p>");
			}
		});
	}
	
	
</script>

</html>
