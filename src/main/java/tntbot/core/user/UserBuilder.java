package tntbot.core.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import tntbot.core.webhook.WebhookLinks;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPOJOBuilder(buildMethodName = "build", withPrefix = "with")
public class UserBuilder {
	private Long id;
	private WebhookLinks links;
	private String mentionName;
	private String name;
	private String version;
	
	public Long getId() {
		return id;
	}

	@JsonProperty(value = "id")
	public UserBuilder withId(Long id) {
		this.id = id;
		return this;
	}
	
	public WebhookLinks getLinks() {
		return links;
	}

	@JsonProperty(value = "links")
	public UserBuilder withLinks(WebhookLinks links) {
		this.links = links;
		return this;
	}
	
	public String getMentionName() {
		return mentionName;
	}

	@JsonProperty(value = "mention_name")
	public UserBuilder withMentionName(String mentionName) {
		this.mentionName = mentionName;
		return this;
	}
	
	public String getName() {
		return name;
	}

	@JsonProperty(value = "name")
	public UserBuilder withName(String name) {
		this.name = name;
		return this;
	}
	
	public String getVersion() {
		return version;
	}

	@JsonProperty(value = "version")
	public UserBuilder withVersion(String version) {
		this.version = version;
		return this;
	}
	
	public User build() {
		return new User(this);
	}
}
