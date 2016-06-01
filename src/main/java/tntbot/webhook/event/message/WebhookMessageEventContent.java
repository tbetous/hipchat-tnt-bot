package tntbot.webhook.event.message;

import tntbot.webhook.WebhookRoom;
import tntbot.webhook.WebhookUserMessage;

public class WebhookMessageEventContent {
	private WebhookUserMessage message;
	private WebhookRoom room;
	
	protected WebhookMessageEventContent(WebhookMessageEventContentBuilder builder) {
		this.message = builder.getMessage();
		this.room = builder.getRoom();
	}
	
	public WebhookUserMessage getMessage() {
		return message;
	}
	
	public WebhookRoom getRoom() {
		return room;
	}
}
