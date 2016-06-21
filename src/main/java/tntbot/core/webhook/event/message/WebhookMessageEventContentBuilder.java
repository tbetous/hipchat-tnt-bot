package tntbot.core.webhook.event.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import tntbot.core.room.Room;
import tntbot.core.webhook.UserMessage;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPOJOBuilder(buildMethodName = "build", withPrefix = "with")
public class WebhookMessageEventContentBuilder {
	private UserMessage userMessage;
	private Room room;

	public UserMessage getUserMessage() {
		return userMessage;
	}

	@JsonProperty(value = "message")
	public WebhookMessageEventContentBuilder withUserMessage(UserMessage userMessage) {
		this.userMessage = userMessage;
		return this;
	}

	public Room getRoom() {
		return room;
	}

	@JsonProperty(value = "room")
	public WebhookMessageEventContentBuilder withRoom(Room room) {
		this.room = room;
		return this;
	}

	public WebhookMessageEventContent build() {
		return new WebhookMessageEventContent(this);
	}
}
