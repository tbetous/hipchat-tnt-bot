package tntbot.webhook;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPOJOBuilder(buildMethodName = "build", withPrefix = "with")
public class WebhookUserBuilder {
	private Long id;
	private WebhookLinks links;
	private String mentionName;
	private String name;
	private String version;
	
	public Long getId() {
		return id;
	}

	@JsonProperty(value = "id")
	public WebhookUserBuilder withId(Long id) {
		this.id = id;
		return this;
	}
	
	public WebhookLinks getLinks() {
		return links;
	}

	@JsonProperty(value = "links")
	public WebhookUserBuilder withLinks(WebhookLinks links) {
		this.links = links;
		return this;
	}
	
	public String getMentionName() {
		return mentionName;
	}

	@JsonProperty(value = "mention_name")
	public WebhookUserBuilder withMentionName(String mentionName) {
		this.mentionName = mentionName;
		return this;
	}
	
	public String getName() {
		return name;
	}

	@JsonProperty(value = "name")
	public WebhookUserBuilder withName(String name) {
		this.name = name;
		return this;
	}
	
	public String getVersion() {
		return version;
	}

	@JsonProperty(value = "version")
	public WebhookUserBuilder withVersion(String version) {
		this.version = version;
		return this;
	}
	
	public WebhookUser build() {
		return new WebhookUser(this);
	}
}
