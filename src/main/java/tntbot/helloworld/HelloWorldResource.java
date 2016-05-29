package tntbot.helloworld;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import tntbot.core.Notification;
import tntbot.core.NotificationBuilder;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HelloWorldResource {

	@POST
	public Notification hello() {
		return new NotificationBuilder()
			.withMessage("Hello world !")
			.withNotify(true)
			.withColor("green")
			.build();
	}
	
}