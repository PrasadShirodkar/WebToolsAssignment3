package pshirodkar.edu.neu.coe.assignment3.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pshirodkar.edu.neu.coe.assignment3.bo.GoogleCalendarBO;
import pshirodkar.edu.neu.coe.assignment3.constants.ReferenceConstants;

import com.google.gdata.client.calendar.CalendarService;
import com.google.gdata.data.calendar.CalendarFeed;
import com.google.gdata.util.ServiceException;

/**
 * The purpose of this servlet is to retrieve the list of calendars that the
 * authenticated user has owner access to.
 * 
 * @author Prasad
 * 
 */
public class CalendarSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalendarSelectServlet() {
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

		GoogleCalendarBO calendarBO = new GoogleCalendarBO();
		CalendarService calendarService = (CalendarService) request
				.getSession().getAttribute(
						ReferenceConstants.CALENDAR_SERVICE_INFO);
		try {
			CalendarFeed calendarFeed = calendarBO
					.fetchOwnCalendars(calendarService);

			request.setAttribute(ReferenceConstants.CALENDARS,
					calendarFeed.getEntries());

			request.getRequestDispatcher("/WEB-INF/jsp/SelectCalendar.jsp")
					.forward(request, response);

		} catch (ServiceException e) {
			throw new RuntimeException(e);
		}
	}

}
