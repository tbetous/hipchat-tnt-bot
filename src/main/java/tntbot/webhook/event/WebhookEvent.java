package tntbot.webhook.event;

public abstract class WebhookEvent {
	private String event;
	private String oauthClientId;
	private long webhookId;
	
	public String getEvent() {
		return event;
	}
	
	public String getOauthClientId() {
		return oauthClientId;
	}
	
	public long getWebhookId() {
		return webhookId;
	}
}
