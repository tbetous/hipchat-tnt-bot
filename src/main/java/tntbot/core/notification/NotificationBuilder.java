package tntbot.core.notification;

import tntbot.core.message.MessageFormatType;

public class NotificationBuilder {
	private String message = "";
	private NotificationColorType color = NotificationColorType.RANDOM;
	private MessageFormatType messageType = MessageFormatType.TEXT;
	private boolean notify = false;

	
	public NotificationColorType getColor() {
		return color;
	}

	public NotificationBuilder withColor(NotificationColorType color) {
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

	public MessageFormatType getMessageType() {
		return messageType;
	}

	public NotificationBuilder withMessageType(MessageFormatType messageType) {
		this.messageType = messageType;
		return this;
	}
	
	public Notification build() {
		return new Notification(this);
	}

}
