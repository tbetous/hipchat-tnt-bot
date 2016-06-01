package tntbot.core;

public class NotificationBuilder {
	private String message = "";
	private NotificationColor color = NotificationColor.RANDOM;
	private boolean notify = false;
	
	public NotificationColor getColor() {
		return color;
	}

	public NotificationBuilder withColor(NotificationColor color) {
		this.color = color;
		return this;
	}
	
	public String getMessage() {
		return message;
	}
	
	public NotificationBuilder withMessage(String message) {
		this.message = message;
		return this;
	}
	
	public boolean isNotify() {
		return notify;
	}

	public NotificationBuilder withNotify(boolean notify) {
		this.notify = notify;
		return this;
	}
	
	public Notification build() {
		return new Notification(this);
	}
}
