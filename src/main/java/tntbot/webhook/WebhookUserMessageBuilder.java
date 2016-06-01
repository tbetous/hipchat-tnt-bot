package tntbot.webhook;

import java.util.List;

public class WebhookUserMessageBuilder {
	private String id;
	private WebhookUser sender;
	private List<WebhookUser> mentions;
	private String message;
	
	public String getId() {
		return id;
	}
	
	public WebhookUserMessageBuilder withId(String id) {
		this.id = id;
		return this;
	}
	
	public WebhookUser getSender() {
		return sender;
	}
	
	public WebhookUserMessageBuilder withSender(WebhookUser sender) {
		this.sender = sender;
		return this;
	}
	
	public List<WebhookUser> getMentions() {
		return mentions;
	}
	
	public WebhookUserMessageBuilder withMentions(List<WebhookUser> mentions) {
		this.mentions = mentions;
		return this;
	}
	
	public String getMessage() {
		return message;
	}
	
	public WebhookUserMessageBuilder withMessage(String message) {
		this.message = message;
		return this;
	}
	
	public WebhookUserMessage build() {
		return new WebhookUserMessage(this);
	}
}
