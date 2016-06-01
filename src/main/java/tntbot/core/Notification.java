package tntbot.core;

import com.fasterxml.jackson.annotation.JsonGetter;

/**
 * Notification sent to a room
 */
public class Notification {
	private NotificationColor color;
	private String message;
	private boolean notify;
	
	protected Notification(NotificationBuilder builder) {
		this.message = builder.getMessage();
		this.color = builder.getColor();
		this.notify = builder.isNotify();
	}
	
	public NotificationColor getColor() {
		return color;
	}

	@JsonGetter(value = "color")
	public String getColorValue() {
		return color.getValue();
	}
	
	public String getMessage() {
		return message;
	}
	
	public boolean isNotify() {
		return notify;
	}
}
