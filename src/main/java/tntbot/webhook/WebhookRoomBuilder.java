package tntbot.webhook;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import tntbot.core.RoomPrivacy;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPOJOBuilder(buildMethodName = "build", withPrefix = "with")
public class WebhookRoomBuilder {
	private Long id;
	private String name;
	private boolean archived;
	private WebhookLinks links;
	private RoomPrivacy privacy;
	private String version;
	
	public Long getId() {
		return id;
	}

	@JsonProperty(value = "id")
	public WebhookRoomBuilder withId(Long id) {
		this.id = id;
		return this;
	}
	
	public String getName() {
		return name;
	}

	@JsonProperty(value = "name")
	public WebhookRoomBuilder withName(String name) {
		this.name = name;
		return this;
	}
	
	public boolean isArchived() {
		return archived;
	}

	@JsonProperty(value = "is_archived")
	public WebhookRoomBuilder withArchived(boolean archived) {
		this.archived = archived;
		return this;
	}
	
	public WebhookLinks getLinks() {
		return links;
	}

	@JsonProperty(value = "links")
	public WebhookRoomBuilder withLinks(WebhookLinks links) {
		this.links = links;
		return this;
	}
	
	public RoomPrivacy getPrivacy() {
		return privacy;
	}

	@JsonProperty(value = "privacy")
	public WebhookRoomBuilder withPrivacy(RoomPrivacy privacy) {
		this.privacy = privacy;
		return this;
	}
	
	public String getVersion() {
		return version;
	}

	@JsonProperty(value = "version")
	public WebhookRoomBuilder withVersion(String version) {
		this.version = version;
		return this;
	}
	
	public WebhookRoom build() {
		return new WebhookRoom(this);
	}
}
