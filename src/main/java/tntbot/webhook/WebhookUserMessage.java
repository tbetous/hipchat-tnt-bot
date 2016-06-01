package tntbot.webhook;

import java.util.List;


public class WebhookUserMessage {
	private String id;
	private WebhookUser sender;
	private List<WebhookUser> mentions;
	private String message;
	
	protected WebhookUserMessage (WebhookUserMessageBuilder builder) {
		this.id = builder.getId();
		this.sender = builder.getSender();
		this.mentions = builder.getMentions();
		this.message = builder.getMessage();
	}
	
	public String getId() {
		return id;
	}
	
	public WebhookUser getSender() {
		return sender;
	}
	
	public List<WebhookUser> getMentions() {
		return mentions;
	}
	
	public String getMessage() {
		return message;
	}
}
