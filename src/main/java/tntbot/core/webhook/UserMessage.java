package tntbot.core.webhook;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import tntbot.core.user.User;

@JsonDeserialize(builder = UserMessageBuilder.class)
public class UserMessage {
	private String id;
	private User sender;
	private List<User> mentions;
	private String message;
	
	protected UserMessage(UserMessageBuilder builder) {
		this.id = builder.getId();
		this.sender = builder.getSender();
		this.mentions = builder.getMentions();
		this.message = builder.getMessage();
	}
	
	public String getId() {
		return id;
	}
	
	public User getSender() {
		return sender;
	}
	
	public List<User> getMentions() {
		return mentions;
	}
	
	public String getMessage() {
		return message;
	}
}
