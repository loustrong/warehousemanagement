<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
 <script language="JavaScript">
//用户名字
function getusername()
{
var WshNetwork = new ActiveXObject("WScript.Network");
alert("登录名 = " + WshNetwork.UserDomain);
alert("计算机名 = " + WshNetwork.ComputerName);
alert("用户名 = " + WshNetwork.UserName);
}
</script>
<a onclick="javascript:getusername();">点我</a>
</body>
</html>