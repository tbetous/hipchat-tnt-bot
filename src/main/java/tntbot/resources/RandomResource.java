package tntbot.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tntbot.core.Notification;
import tntbot.core.NotificationBuilder;

@Path("/random")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RandomResource {

	@POST
	public Notification test(String message) {
		return new NotificationBuilder()
			.withMessage(message)
			.build();
	}
	
}