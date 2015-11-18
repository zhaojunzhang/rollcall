<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
//验证注册表单
function checkFrom(){
//将需要验证表单组件  提供Id
var username = document.getElementById("username").value;
if(username==null||username==""){
    alert("用户名不能为空");
    return false;
}
//为其它字段添加非空校验
var password = document.getElementById("password").value;
var repassword = document.getElementById("repassword").value;
if(password!=repassword){
alert("两次密码必须一致");
  return false;
}
}
//切换验证码
    function change(){
    document.getElementById("myimg").src="/rollcall/checkcode?"+new Date().getTime;
    }
</script>
</head>
<h3 align="center">学生注册页面<h3>
<body>
<h3 style="color: red">${msg}</h3>
<form action="/rollcall/stu_regist" method="post">
<table>
     <tr>
           <td>学号</td>
           <td><input type="text" name="stu_id"/></td>
     </tr>
     <tr>
           <td> 用户名：</td>
           <td> <input type="text" name="username" id="username"/></td>
     </tr>
     <tr>
     <td>密码</td>
     <td><input type="password" name="password" id="password"></td>
     </tr>
     <tr>
            <td>确认密码</td>
            <td><input type="password" name="repassword" id="repassword"></td>
        </tr>
        <tr>
             <td>昵称</td>
             <td><input type="text" name ="nickname"/></td>
        </tr>
        <tr>
              <td>邮箱</td>
              <td><input type="text" name="email"></td>
        </tr>
        <tr>
              <td>验证码</td>
              <td><input type="text" name="checkcode"/><img id="myimg" src="/rollcall/checkcode"  style="cursor:pointer;"
              onclick="change()"/></td>
        </tr>
        <tr>
             <td><input type="submit" value="注册"/></td>
             <td>
             <!--登录  链接登录页面，返回  返回之前页面 -->
             <input type="button" value="返回" onclick="history.go(-1);"/>
             </td>
        </tr>
</table>
</form>
</body>
</html>