package tntbot.webhook.event;

public abstract class WebhookEventBuilder {
	private String event;
	private String oauthClientId;
	private long webhookId;
	
	public String getEvent() {
		return event;
	}
	
	public WebhookEventBuilder withEvent(String event) {
		this.event = event;
		return this;
	}
	
	public String getOauthClientId() {
		return oauthClientId;
	}
	
	public WebhookEventBuilder withOauthClientId(String oauthClientId) {
		this.oauthClientId = oauthClientId;
		return this;
	}
	
	public long getWebhookId() {
		return webhookId;
	}
	
	public WebhookEventBuilder withWebhookId(long webhookId) {
		this.webhookId = webhookId;
		return this;
	}
}
