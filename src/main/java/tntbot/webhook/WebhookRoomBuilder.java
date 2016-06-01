package tntbot.webhook;

import tntbot.core.RoomPrivacy;

public class WebhookRoomBuilder {
	private long id;
	private String name;
	private boolean archived;
	private WebhookLinks links;
	private RoomPrivacy privacy;
	private String version;
	
	public long getId() {
		return id;
	}
	
	public WebhookRoomBuilder withId(long id) {
		this.id = id;
		return this;
	}
	
	public String getName() {
		return name;
	}
	
	public WebhookRoomBuilder withName(String name) {
		this.name = name;
		return this;
	}
	
	public boolean isArchived() {
		return archived;
	}
	
	public WebhookRoomBuilder withArchived(boolean archived) {
		this.archived = archived;
		return this;
	}
	
	public WebhookLinks getLinks() {
		return links;
	}
	
	public WebhookRoomBuilder withLinks(WebhookLinks links) {
		this.links = links;
		return this;
	}
	
	public RoomPrivacy getPrivacy() {
		return privacy;
	}
	
	public WebhookRoomBuilder withPrivacy(RoomPrivacy privacy) {
		this.privacy = privacy;
		return this;
	}
	
	public String getVersion() {
		return version;
	}
	
	public WebhookRoomBuilder withVersion(String version) {
		this.version = version;
		return this;
	}
	
	public WebhookRoom build() {
		return new WebhookRoom(this);
	}
}
