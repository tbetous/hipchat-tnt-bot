package tntbot.core;

import com.fasterxml.jackson.annotation.JsonGetter;

/**
 * Notification sent to a room
 */
public class Notification {
	private String message;
	private NotificationColor color;
	private boolean notify;
	
	protected Notification(NotificationBuilder builder) {
		this.message = builder.getMessage();
		this.color = builder.getColor();
		this.notify = builder.isNotify();
	}
	
	public NotificationColor getColor() {
		return color;
	}
	
	public String getMessage() {
		return message;
	}
	
	public boolean isNotify() {
		return notify;
	}
}
