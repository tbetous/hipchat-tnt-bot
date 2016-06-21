package tntbot.core.webhook;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = WebhookLinksBuilder.class)
public class WebhookLinks {
	private String members;
	private String participants;
	private String self;
	private String webhooks;
	
	protected WebhookLinks(WebhookLinksBuilder builder) {
		this.members = builder.getMembers();
		this.participants = builder.getParticipants();
		this.self = builder.getSelf();
		this.webhooks = builder.getWebhooks();
	}
	
	public String getMembers() {
		return members;
	}
	
	public String getParticipants() {
		return participants;
	}
	
	public String getSelf() {
		return self;
	}
	
	public String getWebhooks() {
		return webhooks;
	}
}
