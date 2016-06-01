package tntbot.webhook;

public class WebhookUser {
	private long id;
	private WebhookLinks links;
	private String mentionName;
	private String name;
	private String version;
	
	protected WebhookUser(WebhookUserBuilder builder) {
		this.id = builder.getId();
		this.links = builder.getLinks();
		this.mentionName = builder.getMentionName();
		this.name = builder.getName();
		this.version = builder.getVersion();
	}
	
	protected long getId() {
		return id;
	}
	protected WebhookLinks getLinks() {
		return links;
	}
	protected String getMentionName() {
		return mentionName;
	}
	protected String getName() {
		return name;
	}
	protected String getVersion() {
		return version;
	}
	
	
}
