package tntbot.webhook.event.message;

import tntbot.webhook.event.WebhookEventBuilder;

public class WebhookMessageEventBuilder extends WebhookEventBuilder {
	private WebhookMessageEventContent content;

	public WebhookMessageEventContent getContent() {
		return content;
	}

	public WebhookMessageEventBuilder withContent(WebhookMessageEventContent content) {
		this.content = content;
		return this;
	}
	
	public WebhookMessageEvent build() {
		return new WebhookMessageEvent(this);
	}
}
