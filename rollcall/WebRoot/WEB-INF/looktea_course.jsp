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
<h1>查看教师教课列表</h1>
<!--查看教师教课列表  List -->
<c:if test="${empty teachers}">
	<h1>没有您查询的内容！</h1>
</c:if>
<c:if test="${not empty teachers}">


<c:forEach items="${teachers}" var="teacher">

 用户名： ${teacher.username}
 昵     称： ${teacher.nickname}
    
   <table border="1" width="30%">
			<tr>
				<th>课程名</th>
				<th>学院</th>
				<th>取消课程</th>
				<th>查看班级学生</th>
				<th>发布签到</th>
			</tr>
			<c:forEach items="${teacher.courses}" var="course">
				<tr>
					<td>${course.course_name }</td>
					<td>${course.college}</td>
					<td><a href="/rollcall/cancle_course?id=${course.id}">取消</a></td>
					<td><a href="/rollcall/lookstu_courseinfo?tea_id=${teacher.id}&course_id=${course.id}">查看</a></td>
					<td><a href="/rollcall/publish_sign?tea_id=${teacher.id}&course_id=${course.id}">发布签到</a></td>
				</tr>
			</c:forEach>
		</table>


</c:forEach>

</c:if>
</body>
</html>