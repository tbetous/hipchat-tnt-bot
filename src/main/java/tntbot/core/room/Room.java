package tntbot.core.room;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import tntbot.core.webhook.WebhookLinks;

@JsonDeserialize(builder = RoomBuilder.class)
public class Room {
	private Long id;
	private String name;
	private boolean archived;
	private WebhookLinks links;
	private RoomPrivacyType privacy;
	private String version;
	
	protected Room(RoomBuilder builder) {
		this.id = builder.getId();
		this.name = builder.getName();
		this.archived = builder.isArchived();
		this.links = builder.getLinks();
		this.privacy = builder.getPrivacy();
		this.version = builder.getVersion();
	}
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isArchived() {
		return archived;
	}
	
	public WebhookLinks getLinks() {
		return links;
	}
	
	public RoomPrivacyType getPrivacy() {
		return privacy;
	}
	
	public String getVersion() {
		return version;
	}
}
