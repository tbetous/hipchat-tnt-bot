package tntbot.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tntbot.core.notification.Notification;
import tntbot.core.webhook.event.WebhookEvent;
import tntbot.core.webhook.event.message.WebhookMessageEventContent;
import tntbot.services.RandomPickUserService;

@Path("/random")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RandomPickUserResource {

	@Inject
	RandomPickUserService rpuService;

	@POST
	public Notification test(WebhookEvent<WebhookMessageEventContent> event) {
		return rpuService.randomPickUser(event);
	}
	
}