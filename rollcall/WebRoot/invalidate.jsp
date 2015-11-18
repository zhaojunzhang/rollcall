<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
//销毁session 
session.invalidate();
//跳回主页
response.sendRedirect("/rollcall/login.jsp");
%>