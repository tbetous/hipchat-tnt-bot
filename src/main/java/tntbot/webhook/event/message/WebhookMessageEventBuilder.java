package tntbot.webhook.event.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import tntbot.webhook.event.WebhookEventBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPOJOBuilder(buildMethodName = "build", withPrefix = "with")
public class WebhookMessageEventBuilder extends WebhookEventBuilder {
	private WebhookMessageEventContent content;

	public WebhookMessageEventContent getContent() {
		return content;
	}

	@JsonProperty(value = "item")
	public WebhookMessageEventBuilder withContent(WebhookMessageEventContent content) {
		this.content = content;
		return this;
	}

	public WebhookMessageEvent build() {
		return new WebhookMessageEvent(this);
	}
}
