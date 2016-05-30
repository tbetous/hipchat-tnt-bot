package tntbot.helloworld;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import tntbot.core.Notification;
import tntbot.core.NotificationColor;

public class HelloWorldResourceTest {
	
	@Test
	public void should_return_notification_with_greeting_message() {
		HelloWorldResource helloWorldRessource = new HelloWorldResource();
		Notification notification = helloWorldRessource.hello();
		Assertions.assertThat(notification.getMessage()).isEqualTo("Hello world !");
	}
	
	@Test
	public void should_return_notification_with_green_as_color() {
		HelloWorldResource helloWorldRessource = new HelloWorldResource();
		Notification notification = helloWorldRessource.hello();
		Assertions.assertThat(notification.getColor()).isEqualTo(NotificationColor.GREEN);
	}
	
	@Test
	public void should_return_notification_that_notify_users() {
		HelloWorldResource helloWorldRessource = new HelloWorldResource();
		Notification notification = helloWorldRessource.hello();
		Assertions.assertThat(notification.isNotify()).isTrue();
	}
}
