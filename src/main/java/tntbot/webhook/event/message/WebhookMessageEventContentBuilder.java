package tntbot.webhook.event.message;

import tntbot.webhook.WebhookRoom;
import tntbot.webhook.WebhookUserMessage;

public class WebhookMessageEventContentBuilder {
	private WebhookUserMessage message;
	private WebhookRoom room;
	
	public WebhookUserMessage getMessage() {
		return message;
	}
	public WebhookMessageEventContentBuilder withMessage(WebhookUserMessage message) {
		this.message = message;
		return this;
	}
	public WebhookRoom getRoom() {
		return room;
	}
	public WebhookMessageEventContentBuilder withRoom(WebhookRoom room) {
		this.room = room;
		return this;
	}
}
