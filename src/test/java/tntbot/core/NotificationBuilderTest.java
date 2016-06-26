package tntbot.core;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import tntbot.core.message.MessageFormatType;
import tntbot.core.notification.Notification;
import tntbot.core.notification.NotificationBuilder;
import tntbot.core.notification.NotificationColorType;

public class NotificationBuilderTest {

    @Test
    public void should_return_notification_with_default_message_when_not_specified() {
        Notification notification = new NotificationBuilder().build();
        	
        Assertions.assertThat(notification.getMessage()).isEqualTo("");
    }

    @Test
    public void should_return_notification_with_default_color_when_not_specified() {
        Notification notification = new NotificationBuilder().build();
        
        Assertions.assertThat(notification.getColor()).isEqualTo(NotificationColorType.RANDOM);
    }

    @Test
    public void should_return_notification_with_default_notify_value_when_not_specified() {
        Notification notification = new NotificationBuilder().build();

        Assertions.assertThat(notification.isNotify()).isFalse();
    }

    @Test
    public void should_return_notification_with_default_message_format_value_when_not_specified() {
        Notification notification = new NotificationBuilder().build();

        Assertions.assertThat(notification.getMessageType()).isEqualTo(MessageFormatType.TEXT);
    }

}