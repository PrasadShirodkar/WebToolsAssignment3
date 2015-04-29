package pshirodkar.edu.neu.coe.assignment3.bean;

/**
 * This bean stores all the information for an event in the calendar.
 * 
 * @author Prasad
 *
 */
public class EventBean {
	
	private String title;
	
	private String dateFrom;
	
	private String dateFromTime;
	
	private String dateTo;
	
	private String dateToTime;
	
	private String location;
	
	private String description;
	
	private String startDateLabel;
	
	private String endDateLabel;
	
	private String markerLabel;
	
	private String color;
	
	private String imageUrl;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String eventTitle) {
		this.title = eventTitle;
	}

	public String getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public String getDateFromTime() {
		return dateFromTime;
	}

	public void setDateFromTime(String dateFromTime) {
		this.dateFromTime = dateFromTime;
	}

	public String getDateTo() {
		return dateTo;
	}

	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}

	public String getDateToTime() {
		return dateToTime;
	}

	public void setDateToTime(String dateToTime) {
		this.dateToTime = dateToTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String eventLocation) {
		this.location = eventLocation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String eventDescription) {
		this.description = eventDescription;
	}

	public String getStartDateLabel() {
		return startDateLabel;
	}

	public void setStartDateLabel(String startDateLabel) {
		this.startDateLabel = startDateLabel;
	}

	public String getEndDateLabel() {
		return endDateLabel;
	}

	public void setEndDateLabel(String endDateLabel) {
		this.endDateLabel = endDateLabel;
	}

	public String getMarkerLabel() {
		return markerLabel;
	}

	public void setMarkerLabel(String markerLabel) {
		this.markerLabel = markerLabel;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}