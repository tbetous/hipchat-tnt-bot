package tntbot.webhook.event.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import tntbot.webhook.WebhookRoom;
import tntbot.webhook.WebhookUserMessage;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPOJOBuilder(buildMethodName = "build", withPrefix = "with")
public class WebhookMessageEventContentBuilder {
	private WebhookUserMessage message;
	private WebhookRoom room;

	public WebhookUserMessage getMessage() {
		return message;
	}

	@JsonProperty(value = "message")
	public WebhookMessageEventContentBuilder withMessage(WebhookUserMessage message) {
		this.message = message;
		return this;
	}

	public WebhookRoom getRoom() {
		return room;
	}

	@JsonProperty(value = "room")
	public WebhookMessageEventContentBuilder withRoom(WebhookRoom room) {
		this.room = room;
		return this;
	}

	public WebhookMessageEventContent build() {
		return new WebhookMessageEventContent(this);
	}
}
