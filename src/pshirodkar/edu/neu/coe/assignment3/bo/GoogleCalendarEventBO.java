package pshirodkar.edu.neu.coe.assignment3.bo;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import pshirodkar.edu.neu.coe.assignment3.bean.EventBean;
import pshirodkar.edu.neu.coe.assignment3.constants.ReferenceConstants;

import com.google.gdata.client.calendar.CalendarService;
import com.google.gdata.data.DateTime;
import com.google.gdata.data.PlainTextConstruct;
import com.google.gdata.data.calendar.CalendarEventEntry;
import com.google.gdata.data.calendar.CalendarEventFeed;
import com.google.gdata.data.extensions.When;
import com.google.gdata.data.extensions.Where;
import com.google.gdata.util.ServiceException;

/**
 * This business object provides the methods to retrieve the events in a user's
 * calendar.
 * 
 * @author Prasad
 * 
 */
public class GoogleCalendarEventBO {

	/**
	 * This method fetches all the events in a given calendar.
	 * 
	 * @param calendarService
	 * @param userName
	 * @return
	 * @throws IOException
	 * @throws ServiceException
	 */
	public List<EventBean> fetchAllEventsInCalendar(
			CalendarService calendarService, String calendarName,
			String userName) throws IOException, ServiceException {

		URL eventFeedUrl = new URL(ReferenceConstants.EVENT_FEED_URL_PREFIX
				+ calendarName + ReferenceConstants.EVENT_FEED_URL_SUFFIX);

		CalendarEventFeed calendarEventFeed = calendarService.getFeed(
				eventFeedUrl, CalendarEventFeed.class);

		List<EventBean> eventList = copyEventList(calendarEventFeed);

		return eventList;
	}

	public CalendarEventEntry addEventInCalendar(
			CalendarService calendarService, String calendarId,
			EventBean eventBean) throws IOException, ServiceException {

		URL eventUrl = new URL(ReferenceConstants.EVENT_FEED_URL_PREFIX
				+ calendarId + ReferenceConstants.EVENT_FEED_URL_SUFFIX);

		CalendarEventEntry newEventEntry = new CalendarEventEntry();

		// Set event title
		newEventEntry.setTitle(new PlainTextConstruct(eventBean.getTitle()));

		// Set event duration
		DateTime startTime = DateTime.parseDateTime(eventBean.getDateFrom()
				+ "T" + eventBean.getDateFromTime());
		DateTime endTime = DateTime.parseDateTime(eventBean.getDateTo() + "T"
				+ eventBean.getDateToTime());
		When eventTimes = new When();
		eventTimes.setStartTime(startTime);
		eventTimes.setEndTime(endTime);
		newEventEntry.addTime(eventTimes);

		// Set event location
		Where where = new Where();
		where.setValueString(eventBean.getLocation());
		newEventEntry.addLocation(where);

		// Set event description
		/*newEventEntry.getTextContent().setContent(
				new PlainTextConstruct(eventBean.getDescription()));*/

		// Send the request and receive the response:
		CalendarEventEntry insertedEntry = calendarService.insert(eventUrl,
				newEventEntry);

		return insertedEntry;
	}

	private List<EventBean> copyEventList(CalendarEventFeed calendarEventFeed) {

		List<EventBean> eventList = new ArrayList<EventBean>();

		if (calendarEventFeed.getEntries() != null
				&& !calendarEventFeed.getEntries().isEmpty()) {

			for (CalendarEventEntry eventEntry : calendarEventFeed.getEntries()) {

				EventBean eventBean = new EventBean();
				eventBean.setTitle(eventEntry.getTitle().getPlainText());
				eventBean.setStartDateLabel(eventEntry.getTimes().get(0)
						.getStartTime().toUiString());
				eventBean.setEndDateLabel(eventEntry.getTimes().get(0)
						.getEndTime().toUiString());
				eventBean.setLocation(eventEntry.getLocations().get(0)
						.getValueString());
				eventBean.setDescription(eventEntry.getTextContent()
						.getContent().getPlainText());

				eventList.add(eventBean);
			}
		}

		return eventList;
	}

	public static void main(String[] args) {

		DateTime startTime = DateTime.parseDateTime("2006-04-17T15:00:00");

		CalendarEventEntry newEventEntry = new CalendarEventEntry();

		When eventTimes = new When();
		eventTimes.setStartTime(startTime);
		newEventEntry.addTime(eventTimes);

		System.out.println(newEventEntry.getTimes().get(0).getStartTime()
				.toUiString());
	}
}