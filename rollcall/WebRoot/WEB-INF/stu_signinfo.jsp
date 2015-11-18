<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>签到信息界面</h1>
<c:if test="${empty guanxis}">
<h1>没有老师进行发布签到</h1>
</c:if>
<c:if test="${not empty guanxis}">
教师用户名： ${teacher.username }
教师昵     称： ${teacher.nickname }
课程名     称： ${course.course_name }
所在学     院： ${course.college }
<table border="1" width="30%">
<tr>
     <th>学号</th>
     <th>用户名</th>
     <th>昵称</th>
     <th>签到数量</th>
     <th>签到</th>
     
</tr>

     <tr>
     <td>${student.stu_id }</td>
     <td>${student.username}</td>
     <td>${student.nickname}</td>
   <c:forEach items="${ guanxis}" var="guanxi" >
     <c:if test="${student.id==guanxi.student_id }">
      <td> ${guanxi.num }</td>
     </c:if>
   </c:forEach>    
      <td><a href="/rollcall/stu_sign?tea_id=${teacher.id}&course_id=${course.id}&student_id=${student.id }">签到</a></td>     
        </tr>

  
</table>
</c:if>
</body>
</html>