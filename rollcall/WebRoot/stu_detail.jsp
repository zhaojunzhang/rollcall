<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>修改学生的信息</h1>
<form action="/rollcall/update_stuinfo" method="post">
<table>
      <tr>
      <td style="display:none;">编号</td>
      <td style="display:none;"><input type="text" name="id" value="${student.id}"/></td>
      </tr>
      <tr>
      <td>学号</td>
      <td><input type="text" name="stu_id" value="${student.stu_id}"/></td>
      </tr>
      <tr>
      <td>用户名</td>
      <td><input type="text" name="username" value="${student.username}"/></td>
      </tr>
      <tr>
          <td>密码</td>
          <td><input type="password" name="password" value="${student.password}"/></td>
     </tr>
      <tr>
      <td>昵称</td>
      <td><input type="text" name="nickname" value="${student.nickname}"/></td>
      </tr>
      <tr>
       <td><input type="submit" value="修改"/></td>
       <td><input type="button" value="返回" onclick="history.go(-1);"/></td>
      </tr>
      
</table>
</form>
</body>
</html>