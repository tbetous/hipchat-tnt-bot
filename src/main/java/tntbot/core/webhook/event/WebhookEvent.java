package tntbot.core.webhook.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WebhookEvent<T> {
	private WebhookEventType event;
	private String oauthClientId;
	private Long webhookId;
	private T content;

    @JsonCreator
	public static <T> WebhookEvent<T> newInstance(
            @JsonProperty("event") WebhookEventType event,
            @JsonProperty("oauth_client_id") String oauthClientId,
            @JsonProperty("webhook_id") Long webhookId,
            @JsonProperty("item") T content) {
		return new WebhookEventBuilder()
                .withEvent(event)
                .withOauthClientId(oauthClientId)
                .withWebhookId(webhookId)
                .withContent(content)
                .build();
	}

	private WebhookEvent(WebhookEventBuilder<T> builder) {
		this.event = builder.getEvent();
		this.oauthClientId = builder.getOauthClientId();
		this.webhookId = builder.getWebhookId();
		this.content = builder.getContent();
	}

	public WebhookEventType getEvent() {
		return event;
	}
	
	public String getOauthClientId() {
		return oauthClientId;
	}
	
	public Long getWebhookId() {
		return webhookId;
	}

	public T getContent() {
		return content;
	}

	private static class WebhookEventBuilder<T> {
		private WebhookEventType event;
		private String oauthClientId;
		private Long webhookId;
		private T content;

		public WebhookEventType getEvent() {
			return event;
		}

		public WebhookEventBuilder withEvent(WebhookEventType event) {
			this.event = event;
			return this;
		}

		public String getOauthClientId() {
			return oauthClientId;
		}

		public WebhookEventBuilder withOauthClientId(String oauthClientId) {
			this.oauthClientId = oauthClientId;
			return this;
		}

		public Long getWebhookId() {
			return webhookId;
		}

		public WebhookEventBuilder withWebhookId(Long webhookId) {
			this.webhookId = webhookId;
			return this;
		}

		public T getContent() {
			return content;
		}

		public WebhookEventBuilder withContent(T content) {
			this.content = content;
			return this;
		}

        public WebhookEvent build() {
            return new WebhookEvent(this);
        }
	}
}
