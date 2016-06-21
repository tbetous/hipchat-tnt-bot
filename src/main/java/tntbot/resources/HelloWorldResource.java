package tntbot.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import tntbot.core.notification.Notification;
import tntbot.core.notification.NotificationBuilder;
import tntbot.core.notification.NotificationColorType;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HelloWorldResource {

	@POST
	public Notification hello() {
		return new NotificationBuilder()
			.withMessage("Hello world !")
			.withNotify(true)
			.withColor(NotificationColorType.GREEN)
			.build();
	}
	
}