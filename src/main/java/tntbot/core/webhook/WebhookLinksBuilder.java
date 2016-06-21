package tntbot.core.webhook;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPOJOBuilder(buildMethodName = "build", withPrefix = "with")
public class WebhookLinksBuilder {
	private String members;
	private String participants;
	private String self;
	private String webhooks;
	
	public String getMembers() {
		return members;
	}

	@JsonProperty(value = "members")
	public WebhookLinksBuilder withMembers(String members) {
		this.members = members;
		return this;
	}
	
	public String getParticipants() {
		return participants;
	}

	@JsonProperty(value = "participants")
	public WebhookLinksBuilder withParticipants(String participants) {
		this.participants = participants;
		return this;
	}
	
	public String getSelf() {
		return self;
	}

	@JsonProperty(value = "self")
	public WebhookLinksBuilder withSelf(String self) {
		this.self = self;
		return this;
	}
	
	public String getWebhooks() {
		return webhooks;
	}

	@JsonProperty(value = "webhooks")
	public WebhookLinksBuilder withWebhooks(String webhooks) {
		this.webhooks = webhooks;
		return this;
	}
	
	public WebhookLinks build() {
		return new WebhookLinks(this);
	}
}
