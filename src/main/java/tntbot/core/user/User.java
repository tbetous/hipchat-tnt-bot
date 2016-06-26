package tntbot.core.user;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import tntbot.core.webhook.WebhookLinks;

@JsonDeserialize(builder = UserBuilder.class)
public class User {
	private Long id;
	private WebhookLinks links;
	private String mentionName;
	private String name;
	private String version;
	
	protected User(UserBuilder builder) {
		this.id = builder.getId();
		this.links = builder.getLinks();
		this.mentionName = builder.getMentionName();
		this.name = builder.getName();
		this.version = builder.getVersion();
	}

	public Long getId() {
		return id;
	}

	public WebhookLinks getLinks() {
		return links;
	}

	public String getMentionName() {
		return mentionName;
	}

	public String getAnnotedMentionName() {
		return "@" + mentionName;
	}

	public String getName() {
		return name;
	}

	public String getVersion() {
		return version;
	}
}
