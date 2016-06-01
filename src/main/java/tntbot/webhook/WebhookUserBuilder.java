package tntbot.webhook;

public class WebhookUserBuilder {
	private long id;
	private WebhookLinks links;
	private String mentionName;
	private String name;
	private String version;
	
	public long getId() {
		return id;
	}
	
	public WebhookUserBuilder withId(long id) {
		this.id = id;
		return this;
	}
	
	public WebhookLinks getLinks() {
		return links;
	}
	
	public WebhookUserBuilder withLinks(WebhookLinks links) {
		this.links = links;
		return this;
	}
	
	public String getMentionName() {
		return mentionName;
	}
	
	public WebhookUserBuilder withMentionName(String mentionName) {
		this.mentionName = mentionName;
		return this;
	}
	
	public String getName() {
		return name;
	}
	
	public WebhookUserBuilder withName(String name) {
		this.name = name;
		return this;
	}
	
	public String getVersion() {
		return version;
	}
	
	public WebhookUserBuilder withVersion(String version) {
		this.version = version;
		return this;
	}
	
	public WebhookUser build() {
		return new WebhookUser(this);
	}
}
