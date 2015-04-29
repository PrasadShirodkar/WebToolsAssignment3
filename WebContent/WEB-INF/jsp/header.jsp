<jsp:useBean id="USER_INFO" type="pshirodkar.edu.neu.coe.assignment3.bean.LoginBean" scope="session" />

<div style="clear: none; position: relative; height: 20px;">
	<div style="float: left; clear: both;">
		<table>
			<tr>
				<td><a href="<%= request.getContextPath()%>/SelectCalendar">Select Calendar</a></td>		
			</tr>
		</table>
	</div>
	
	<div style="float: right;">
		<table>
			<tr>
				<td>Logged-in user:</td>
				<td><b><jsp:getProperty property="userName" name="USER_INFO" /></b></td>
				<td>|</td>
				<td><a href="<%= request.getContextPath()%>/Logout">Sign out</a></td>
			</tr>
		</table>
	</div>
</div>
<hr color="sienna">