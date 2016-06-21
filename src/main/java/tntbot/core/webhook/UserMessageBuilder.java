package tntbot.core.webhook;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import tntbot.core.user.User;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPOJOBuilder(buildMethodName = "build", withPrefix = "with")
public class UserMessageBuilder {
	private String id;
	private User sender;
	private List<User> mentions;
	private String message;
	
	public String getId() {
		return id;
	}

	@JsonProperty(value = "id")
	public UserMessageBuilder withId(String id) {
		this.id = id;
		return this;
	}
	
	public User getSender() {
		return sender;
	}

	@JsonProperty(value = "from")
	public UserMessageBuilder withSender(User sender) {
		this.sender = sender;
		return this;
	}
	
	public List<User> getMentions() {
		return mentions;
	}

	@JsonProperty(value = "mentions")
	public UserMessageBuilder withMentions(List<User> mentions) {
		this.mentions = mentions;
		return this;
	}
	
	public String getMessage() {
		return message;
	}

	@JsonProperty(value = "message")
	public UserMessageBuilder withMessage(String message) {
		this.message = message;
		return this;
	}
	
	public UserMessage build() {
		return new UserMessage(this);
	}
}
