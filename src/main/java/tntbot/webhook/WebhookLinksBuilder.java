package tntbot.webhook;

public class WebhookLinksBuilder {
	private String members;
	private String participants;
	private String self;
	private String webhooks;
	
	public String getMembers() {
		return members;
	}
	
	public WebhookLinksBuilder withMembers(String members) {
		this.members = members;
		return this;
	}
	
	public String getParticipants() {
		return participants;
	}
	
	public WebhookLinksBuilder withParticipants(String participants) {
		this.participants = participants;
		return this;
	}
	
	public String getSelf() {
		return self;
	}
	
	public WebhookLinksBuilder withSelf(String self) {
		this.self = self;
		return this;
	}
	
	public String getWebhooks() {
		return webhooks;
	}
	
	public WebhookLinksBuilder withWebhooks(String webhooks) {
		this.webhooks = webhooks;
		return this;
	}
	
	public WebhookLinks build() {
		return new WebhookLinks(this);
	}
}
