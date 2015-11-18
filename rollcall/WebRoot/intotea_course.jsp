<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>注入课程信息</h1>
<form action="/rollcall/intotea_course" method="post">
<table>
      <tr>
            <td>课程名</td>
            <td><input type="text" name="course_name"></td>     
      </tr>
      <tr>
            <td>所在学院</td>
            <td><input type="text" name="college"></td>
      </tr>
      <tr>
            <td><input type="submit" value="添加" /><td>
      </tr>
</table>
</form>
</body>
</html>