package tntbot.core.notification;


import tntbot.core.message.MessageFormatType;

/**
 * Notification sent to a room
 */
public class Notification {
	private String message;
	private NotificationColorType color;
	private MessageFormatType messageType;
	private boolean notify;

	protected Notification(NotificationBuilder builder) {
		this.message = builder.getMessage();
		this.color = builder.getColor();
		this.notify = builder.isNotify();
		this.messageType = builder.getMessageType();
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

	public MessageFormatType getMessageType() {
		return messageType;
	}
}
