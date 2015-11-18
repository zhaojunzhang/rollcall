<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>教师功能页面</h3>
<h2>欢迎您，${student.nickname}，您的角色是：Student  <a href="/rollcall/invalidate.jsp">注销</a></h2>
<a href="/rollcall/query_updateinfo">修改自己信息</a> 
<a href="/rollcall/query_teacourse">查看老师讲课列表</a>
<a href="/rollcall/stu_signinfo">签到</a>
</body>
</html>