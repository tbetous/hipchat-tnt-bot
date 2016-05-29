package tntbot.core;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Thomas Betous on 29/05/2016.
 */
public class NotificationBuilderTest {

    @Test
    public void should_return_notification_with_default_message_when_not_specified() {
        Notification notification = new NotificationBuilder().build();

        assertTrue(notification.getMessage().equals(""));
    }

    @Test
    public void should_return_notification_with_default_color_when_not_specified() {
        Notification notification = new NotificationBuilder().build();

        assertTrue(notification.getColor().equals(NotificationColor.RANDOM));
    }

    @Test
    public void should_return_notification_with_default_notify_value_when_not_specified() {
        Notification notification = new NotificationBuilder().build();

        assertTrue(!notification.isNotify());
    }

}