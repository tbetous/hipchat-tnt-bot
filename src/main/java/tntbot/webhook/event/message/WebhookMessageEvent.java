package tntbot.webhook.event.message;

import tntbot.webhook.event.WebhookEvent;

public class WebhookMessageEvent extends WebhookEvent {
	private WebhookMessageEventContent content;
	
	protected WebhookMessageEvent(WebhookMessageEventBuilder builder) {
		this.content = builder.getContent();
	}

	public WebhookMessageEventContent getContent() {
		return content;
	}
}
