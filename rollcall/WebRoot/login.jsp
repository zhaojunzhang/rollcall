<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>兆军点名系统登陆界面</h3>
</body>
<h3 style="color: red">${msg}</h3>
<form action="/rollcall/login"  method="post">
<table>
    <tr>
        <td>用户名</td>
        <td><input type="text" name="username"/></td>
    </tr>
    <tr>
        <td>职称</td>
        <td>
                <select name="role">
                <option value="teacher">教师</option>
                <option value="student">学生</option>
                </select>   
         </td>
    </tr>
    <tr>
          <td>密码</td>
          <td><input type="password" name="password"/></td>
    </tr>
     <tr>
             <td><input type="submit" value="登陆"/></td>
             <td><a href="/rollcall/stu_regist.jsp">学生注册</a>
             <a href="/rollcall/tea_regist.jsp">教师注册</a></td>
     </tr>
</table>
</form>
</html>