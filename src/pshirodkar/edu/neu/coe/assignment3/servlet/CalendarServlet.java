package pshirodkar.edu.neu.coe.assignment3.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pshirodkar.edu.neu.coe.assignment3.bean.EventBean;
import pshirodkar.edu.neu.coe.assignment3.bean.LoginBean;
import pshirodkar.edu.neu.coe.assignment3.bo.GoogleCalendarBO;
import pshirodkar.edu.neu.coe.assignment3.bo.GoogleCalendarEventBO;
import pshirodkar.edu.neu.coe.assignment3.bo.GoogleMapsBO;
import pshirodkar.edu.neu.coe.assignment3.bo.PicasaPhotosBO;
import pshirodkar.edu.neu.coe.assignment3.constants.ReferenceConstants;

import com.google.gdata.client.calendar.CalendarService;
import com.google.gdata.data.calendar.CalendarEntry;
import com.google.gdata.data.calendar.CalendarFeed;
import com.google.gdata.util.ServiceException;

/**
 * The purpose of this servlet is to display the calendar details.
 * 
 * @author Prasad
 * 
 */
public class CalendarServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalendarServlet() {
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

		String calendarIndex = request.getParameter("calendarIndex");

		GoogleCalendarBO calendarBO = new GoogleCalendarBO();
		CalendarService calendarService = (CalendarService) request
				.getSession().getAttribute(
						ReferenceConstants.CALENDAR_SERVICE_INFO);

		try {
			CalendarFeed calendarFeed = calendarBO
					.fetchOwnCalendars(calendarService);

			HttpSession session = request.getSession();

			CalendarEntry calendarEntry = null;
			if (calendarIndex != null && !calendarIndex.trim().equals("")) {

				int index = Integer.parseInt(calendarIndex);
				calendarEntry = calendarFeed.getEntries().get(index - 1);
				session.setAttribute(ReferenceConstants.CALENDAR_SELECTED,
						calendarEntry);
			} else if (session
					.getAttribute(ReferenceConstants.CALENDAR_SELECTED) != null) {
				calendarEntry = (CalendarEntry) session
						.getAttribute(ReferenceConstants.CALENDAR_SELECTED);
			}

			GoogleCalendarEventBO eventBO = new GoogleCalendarEventBO();

			LoginBean loginBean = (LoginBean) session
					.getAttribute(ReferenceConstants.USER_INFO);

			// Fetch all the events for the calendar
			List<EventBean> eventList = eventBO.fetchAllEventsInCalendar(
					calendarService,
					calendarEntry.getId().substring(
							calendarEntry.getId().lastIndexOf("/") + 1),
					loginBean.getUserName());

			session.setAttribute(ReferenceConstants.EVENTS, eventList);

			// Display the Google Maps for the calendar events
			GoogleMapsBO mapsBO = new GoogleMapsBO();
			session.setAttribute(ReferenceConstants.GOOGLE_MAPS,
					mapsBO.constructMapUrl(eventList));

			// Display the photos of the calendar events
			PicasaPhotosBO photosBO = new PicasaPhotosBO();
			photosBO.searchPhoto(loginBean.getUserName(),
					loginBean.getPassword(), eventList);

			request.getRequestDispatcher("/WEB-INF/jsp/CalendarDetails.jsp")
					.forward(request, response);

		} catch (ServiceException e) {
			throw new RuntimeException(e);
		}

	}
}