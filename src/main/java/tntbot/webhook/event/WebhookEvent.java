package tntbot.webhook.event;

public class WebhookEvent {
	private String event;
	private String oauthClientId;
	private Long webhookId;

	protected WebhookEvent(WebhookEventBuilder builder) {
		this.event = builder.getEvent();
		this.oauthClientId = builder.getOauthClientId();
		this.webhookId = builder.getWebhookId();
	}

	public String getEvent() {
		return event;
	}
	
	public String getOauthClientId() {
		return oauthClientId;
	}
	
	public Long getWebhookId() {
		return webhookId;
	}
}
