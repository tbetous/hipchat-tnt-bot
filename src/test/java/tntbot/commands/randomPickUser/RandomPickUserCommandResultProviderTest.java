package tntbot.commands.randomPickUser;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import tntbot.core.notification.Notification;
import tntbot.core.notification.NotificationColorType;
import tntbot.core.user.User;
import tntbot.core.user.UserBuilder;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Thomas Betous on 26/06/2016.
 */
public class RandomPickUserCommandResultProviderTest {

    private final static User USER_1 = new UserBuilder().withMentionName("Thomas").build();
    private final static User USER_2 = new UserBuilder().withMentionName("Yussef").build();
    private final static User USER_3 = new UserBuilder().withMentionName("Rick").build();
    private static final List<User> ZERO_USER = Arrays.<User>asList();
    private static final List<User> ONE_USER = Arrays.<User>asList(USER_1);
    private static final List<User> TWO_USER = Arrays.<User>asList(USER_1, USER_2);
    private static final List<User> ALL_USERS = Arrays.<User>asList(USER_1,USER_2,USER_3);

    @Test
    public void should_return_a_notification_well_formated_with_no_one() {
        RandomPickUserCommandResultProvider resultProvider = new RandomPickUserCommandResultProviderBuilder()
                .withResult(ZERO_USER)
                .build();

        Notification notification = resultProvider.getNotification();

        Assertions.assertThat(resultProvider.getNotification().getColor()).isEqualTo(NotificationColorType.GREEN);
        Assertions.assertThat(resultProvider.getNotification().isNotify()).isEqualTo(true);
        Assertions.assertThat(resultProvider.getNotification().getMessage()).isEqualTo("RPU result : No one ! Let the multi faced god will decide !");
    }

    @Test
    public void should_return_a_notification_well_formated_with_one_user() {
        RandomPickUserCommandResultProvider resultProvider = new RandomPickUserCommandResultProviderBuilder()
                .withResult(ONE_USER)
                .build();

        Notification notification = resultProvider.getNotification();

        Assertions.assertThat(resultProvider.getNotification().getColor()).isEqualTo(NotificationColorType.GREEN);
        Assertions.assertThat(resultProvider.getNotification().isNotify()).isEqualTo(true);
        Assertions.assertThat(resultProvider.getNotification().getMessage()).isEqualTo("RPU result : @Thomas");
    }

    @Test
    public void should_return_a_notification_well_formated_with_two_user() {
        RandomPickUserCommandResultProvider resultProvider = new RandomPickUserCommandResultProviderBuilder()
                .withResult(TWO_USER)
                .build();

        Notification notification = resultProvider.getNotification();

        Assertions.assertThat(resultProvider.getNotification().getColor()).isEqualTo(NotificationColorType.GREEN);
        Assertions.assertThat(resultProvider.getNotification().isNotify()).isEqualTo(true);
        Assertions.assertThat(resultProvider.getNotification().getMessage()).isEqualTo("RPU result : @Thomas and @Yussef");
    }

    @Test
    public void should_return_a_notification_well_formated_with_three_user() {
        RandomPickUserCommandResultProvider resultProvider = new RandomPickUserCommandResultProviderBuilder()
                .withResult(ALL_USERS)
                .build();

        Notification notification = resultProvider.getNotification();

        Assertions.assertThat(resultProvider.getNotification().getColor()).isEqualTo(NotificationColorType.GREEN);
        Assertions.assertThat(resultProvider.getNotification().isNotify()).isEqualTo(true);
        Assertions.assertThat(resultProvider.getNotification().getMessage()).isEqualTo("RPU result : @Thomas, @Yussef and @Rick");
    }
}