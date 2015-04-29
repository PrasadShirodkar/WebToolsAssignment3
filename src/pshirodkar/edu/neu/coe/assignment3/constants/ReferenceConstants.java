package pshirodkar.edu.neu.coe.assignment3.constants;

/**
 * This class defines the constants referenced in the application.
 * 
 * @author Prasad
 * 
 */
public interface ReferenceConstants {

	public static final String USER_INFO = "USER_INFO";

	public static final String CALENDAR_SERVICE_INFO = "CALENDAR_SERVICE_INFO";

	public static final String CALENDARS = "calendars";

	public static final String CALENDAR_SELECTED = "calendarSelected";

	public static final String EVENTS = "events";

	// The base URL for a user's calendar metafeed (needs a username appended).
	public static final String METAFEED_URL_BASE = "http://www.google.com/calendar/feeds/";

	public static final String ALLCALENDARS_FEED_URL_ = "https://www.google.com/calendar/feeds/default/allcalendars/full";

	public static final String OWNCALENDARS_FEED_URL = "https://www.google.com/calendar/feeds/default/owncalendars/full";

	public static final String EVENT_FEED_URL_PREFIX = "https://www.google.com/calendar/feeds/";

	public static final String EVENT_FEED_URL_SUFFIX = "/private/full";

	// The HEX representation of red, blue and green
	public static final String RED = "#A32929";
	public static final String BLUE = "#2952A3";
	public static final String GREEN = "#0D7813";

	/* Constants for Google Maps API start here */
	public static final String GOOGLE_STATIC_MAPS_API_URL = "http://maps.google.com/maps/api/staticmap?";

	public static final String GOOGLE_STATIC_MAPS_API_PARAM_SIZE = "size";

	public static final String GOOGLE_STATIC_MAPS_API_PARAM_MARKERS = "markers";

	public static final String GOOGLE_STATIC_MAPS_API_PARAM_MARKERS_COLOR = "color:";

	public static final String GOOGLE_STATIC_MAPS_API_PARAM_MARKERS_LABEL = "label:";

	public static final String GOOGLE_STATIC_MAPS_API_PARAM_SENSOR = "sensor";

	public static final String GOOGLE_STATIC_MAPS_API_CONSTANT_SIZE = "400x400";

	public static final String GOOGLE_MAPS = "GOOGLE_MAPS";

	public static final String CHARACTER_AMPERSAND = "&";

	public static final String CHARACTER_COMMA = ",";

	public static final String CHARACTER_PIPE = "|";

	public static final int CHARACTER_ASCII_A = 65;

	public static final String[] COLORS = { "blue", "red", "brown", "green",
			"orange", "pink", "red", "silver", "violet", "yellow" };
	/* Constants for Google Maps API end here */

	/* Constants for Flickr Photos Search API start here */
	public static final String FLICKR_PHOTOS_SEARCH_URL = "http://api.flickr.com/services/rest/?";

	public static final String FLICKR_PHOTOS_SEARCH_PARAM_API_KEY = "api_key";

	public static final String FLICKR_PHOTOS_SEARCH_PARAM_API_KEY_VALUE = "2e61b2d84bb4a910c878e0eee1e6033d";

	public static final String FLICKR_PHOTOS_SEARCH_PARAM_METHOD = "method";

	public static final String FLICKR_PHOTOS_SEARCH_PARAM_METHOD_VALUE = "flickr.photos.search";

	public static final String FLICKR_PHOTOS_SEARCH_PARAM_TAGS = "tags";

	public static final String FLICKR_PHOTOS_SEARCH_PARAM_GEO_CONTEXT = "geo_context";

	public static final String FLICKR_PHOTOS_SEARCH_PARAM_GEO_CONTEXT_VALUE_OUTDOORS = "2";

	public static final String FLICKR_PHOTOS_SEARCH_PARAM_PER_PAGE = "per_page";

	public static final String FLICKR_PHOTOS_SEARCH_PARAM_PER_PAGE_VALUE = "1";

	public static final String FLICKR_PHOTOS_SEARCH_PARAM_PAGE = "page";

	public static final String FLICKR_PHOTOS_SEARCH_PARAM_PAGE_VALUE = "1";

	/* Constants for Flickr Photos Search API end here */

	/* Constants for Picasa Web Albums Data API end here */

	public static final String PICASA_WEB_ALBUMS_DATA_API_URL = "http://picasaweb.google.com/data/feed/api/all?";

	public static final String PICASA_WEB_ALBUMS_DATA_API_PARAM_Q = "q";

	public static final String PICASA_WEB_ALBUMS_DATA_API_PARAM_TAG = "tag";

	/* Constants for Picasa Web Albums Data API end here */

}