package tntbot.core.webhook.event.message;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import tntbot.core.room.Room;
import tntbot.core.webhook.UserMessage;

@JsonDeserialize(builder = WebhookMessageEventContentBuilder.class)
public class WebhookMessageEventContent {
	private UserMessage userMessage;
	private Room room;
	
	protected WebhookMessageEventContent(WebhookMessageEventContentBuilder builder) {
		this.userMessage = builder.getUserMessage();
		this.room = builder.getRoom();
	}
	
	public UserMessage getUserMessage() {
		return userMessage;
	}
	
	public Room getRoom() {
		return room;
	}
}
