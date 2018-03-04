
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
     <%@ page import="java.util.ArrayList" %>
     <%@ page import="com.wistron.warehousemanagement.domain.Product" %>


<%--为了避免在jsp页面中出现java代码，这里引入jstl标签库，利用jstl标签库提供的标签来做一些逻辑判断处理 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>




<html>
<head>
<meta charset="UTF-8">
<!-- IE浏览器的兼容配置，以最新版本兼容 -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- 视口。移动设备有限 -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css"	href="css/register.css" />
<link rel="stylesheet" type="text/css"	href="bootstrap/3.3.5/css/bootstrap.min.css" />
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->

<title>查詢界面</title>
<script type="text/javascript">
	function doLogout() {
		//访问LogoutServlet注销当前登录的用户
		window.location.href = "${pageContext.request.contextPath}/servlet/LogoutServlet";
	}
</script>
</head>

<body>
	<nav class="navbar navbar-default navbar-inverse" id="nav">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#"> <span
					class="glyphicon glyphicon-home" id="tel" aria-hidden="true">&nbsp;快樂工作
						&nbsp;幸福生活 </span>
				</a>
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#nav_inf" aria-expanded="false">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>
			
		</div>
	</nav>
	<h2>KD0L30 Warehouse Management System</h2>
	<!--导航栏二开始-->
	<nav class="navbar navbar-default el-navbar"
		style="margin-bottom: 10px;">
		<div class="container" id="logo_info">
			<div class="navbar-header" style="height: 88px;">
				<a class="navbar-brand" href="#" id="log_img"> <img alt="Brand"
					src="image/logo.png">
				</a>
			</div>
			<h1 class="user_login">查詢結果</h1>
		</div>
	</nav>
	<% 
List<Product> list= (ArrayList<Product>)request.getAttribute("list"); 
%>
	<!--註冊页面开始-->
	<div class="container">
		<div class="panel panel-default">
			
			
	<table class="table table-striped">
    <thead>
    <tr>
        <th>編號</th>
        <th>保管人</th>
        <th>時間</th>
        <th>品牌名</th>
        <th>價格</th>
        <th>數量</th>
        <th>類型</th>
        <th><button type="reset" class="btn btn-success">全部修改</button></th>
        <th><button type="reset" class="btn btn-success">全部保存 </button></th>
    
          
    </tr>
    </thead>
    <tbody>
   
    <%for(int i=0;i<list.size();i++){
 Product p=(Product)list.get(i);
 %>
  <tr>
        <td><%=p.getId() %></td>
        <td><%=p.getKeeper() %></td>
          <td><%=p.getLocation() %></td>
         <td><%=p.getModifiedTime() %></td>
          <td><%=p.getName() %></td>
           <td><%=p.getPrice() %></td>
            <td><%=p.getQuantity() %></td>
             <td><%=p.getType() %></td>
            
        <td><button type="reset" class="btn btn-warning"> 刪除</button></td>
        <td><button type="reset" class="btn btn-success">修改 </button></td>
        <td><button type="reset" class="btn btn-warning">保存 </button></td>
    </tr>
    <%} %>
    
    
    </tbody>
</table>
						</div>
						<div>
							
							<button type="submit" class="btn btn-success"> 提交查詢</button>
						</div>
					</form>
							</div>
				
	<!--底部信息开始-->
	
	
	
	<div class="panel panel-default">
			<div style="font-weight: bold;" class="panel-heading">查詢結果</div>
			<div class="row">
				<div class="col-md-6 col-xs-0"></div>
				<div class="panel-body col-md-9 col-xs-15" id="logins">
					<form class="form-horizontal" style="text-align: center;" action="${pageContext.request.contextPath}/ProductQueryServlet" method="post">
						<p class="p_title">請填寫至少一項查詢信息</p>
						<div class="form-group">
							<span>&emsp;&emsp;編號：</span><input type="text" id="id" name="id" 
								placeholder="請輸入編號">
						</div>
						<div>
							<button type="reset" class="btn btn-success"> 重置</button>
							<button type="submit" class="btn btn-success"> 提交查詢</button>
						</div>
					</form>
				</div>
				</div>
	</div>
	<!--底部链接内容-->

	<!--底部信息开始-->
	<!--底部链接内容-->
	<div class="row " style="background-color: #f8f8f8;">
		<div class="container" style="padding: 25px; font: 14px '微软雅黑';">
			<div class="col-sm-8 col-xs-12">
				<p>本網站版權所有，請尊重智慧財產勿任意轉載，違者依法必究</p>
				<p>版权所有：&copy; Copy Right.2018/01</p>
				<p>地&emsp;&emsp;址：成都高新綜合保稅區(雙流園區)綜保大道168號</p>

				</p>
			</div>
		</div>
	</div>







	<hr />


	<hr />
<script src="bootstrap/3.3.0/bootstrap.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script type="text/javascript" src="bootstrap/3.3.0/bootstrap.min.js"></script>
</body>
</html>
