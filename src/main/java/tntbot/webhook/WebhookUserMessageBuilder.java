package tntbot.webhook;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPOJOBuilder(buildMethodName = "build", withPrefix = "with")
public class WebhookUserMessageBuilder {
	private String id;
	private WebhookUser sender;
	private List<WebhookUser> mentions;
	private String message;
	
	public String getId() {
		return id;
	}

	@JsonProperty(value = "id")
	public WebhookUserMessageBuilder withId(String id) {
		this.id = id;
		return this;
	}
	
	public WebhookUser getSender() {
		return sender;
	}

	@JsonProperty(value = "from")
	public WebhookUserMessageBuilder withSender(WebhookUser sender) {
		this.sender = sender;
		return this;
	}
	
	public List<WebhookUser> getMentions() {
		return mentions;
	}

	@JsonProperty(value = "mentions")
	public WebhookUserMessageBuilder withMentions(List<WebhookUser> mentions) {
		this.mentions = mentions;
		return this;
	}
	
	public String getMessage() {
		return message;
	}

	@JsonProperty(value = "message")
	public WebhookUserMessageBuilder withMessage(String message) {
		this.message = message;
		return this;
	}
	
	public WebhookUserMessage build() {
		return new WebhookUserMessage(this);
	}
}
