package tntbot.helloworld;

import tntbot.core.Notification;
import tntbot.core.NotificationBuilder;
import tntbot.core.NotificationColor;
import tntbot.webhook.event.message.WebhookMessageEvent;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TestResource {

	@POST
	public Notification test(WebhookMessageEvent webhookMessageEvent) {
		webhookMessageEvent.toString();
		return null;
	}
	
}