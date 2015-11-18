<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>教师功能页面</h3>
<h2>欢迎您，${teacher.nickname}，您的角色是：Teacher  <a href="/rollcall/invalidate.jsp">注销</a></h2> 
<a href="/rollcall/intotea_course.jsp">注入课程信息</a>
<a href="/rollcall/looktea_course?id=${teacher.id}">查看老师讲课列表</a>
<a href="">导入学生表单excel表格</a>
<a href="">导出excel表格</a>



</body>
</html>