package tntbot.core;

public class NotificationBuilder {
	private String message = "";
	private NotificationColor color = NotificationColor.RANDOM;
	private boolean notify = false;

	public NotificationBuilder withColor(NotificationColor color) {
		this.color = color;
		return this;
	}
	
	public NotificationBuilder withMessage(String message) {
		this.message = message;
		return this;
	}

	public NotificationBuilder withNotify(boolean notify) {
		this.notify = notify;
		return this;
	}
	
	public Notification build() {
		Notification result = new Notification();
		result.setMessage(message);
		result.setColor(color);
		result.setNotify(notify);
		
		return result;
	}
}
