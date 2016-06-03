package tntbot.webhook;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import tntbot.core.RoomPrivacy;

@JsonDeserialize(builder = WebhookRoomBuilder.class)
public class WebhookRoom {
	private Long id;
	private String name;
	private boolean archived;
	private WebhookLinks links;
	private RoomPrivacy privacy;
	private String version;
	
	protected WebhookRoom(WebhookRoomBuilder builder) {
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
	
	public RoomPrivacy getPrivacy() {
		return privacy;
	}
	
	public String getVersion() {
		return version;
	}
}
