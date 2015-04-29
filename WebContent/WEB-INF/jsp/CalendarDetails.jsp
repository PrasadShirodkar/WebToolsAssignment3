<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		<title>Calendar Details</title>		
	</head>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />
	<table align="center">
		<tr>
			<td colspan="3" align="center" style="padding-bottom: 40px;">
				You have selected the calendar: <b><c:out value="${sessionScope.calendarSelected.title.plainText}" /></b>
			</td>
		</tr>
		<tr>
			<td>
				<img src="<c:out value="${sessionScope.GOOGLE_MAPS}" />" />
			</td>
			<td width="4%"></td>
			<td>
				<table>
					<tr>
						<td>
							<table cellspacing="10">
								<tr>
									<th colspan="5">
										Calendar Events
									</th>	
								</tr>
								<tr>
									<td>
										<b>Marker</b>
									</td>
									<td>
										<b>Event Title</b>
									</td>
									<td>
										<b>Start Date &amp; Time</b>
									</td>
									<td>
										<b>End Date &amp; Time</b>
									</td>
									<td>
										<b>Location</b>
									</td>
								</tr>
								<c:forEach var="event" items="${sessionScope.events}" varStatus="status">
								<tr>
									<td>
										<c:out value="${event.markerLabel}" />	
									</td>
									<td>
										<c:out value="${event.title}" />
									</td>
									<td>
										<c:out value="${event.startDateLabel}" />
									</td>
									<td>
										<c:out value="${event.endDateLabel}" />
									</td>
									<td>
										<c:out value="${event.location}" />
									</td>
								</tr>
								</c:forEach>
							</table>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<form action="<%= request.getContextPath()%>/NewEvent" method="post">
								<table style="padding-top:20px;">
									<tr>
										<td>
											Event Title
										</td>
										<td colspan="5">
											<input type="text" name="eventTitle" size="60" />
										</td>
									</tr>
									<tr>
										<td>
											Event Duration
										</td>
										<td>
											<input type="text" name="dateFrom" size="10" />
										</td>
										<td>
											<input type="text" name="dateFromTime" size="10" />
										</td>
										<td>
											to
										</td>
										<td>
											<input type="text" name="dateTo" size="10" />
										</td>
										<td>
											<input type="text" name="dateToTime" size="10" />
										</td>
									</tr>
									<tr>
										<td valign="top">
											Event Location
										</td>
										<td colspan="5">
											<input type="text" name="eventLocation" />
										</td>
									</tr>
									<tr>
										<td valign="top">
											Event Description
										</td>
										<td colspan="5">
											<textarea rows="7" cols="45" name="eventDescription"></textarea>
										</td>
									</tr>
									<tr>
										<td colspan="6">
											<input type="submit" value="Add Event" />
										</td>
									</tr>
								</table>
							</form>
						</td>
					</tr>				
				</table>
			</td>
		</tr>
		<tr>
			<td colspan="3">
				<b>Related Images</b>
			</td>
		</tr>
		<c:forEach var="event" items="${sessionScope.events}" varStatus="status">
		<tr style="padding-top: 10px;">
			<td colspan="3">
				<img src="<c:out value="${event.imageUrl}" />" title="<c:out value="${event.location}" />" />
			</td>
		</tr>
		</c:forEach>
	</table>	
</body>
</html>