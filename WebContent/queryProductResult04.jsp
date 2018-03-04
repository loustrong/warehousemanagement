
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
     <%@ page import="java.util.ArrayList" %>
     <%@ page import="com.wistron.warehousemanagement.web.pagebean.PageBean" %>
     <%@ page import="com.wistron.warehousemanagement.domain.Product" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%--为了避免在jsp页面中出现java代码，这里引入jstl标签库，利用jstl标签库提供的标签来做一些逻辑判断处理 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<meta charset="UTF-8">
<!-- IE浏览器的兼容配置，以最新版本兼容 -->


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
<script src="jquery/jquery-3.3.1.js" type="text/javascript"></script>
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
	

	PageBean pagebean=(PageBean)request.getAttribute("pagebean");
	int currentPage=pagebean.getCurrentPage();
	System.out.println("currentpage:"+currentPage);
	int totalnumber=pagebean.getTotalnumber();
	System.out.println("totalnumber:"+totalnumber);
	int size = 5;
	if(list.size()<5) size=list.size();
	System.out.println("size:"+size);
	System.out.println("currentPage:"+currentPage);
	String id = (String)request.getParameter("id");
	String keeper = (String)request.getParameter("keeper");
	String location = (String)request.getParameter("location");
	String modifiedTime = (String)request.getParameter("modifiedTime");
	String name = (String)request.getParameter("name");
	String price = (String)request.getParameter("price");
	String quantity = (String)request.getParameter("quantity");
	String type = (String)request.getParameter("type");
	System.out.println("id:"+id+"location:"+location);
	
	
%>
	<!--註冊页面开始-->
	<div class="container">
	<div class="panel panel-default">
	<table class="table table-striped">
    <thead>
    <tr>
        <th>編號</th>
       
        <th>保管人</th>
         <th>位置</th>
        <th>時間</th>
        <th>品牌名</th>
        <th>價格</th>
        <th>數量</th>
        <th>類型</th>
        <th><button  class="btn btn-success">全部修改</button></th>
        <th><button  class="btn btn-info">全部保存 </button></th>
    </tr>
    </thead>
    <tbody>
   
    <%for(int i=0;i<size;i++){
 		Product p=(Product)list.get(i);
 		String  _id = "id"+""+i;
 		String  _keeper = "keeper"+""+i;
 		String  _location = "location"+""+i;
 		String  _mofifiedTime = "mofifiedTime"+""+i;
 		String  _name = "name"+""+i;
 		String  _price = "price"+""+i;
 		String  _quantity = "quantity"+""+i;
 		String  _type = "type"+""+i;
 		String _btn_del = "_btn_del"+""+i;
 		String _btn_modi = "_btn_modi"+""+i;
 		String _btn_sav = "_btn_sav"+""+i;
 		String column="column"+i;
 		
 		%>
 	 <tr id="<%=column%>">
 	 
        <td id="<%=_id %>"><%=p.getId() %></td>
        <td id="<%=_keeper %>"><%=p.getKeeper() %></td>
        <td id="<%=_location %>"><%=p.getLocation() %></td>
        <td id="<%=_mofifiedTime %>"><%=p.getModifiedTime() %></td>
        <td id="<%=_name %>"><%=p.getName() %></td>
        <td id="<%=_price %>"><%=p.getPrice() %></td>
        <td id="<%=_quantity %>"><%=p.getQuantity()  %></td>
        <td id="<%=_type %>"><%=p.getType() %></td>
        
        <td><input type="button" class="btn btn-warning" id="<%=_btn_modi %>" value="修改"></td>
        <td><input type="button" class="btn btn-warning" id="<%=_btn_del %>" value="刪除"></td> 
   		<td><input type="button" class="btn btn-warning" id="<%=_btn_sav %>" value="保存"></td>
       
    </tr>
    <%} %>
    </tbody>
    
</table>

 <script>
    var x=document.getElementById("id0").innerHTML;
	alert(x);
	
	</script>

    
   
				</div>
				</div>
				
	<!--底部信息开始-->
	<!--底部链接内容-->
	
	
<div class="pagination center">  
  
    <c:choose>  
        <c:when test="${pagebean.currentPage+1 == 1}">  
       <li><a class="navlinks current">共${pagebean.totalpage}页  </a> </li> 
          <li>  <a class="navlinks current">首页 </a>  </li>
           <li> <a class="navlinks current">上一页</a>  </li>
        </c:when>  
        <c:otherwise>
         <li><a class="navlinks current">共${pagebean.totalpage}页  </a> </li> 
         <li>   <a class="navlinks current" href='${pageContext.request.contextPath}/ProductQueryServlet?id=<%=id%>&keeper=<%=keeper%>&location=<%=location%>&modifiedTime=<%=modifiedTime%>&name=<%=name%>&price=<%=price%>&quantity=<%=quantity%>&totalnumber=<%=totalnumber%>&currentPage=0' >首页 </a> </li> 
         <li>   <a class="navlinks current" href='${pageContext.request.contextPath}/ProductQueryServlet?id=<%=id%>&keeper=<%=keeper%>&location=<%=location%>&modifiedTime=<%=modifiedTime%>&name=<%=name%>&price=<%=price%>&quantity=<%=quantity%>&totalnumber=<%=totalnumber%>&currentPage=${pagebean.currentPage-1}' >上一页 </a>  </li>
        </c:otherwise>  
    </c:choose>  
    <c:choose>  
        <c:when test="${pagebean.totalpage+1 <= 5}">  
            <c:forEach begin="1" end="${pagebean.totalpage}" varStatus="s">  
                <c:choose>  
                    <c:when test="${s.index == pagebean.currentPage+1}">
                    <c:set var="active" value="${s.index==(currentPage+1)?'active':''}"/>  
                       <li class="${active}"> <a class="navlinks current" href="${pageContext.request.contextPath}/ProductQueryServlet?id=<%=id%>&keeper=<%=keeper%>&location=<%=location%>&modifiedTime=<%=modifiedTime%>&name=<%=name%>&price=<%=price%>&quantity=<%=quantity%>&totalnumber=<%=totalnumber%>&currentPage=${s.index-1}" >${s.index}</a>  
                    	</li>
                    </c:when>  
                    <c:otherwise>  
                    <c:set var="active" value="${s.index==(currentPage+1)?'active':''}"/>  
                      <li class="${active}">  <a class="navlinks current" href="${pageContext.request.contextPath}/ProductQueryServlet?id=<%=id%>&keeper=<%=keeper%>&location=<%=location%>&modifiedTime=<%=modifiedTime%>&name=<%=name%>&price=<%=price%>&quantity=<%=quantity%>&totalnumber=<%=totalnumber%>&currentPage=${s.index-1}" >${s.index}</a>  
                    </li>
                    </c:otherwise>  
                </c:choose>  
            </c:forEach>  
        </c:when>  
        <c:otherwise>  
            <c:choose>  
                <c:when test="${pagebean.currentPage+1-1 > 2}">  
                    <c:choose>  
                        <c:when test="${pagebean.currentPage+5 >= pagebean.totalpage}">  
                            <c:forEach begin="${pagebean.totalpage-4}" end="${pagebean.totalpage}" varStatus="s">  
                                <c:choose>  
                                    <c:when test="${s.index == pagebean.currentPage+1}">  
                                    <c:set var="active" value="${s.index==(currentPage+1)?'active':''}"/>
                                    <li class="${active}">     <a class="navlinks current" href="${pageContext.request.contextPath}/ProductQueryServlet?id=<%=id%>&keeper=<%=keeper%>&location=<%=location%>&modifiedTime=<%=modifiedTime%>&name=<%=name%>&price=<%=price%>&quantity=<%=quantity%>&totalnumber=<%=totalnumber%>&currentPage=${s.index-1}" >${s.index}</a>  
                                    </li>
                                    </c:when>  
                                    <c:otherwise> 
                                    <c:set var="active" value="${s.index==(currentPage+1)?'active':''}"/>  
                      <li class="${active}"> 
                                        <a class="navlinks current" href="${pageContext.request.contextPath}/ProductQueryServlet?id=<%=id%>&keeper=<%=keeper%>&location=<%=location%>&modifiedTime=<%=modifiedTime%>&name=<%=name%>&price=<%=price%>&quantity=<%=quantity%>&totalnumber=<%=totalnumber%>&currentPage=${s.index-1}" >${s.index}</a>  </li>
                                    </c:otherwise>  
                                </c:choose>  
                            </c:forEach>  
                        </c:when>  
                        <c:otherwise> 
                        <c:set var="active" value="${s.index==(currentPage+1)?'active':''}"/>  
                        <li class="${active}">   <a class="navlinks current" href="${pageContext.request.contextPath}/ProductQueryServlet?id=<%=id%>&keeper=<%=keeper%>&location=<%=location%>&modifiedTime=<%=modifiedTime%>&name=<%=name%>&price=<%=price%>&quantity=<%=quantity%>&totalnumber=<%=totalnumber%>&currentPage=${page.currentPage-2}"   >${page.currentPage+1-2}</a>  </li>
                        <li class="${active}">   <a class="navlinks current" href="${pageContext.request.contextPath}/ProductQueryServlet?id=<%=id%>&keeper=<%=keeper%>&location=<%=location%>&modifiedTime=<%=modifiedTime%>&name=<%=name%>&price=<%=price%>&quantity=<%=quantity%>&totalnumber=<%=totalnumber%>&currentPage=${page.currentPage-1}"   >${page.currentPage+1-1}</a>  </li>
                        <li class="${active}">   <a class="navlinks current" href="${pageContext.request.contextPath}/ProductQueryServlet?id=<%=id%>&keeper=<%=keeper%>&location=<%=location%>&modifiedTime=<%=modifiedTime%>&name=<%=name%>&price=<%=price%>&quantity=<%=quantity%>&totalnumber=<%=totalnumber%>&currentPage=${page.currentPage}"     >${page.currentPage+1}  </a>  </li>
                        <li class="${active}">   <a class="navlinks current" href="${pageContext.request.contextPath}/ProductQueryServlet?id=<%=id%>&keeper=<%=keeper%>&location=<%=location%>&modifiedTime=<%=modifiedTime%>&name=<%=name%>&price=<%=price%>&quantity=<%=quantity%>&totalnumber=<%=totalnumber%>&currentPage=${page.currentPage+1}"   >${page.currentPage+1+1}</a>  </li>
                        <li class="${active}">   <a class="navlinks current" href="${pageContext.request.contextPath}/ProductQueryServlet?id=<%=id%>&keeper=<%=keeper%>&location=<%=location%>&modifiedTime=<%=modifiedTime%>&name=<%=name%>&price=<%=price%>&quantity=<%=quantity%>&totalnumber=<%=totalnumber%>&currentPage=${page.currentPage+1+1}" >${page.currentPage+1+2}</a>  </li>
                        </c:otherwise>  
                    </c:choose>  
                </c:when>  
                <c:otherwise>  
                    <c:forEach end="5" begin="1" varStatus="s">  
                        <c:choose>  
                            <c:when test="${s.index == pagebean.currentPage+1}" > 
                             <c:set var="active" value="${s.index==(currentPage+1)?'active':''}"/>  
                      <li class="${active}">  
                                <a class="navlinks current" href="${pageContext.request.contextPath}/ProductQueryServlet?id=<%=id%>&keeper=<%=keeper%>&location=<%=location%>&modifiedTime=<%=modifiedTime%>&name=<%=name%>&price=<%=price%>&quantity=<%=quantity%>&totalnumber=<%=totalnumber%>&currentPage=${s.index-1}"  >${s.index}</a>  </li>
                            </c:when>  
                            <c:otherwise>  
                             <c:set var="active" value="${s.index==(currentPage+1)?'active':''}"/>  
                      <li class="${active}"> 
                                <a class="navlinks current" href="${pageContext.request.contextPath}/ProductQueryServlet?id=<%=id%>&keeper=<%=keeper%>&location=<%=location%>&modifiedTime=<%=modifiedTime%>&name=<%=name%>&price=<%=price%>&quantity=<%=quantity%>&totalnumber=<%=totalnumber%>&currentPage=${s.index-1}"  >${s.index}</a>  </li>
                            </c:otherwise>  
                        </c:choose>  
                    </c:forEach>  
                </c:otherwise>  
            </c:choose>  
        </c:otherwise>  
    </c:choose>  
    <c:choose>  
        <c:when test="${pagebean.currentPage+1 == pagebean.totalpage}"> 
         <c:set var="active" value="${s.index==(currentPage+1)?'active':''}"/>  
                      <li class="${active}">  
           <a class="navlinks current"> 下一页</a>  </li>
     <li class="${active}">     <a class="navlinks current"> 末页</a>  </li>
        </c:when>  
        <c:otherwise> 
         <c:set var="active" value="${s.index==(currentPage+1)?'active':''}"/>  
                      <li class="${active}">  
           <a class="navlinks current" href="${pageContext.request.contextPath}/ProductQueryServlet?id=<%=id%>&keeper=<%=keeper%>&location=<%=location%>&modifiedTime=<%=modifiedTime%>&name=<%=name%>&price=<%=price%>&quantity=<%=quantity%>&totalnumber=<%=totalnumber%>&currentPage=${pagebean.currentPage+1}" class="navlinks pagebtn"> 下一页</a>  </li>
      <li class="${active}">         <a class="navlinks current" href="${pageContext.request.contextPath}/ProductQueryServlet?id=<%=id%>&keeper=<%=keeper%>&location=<%=location%>&modifiedTime=<%=modifiedTime%>&name=<%=name%>&price=<%=price%>&quantity=<%=quantity%>&totalnumber=<%=totalnumber%>&currentPage=${pagebean.totalpage-1}" class="navlinks"> 末页</a>  </li>
        </c:otherwise>  
    </c:choose>  
</div>  	

	<!--底部信息开始-->
	<!--底部链接内容-->
	<div class="row " style="background-color: #f8f8f8;">
		<div class="container" style="padding: 25px; font: 14px '微软雅黑';">
			<div class="col-sm-8 col-xs-12">
				<p>本網站版權所有，請尊重智慧財產勿任意轉載，違者依法必究</p>
				<p>版权所有：&copy; Copy Right.2018/01</p>
				<p>地&emsp;&emsp;址：成都高新綜合保稅區(雙流園區)綜保大道168號</p>

				
			</div>
		</div>
	</div>

	<hr />


	<hr />

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->




<script>

	$(function() {
		$("#_btn_del0").click(function() {
			
			alert("hELO");
			del("id0");
			 $("#column0").hide();
			 });
    		});
	
	
	$(function() {
    		$("#_btn_sav0").click(function() {
    			
    			alert("sav_btn_alter!");
    			sav("id0");
    			
    			 });
    		});
	
	
	
	function sav(x) {
		
  		 var id=""+x;
  		alert(id);
  		
  		var a=$("#id0").parent().children().eq(0).text(); 
  		
  	   alter(a);
  		
  		$.ajax({
  			type:"post",
  			url:"ProductUpdateServlet",
  			dataType:'json',
  			data:{"id":id},
  			success : function(m) {
  				
  				var object = eval("(" + m + ")");
  				$("#tip").html("<p>"+object.message+"</p>");
  			}
  		});
  	} 
	
	
	

	function del(x) {
		
		 var x=""+x;
		
		var id=document.getElementById(x).innerHTML;
		alert(id);
		$.ajax({
			type:"post",
			url:"ProductDeleteServlet",
			dataType:'json',
			data:{"id":id},
			success : function(m) {
				
				var object = eval("(" + m + ")");
				$("#tip").html("<p>"+object.message+"</p>");
			}
		});
	}

        (function(){  
            $('input[type="button"][id="_btn_modi0"]').on('click', function(){  
                var $this = $(this),  
                    edit_status = $this.attr('edit_status'),  
                    status_value = edit_status && 1 == edit_status ? 0 : 1,  
                    $td_arr = $this.parent().prevAll('td');  
                $this.val(1 == status_value ? '完成？' : '修改').attr('edit_status', status_value);  
                $.each($td_arr, function(){  
                    var $td = $(this);  
                    if(1 == status_value) {  
                        $td.html('<input type="text" value="'+$td.html()+'">');  
                    } else if(0 == status_value){  
                        $td.html($td.find('input[type=text]').val());  
                    }  
                });  
            });  
        })();  
    
        (function(){  
            $('input[type="button"][id="_btn_modi1"]').on('click', function(){  
                var $this = $(this),  
                    edit_status = $this.attr('edit_status'),  
                    status_value = edit_status && 1 == edit_status ? 0 : 1,  
                    $td_arr = $this.parent().prevAll('td');  
                $this.val(1 == status_value ? '完成？' : '修改').attr('edit_status', status_value);  
                $.each($td_arr, function(){  
                    var $td = $(this);  
                    if(1 == status_value) {  
                        $td.html('<input type="text" value="'+$td.html()+'">');  
                    } else if(0 == status_value){  
                        $td.html($td.find('input[type=text]').val());  
                    }  
                });  
            });  
        })();        
        
        (function(){  
            $('input[type="button"][id="_btn_modi2"]').on('click', function(){  
                var $this = $(this),  
                    edit_status = $this.attr('edit_status'),  
                    status_value = edit_status && 1 == edit_status ? 0 : 1,  
                    $td_arr = $this.parent().prevAll('td');  
                $this.val(1 == status_value ? '完成？' : '修改').attr('edit_status', status_value);  
                $.each($td_arr, function(){  
                    var $td = $(this);  
                    if(1 == status_value) {  
                        $td.html('<input type="text" value="'+$td.html()+'">');  
                    } else if(0 == status_value){  
                        $td.html($td.find('input[type=text]').val());  
                    }  
                });  
            });  
        })();       
      
        (function(){  
            $('input[type="button"][id="_btn_modi3"]').on('click', function(){  
                var $this = $(this),  
                    edit_status = $this.attr('edit_status'),  
                    status_value = edit_status && 1 == edit_status ? 0 : 1,  
                    $td_arr = $this.parent().prevAll('td');  
                $this.val(1 == status_value ? '完成？' : '修改').attr('edit_status', status_value);  
                $.each($td_arr, function(){  
                    var $td = $(this);  
                    if(1 == status_value) {  
                        $td.html('<input type="text" value="'+$td.html()+'">');  
                    } else if(0 == status_value){  
                        $td.html($td.find('input[type=text]').val());  
                    }  
                });  
            });  
        })(); 
        (function(){  
            $('input[type="button"][id="_btn_modi4"]').on('click', function(){  
                var $this = $(this),  
                    edit_status = $this.attr('edit_status'),  
                    status_value = edit_status && 1 == edit_status ? 0 : 1,  
                    $td_arr = $this.parent().prevAll('td');  
                $this.val(1 == status_value ? '完成？' : '修改').attr('edit_status', status_value);  
                $.each($td_arr, function(){  
                    var $td = $(this);  
                    if(1 == status_value) {  
                        $td.html('<input type="text" value="'+$td.html()+'">');  
                    } else if(0 == status_value){  
                        $td.html($td.find('input[type=text]').val());  
                    }  
                });  
            });  
        })(); 

        
        
    	
        
        
        
    	
        
        
    </script> 
    
    
    
    <script type="text/javascript" src="bootstrap/3.3.0/bootstrap.min.js"></script> 
</body>
</html>