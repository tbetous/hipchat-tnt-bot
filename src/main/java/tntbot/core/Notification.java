package tntbot.core;

import com.fasterxml.jackson.annotation.JsonGetter;

/**
 * Notification sent to a room
 */
public class Notification {
	private NotificationColor color;
	private String message;
	private boolean notify;
	
	protected Notification(){}
	
	public NotificationColor getColor() {
		return color;
	}

	@JsonGetter(value = "color")
	public String getColorValue() {
		return color.getValue();
	}
	
	protected void setColor(NotificationColor color) {
		this.color = color;
	}
	
	public String getMessage() {
		return message;
	}
	
	protected void setMessage(String message) {
		this.message = message;
	}
	
	public boolean isNotify() {
		return notify;
	}

	protected void setNotify(boolean notify) {
		this.notify = notify;
	}
}
