package tntbot.core.room;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import tntbot.core.webhook.WebhookLinks;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPOJOBuilder(buildMethodName = "build", withPrefix = "with")
public class RoomBuilder {
	private Long id;
	private String name;
	private boolean archived;
	private WebhookLinks links;
	private RoomPrivacyType privacy;
	private String version;
	
	public Long getId() {
		return id;
	}

	@JsonProperty(value = "id")
	public RoomBuilder withId(Long id) {
		this.id = id;
		return this;
	}
	
	public String getName() {
		return name;
	}

	@JsonProperty(value = "name")
	public RoomBuilder withName(String name) {
		this.name = name;
		return this;
	}
	
	public boolean isArchived() {
		return archived;
	}

	@JsonProperty(value = "is_archived")
	public RoomBuilder withArchived(boolean archived) {
		this.archived = archived;
		return this;
	}
	
	public WebhookLinks getLinks() {
		return links;
	}

	@JsonProperty(value = "links")
	public RoomBuilder withLinks(WebhookLinks links) {
		this.links = links;
		return this;
	}
	
	public RoomPrivacyType getPrivacy() {
		return privacy;
	}

	@JsonProperty(value = "privacy")
	public RoomBuilder withPrivacy(RoomPrivacyType privacy) {
		this.privacy = privacy;
		return this;
	}
	
	public String getVersion() {
		return version;
	}

	@JsonProperty(value = "version")
	public RoomBuilder withVersion(String version) {
		this.version = version;
		return this;
	}
	
	public Room build() {
		return new Room(this);
	}
}
