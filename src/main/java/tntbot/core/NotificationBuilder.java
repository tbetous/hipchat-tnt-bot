package tntbot.core;

public class NotificationBuilder {
	private String color;
	private String message;
	private boolean notify;
	
	public NotificationBuilder withColor(String color) {
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
