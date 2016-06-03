package tntbot.core;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Created by Thomas Betous on 29/05/2016.
 */
public class NotificationBuilderTest {

    @Test
    public void should_return_notification_with_default_message_when_not_specified() {
        Notification notification = new NotificationBuilder().build();
        	
        Assertions.assertThat(notification.getMessage()).isEqualTo("");
    }

    @Test
    public void should_return_notification_with_default_color_when_not_specified() {
        Notification notification = new NotificationBuilder().build();
        
        Assertions.assertThat(notification.getColor()).isEqualTo(NotificationColor.RANDOM);
    }

    @Test
    public void should_return_notification_with_default_notify_value_when_not_specified() {
        Notification notification = new NotificationBuilder().build();

        Assertions.assertThat(notification.isNotify()).isFalse();
    }

}