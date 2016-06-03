package tntbot.webhook.event.message;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import tntbot.webhook.event.WebhookEvent;

@JsonDeserialize(builder = WebhookMessageEventBuilder.class)
public class WebhookMessageEvent extends WebhookEvent {
	private WebhookMessageEventContent content;
	
	protected WebhookMessageEvent(WebhookMessageEventBuilder builder) {
		super(builder);
		this.content = builder.getContent();
	}

	public WebhookMessageEventContent getContent() {
		return content;
	}
}
