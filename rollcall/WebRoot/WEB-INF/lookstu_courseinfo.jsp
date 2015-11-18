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
<h1>查看学生信息</h1>
<c:if test="${empty students }">
<h1>没有任何学生信息</h1>
</c:if>
<c:if test="${not empty students }">
<table border="1" width="30%">
<tr>
     <th>学号</th>
     <th>用户名</th>
     <th>昵称</th>
     <th>签到数量</th>
     
</tr>
<c:forEach items="${ students}" var="student" >
     <tr>
     <td>${student.stu_id }</td>
     <td>${student.username}</td>
     <td>${student.nickname}</td>
   <c:forEach items="${ guanxis}" var="guanxi" >
     <c:if test="${student.id==guanxi.student_id }">
      <td> ${guanxi.num }</td>
     </c:if>
   </c:forEach>    
            
        </tr>
</c:forEach>
  
</table>
</c:if>
</body>
</html>