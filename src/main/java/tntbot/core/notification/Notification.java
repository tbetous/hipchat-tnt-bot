package tntbot.core.notification;


/**
 * Notification sent to a room
 */
public class Notification {
	private String message;
	private NotificationColorType color;
	private boolean notify;

	public static Notification newErrorNotification(String message) {
		return new NotificationBuilder()
				.withColor(NotificationColorType.RED)
				.withNotify(false)
				.withMessage(message)
				.build();
	}
	
	protected Notification(NotificationBuilder builder) {
		this.message = builder.getMessage();
		this.color = builder.getColor();
		this.notify = builder.isNotify();
	}
	
	public NotificationColorType getColor() {
		return color;
	}
	
	public String getMessage() {
		return message;
	}
	
	public boolean isNotify() {
		return notify;
	}
}
