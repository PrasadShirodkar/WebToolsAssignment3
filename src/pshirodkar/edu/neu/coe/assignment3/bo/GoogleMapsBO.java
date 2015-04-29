package pshirodkar.edu.neu.coe.assignment3.bo;

import java.util.List;

import pshirodkar.edu.neu.coe.assignment3.bean.EventBean;
import pshirodkar.edu.neu.coe.assignment3.constants.ReferenceConstants;

/**
 * This business object is used to retrieve the location from the Google Maps
 * API for a given address.
 * 
 * @author Prasad
 * 
 */
public class GoogleMapsBO {

	/**
	 * This method constructs the url for a map for the calendar events.
	 * 
	 * @param mapResult
	 * @return String representing Google Static Maps API URL with the required
	 *         parameters.
	 */
	public String constructMapUrl(List<EventBean> eventList) {

		StringBuffer markersParam = new StringBuffer();
		markersParam.append(constructMarkersParameters(eventList));

		StringBuffer sizeParam = new StringBuffer();
		sizeParam
				.append(ReferenceConstants.GOOGLE_STATIC_MAPS_API_PARAM_SIZE
						+ "="
						+ ReferenceConstants.GOOGLE_STATIC_MAPS_API_CONSTANT_SIZE);

		StringBuffer sensorParam = new StringBuffer();
		sensorParam
				.append(ReferenceConstants.GOOGLE_STATIC_MAPS_API_PARAM_SENSOR
						+ "=" + Boolean.FALSE.toString());

		StringBuffer url = new StringBuffer();

		url.append(ReferenceConstants.GOOGLE_STATIC_MAPS_API_URL);
		url.append(markersParam);

		url.append(ReferenceConstants.CHARACTER_AMPERSAND);
		url.append(sizeParam);

		url.append(ReferenceConstants.CHARACTER_AMPERSAND);
		url.append(sensorParam);

		return url.toString();
	}

	/**
	 * This method constructs the parameters required for markers.
	 * 
	 * @param mapResult
	 * @return
	 */
	private String constructMarkersParameters(List<EventBean> eventList) {

		StringBuffer markersParam = new StringBuffer();

		if (eventList != null && !eventList.isEmpty()) {

			for (int i = 0; i < eventList.size(); i++) {

				markersParam
						.append(ReferenceConstants.GOOGLE_STATIC_MAPS_API_PARAM_MARKERS
								+ "=");

				markersParam
						.append(ReferenceConstants.GOOGLE_STATIC_MAPS_API_PARAM_MARKERS_COLOR);
				markersParam.append(ReferenceConstants.COLORS[i]);
				markersParam.append(ReferenceConstants.CHARACTER_PIPE);

				eventList.get(i).setColor(ReferenceConstants.COLORS[i]);

				markersParam
						.append(ReferenceConstants.GOOGLE_STATIC_MAPS_API_PARAM_MARKERS_LABEL);
				markersParam
						.append((char) (ReferenceConstants.CHARACTER_ASCII_A + i));
				markersParam.append(ReferenceConstants.CHARACTER_PIPE);

				eventList.get(i).setMarkerLabel(String.valueOf(
						((char)(ReferenceConstants.CHARACTER_ASCII_A + i))));

				markersParam.append(eventList.get(i).getLocation());

				if (i < (eventList.size() - 1)) {
					markersParam.append(ReferenceConstants.CHARACTER_AMPERSAND);
				}
			}
		}

		return markersParam.toString();
	}
}