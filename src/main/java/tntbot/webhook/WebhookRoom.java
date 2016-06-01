package tntbot.webhook;

import tntbot.core.RoomPrivacy;

public class WebhookRoom {
	private long id;
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
	
	public long getId() {
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
