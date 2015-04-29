package pshirodkar.edu.neu.coe.assignment3.bo;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import pshirodkar.edu.neu.coe.assignment3.constants.ReferenceConstants;

import com.google.gdata.client.calendar.CalendarService;
import com.google.gdata.data.calendar.CalendarEntry;
import com.google.gdata.data.calendar.CalendarFeed;
import com.google.gdata.util.ServiceException;

/**
 * This business object provides the methods to retrieve the user's calendars.
 * 
 * @author Prasad
 * 
 */
public class GoogleCalendarBO {

	// The URL for the allcalendars feed of the specified user.
	// (e.g.
	// http://www.googe.com/feeds/calendar/jdoe@gmail.com/allcalendars/full)
	private URL allcalendarsFeedUrl = null;

	// The URL for the owncalendars feed of the specified user.
	// (e.g.
	// http://www.googe.com/feeds/calendar/jdoe@gmail.com/owncalendars/full)
	private URL owncalendarsFeedUrl = null;

	/**
	 * Default constructor
	 * 
	 * @throws MalformedURLException
	 */
	public GoogleCalendarBO() throws MalformedURLException {

		allcalendarsFeedUrl = new URL(ReferenceConstants.ALLCALENDARS_FEED_URL_);
		owncalendarsFeedUrl = new URL(ReferenceConstants.OWNCALENDARS_FEED_URL);
	}

	/**
	 * This method retrieves all primary, secondary, and imported calendars of
	 * the user.
	 * 
	 * @param calendarService
	 * @return
	 * @throws IOException
	 * @throws ServiceException
	 */
	public CalendarFeed fetchAllCalendars(CalendarService calendarService)
			throws IOException, ServiceException {

		CalendarFeed calendarFeed = calendarService.getFeed(
				allcalendarsFeedUrl, CalendarFeed.class);

		return calendarFeed;
	}

	/**
	 * This method retrieves the list of calendars that the authenticated user
	 * has owner access to.
	 * 
	 * @param calendarService
	 * @return
	 * @throws IOException
	 * @throws ServiceException
	 */
	public CalendarFeed fetchOwnCalendars(CalendarService calendarService)
			throws IOException, ServiceException {

		CalendarFeed calendarFeed = calendarService.getFeed(
				owncalendarsFeedUrl, CalendarFeed.class);

		return calendarFeed;
	}

	public CalendarEntry getCalendar(String calendarName) {

		CalendarEntry calendarEntry = null;

		return calendarEntry;
	}

	public void updateCalendar() {

	}

	public void deleteCalendar() {

	}
}