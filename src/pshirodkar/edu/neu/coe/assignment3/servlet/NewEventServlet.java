package pshirodkar.edu.neu.coe.assignment3.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gdata.client.calendar.CalendarService;
import com.google.gdata.data.calendar.CalendarEntry;
import com.google.gdata.util.ServiceException;

import pshirodkar.edu.neu.coe.assignment3.bean.EventBean;
import pshirodkar.edu.neu.coe.assignment3.bo.GoogleCalendarEventBO;
import pshirodkar.edu.neu.coe.assignment3.constants.ReferenceConstants;

/**
 * The purpose of this servlet is to display the calendar details.
 * 
 * @author Prasad
 * 
 */
public class NewEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewEventServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		EventBean eventBean = new EventBean();
		eventBean.setTitle(request.getParameter("eventTitle"));
		eventBean.setDateFrom(request.getParameter("dateFrom"));
		eventBean.setDateFromTime(request.getParameter("dateFromTime"));
		eventBean.setDateTo(request.getParameter("dateTo"));
		eventBean.setDateToTime(request.getParameter("dateToTime"));
		eventBean.setLocation(request.getParameter("eventLocation"));
		eventBean.setDescription(request.getParameter("eventDescription"));

		CalendarService calendarService = (CalendarService) request
				.getSession().getAttribute(
						ReferenceConstants.CALENDAR_SERVICE_INFO);

		CalendarEntry calendarEntry = (CalendarEntry) request.getSession()
				.getAttribute(ReferenceConstants.CALENDAR_SELECTED);

		GoogleCalendarEventBO eventBO = new GoogleCalendarEventBO();
		try {
			eventBO.addEventInCalendar(calendarService, calendarEntry.getId()
					.substring(calendarEntry.getId().lastIndexOf("/") + 1),
					eventBean);
		} catch (ServiceException e) {
			throw new RuntimeException(e);
		}

		request.getRequestDispatcher("/CalendarDetails")
				.forward(request, response);
	}
}
