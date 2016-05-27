package tntbot.helloworld;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tntbot.core.Notification;
import tntbot.core.NotificationBuilder;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HelloWorldResource {

	@GET
	public Notification hello() {
		return new NotificationBuilder()
			.withMessage("Hello world !")
			.withNotify(true)
			.withColor("green")
			.build();
	}
	
}