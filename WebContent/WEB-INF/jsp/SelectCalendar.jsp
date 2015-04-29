<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Select Calendar</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />
	
	<div align="center">
		<jsp:useBean id="USER_INFO" type="pshirodkar.edu.neu.coe.assignment3.bean.LoginBean" scope="session" />
		<h1>Welcome, <jsp:getProperty property="userName" name="USER_INFO" /></h1>
		<h2>You have the following available calendars.</h2>
		<h2>Please select a calendar to view your schedule details in it.</h2>
		
		<table>
			<c:forEach var="calendar" items="${requestScope.calendars}" varStatus="status">	
			<tr>
				<td>
					<a href="<%= request.getContextPath()%>/CalendarDetails?calendarIndex=<c:out value="${status.count}"/>">
						<c:out value="${calendar.title.plainText}" />
					</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>	
</body>
</html>