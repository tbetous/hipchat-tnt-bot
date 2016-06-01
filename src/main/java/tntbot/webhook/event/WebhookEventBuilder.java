package tntbot.webhook.event;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class WebhookEventBuilder {
	private String event;
	private String oauthClientId;
	private Long webhookId;

	public String getEvent() {
		return event;
	}

	@JsonProperty(value = "event")
	public WebhookEventBuilder withEvent(String event) {
		this.event = event;
		return this;
	}
	
	public String getOauthClientId() {
		return oauthClientId;
	}

	@JsonProperty(value = "oauth_client_id")
	public WebhookEventBuilder withOauthClientId(String oauthClientId) {
		this.oauthClientId = oauthClientId;
		return this;
	}
	
	public Long getWebhookId() {
		return webhookId;
	}

	@JsonProperty(value = "webhook_id")
	public WebhookEventBuilder withWebhookId(Long webhookId) {
		this.webhookId = webhookId;
		return this;
	}
}
