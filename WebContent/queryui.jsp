<%@ page language="java" pageEncoding="UTF-8"%>
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
			<div class="collapse navbar-collapse" id="nav_inf">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="###">首頁</a></li>
					<c:if test="${user==null}">
					<li><a
							href="${pageContext.request.contextPath}/servlet/RegisterUIServlet"
							target="_blank">註冊</a> <li>
					<a href="${pageContext.request.contextPath}/servlet/LoginUIServlet">登錄</a></c:if>
					<c:if test="${user!=null}">
					<input type="button" value="欢迎您：${user.userName}" >
   		欢迎您：${user.userName}
   		<input type="button" value="退出登錄" onclick="doLogout()">
					</c:if>

					<li><a href="###">幫助 </a></li>
				</ul>
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
			<h1 class="user_login">查詢</h3>
		</div>
	</nav>
	<!--註冊页面开始-->
	<div class="container">
		<div class="panel panel-default">
			<div style="font-weight: bold;" class="panel-heading">查詢條件</div>
			<div class="row">
				<div class="col-md-6 col-xs-0"></div>
				<div class="panel-body col-md-9 col-xs-15" id="logins">
					<form class="form-horizontal" style="text-align: center;" action="${pageContext.request.contextPath}/ProductQueryServlet" method="post">
						<p class="p_title">請填寫至少一項查詢信息</p>
						<div class="form-group">
							<span>&emsp;&emsp;編號：</span><input type="text" id="id" name="id" 
								placeholder="請輸入編號">
						</div>
						
						<div class="form-group">
							<span>&emsp;保管人：</span><input type="text" id="keeper" name="keeper" 
								placeholder="保管人如  Tom Lou">
						</div>
						
						<div class="form-group">
							<span>&emsp;&emsp;時間：</span><input type="text" id="modifiedTime" name="modifiedTime" 
								placeholder="例如：2018-02-01">
						</div>
						
						<div class="form-group">
							<span>&emsp;品牌名：</span><input type="text" id="name" name="name" 
								placeholder="例如：DELL,HP">
						</div>
						
						<div class="form-group">
							<span>&emsp;&emsp;價格：</span><input type="text" id="price" name="price" 
								placeholder="例如：3500yuan">
						</div>
						
						<div class="form-group">
							<span>&emsp;&emsp;數量：</span><input type="text" id="quantity" name="quantity" 
								placeholder="例如：1">
						</div>
						
						<div class="form-group">
							<span>&emsp;&emsp;類型：</span><input type="text" id="type" name="type" 
								placeholder="例如：1">
						</div>
						<div>
							<button type="reset" class="btn btn-success"> 重置</button>
							<button type="submit" class="btn btn-success"> 提交查詢</button>
						</div>
					</form>
				</div>
				
		</div>
	</div>
	<!--底部信息开始-->
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
