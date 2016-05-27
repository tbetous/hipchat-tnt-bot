package tntbot.helloworld;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import tntbot.core.Notification;

public class HelloWorldResourceTest {
	
	@Test
	public void should_return_notification_with_hello_as_message() {
		HelloWorldResource helloWorldRessource = new HelloWorldResource();
		Notification notification = helloWorldRessource.hello();
		assertTrue(notification.getMessage().equals("Hello world !"));
	}
	
	@Test
	public void should_return_notification_with_green_as_color() {
		HelloWorldResource helloWorldRessource = new HelloWorldResource();
		Notification notification = helloWorldRessource.hello();
		assertTrue(notification.getColor().equals("green"));
	}
	
	@Test
	public void should_return_notification_that_notify_users() {
		HelloWorldResource helloWorldRessource = new HelloWorldResource();
		Notification notification = helloWorldRessource.hello();
		assertTrue(notification.isNotify());
	}
}
