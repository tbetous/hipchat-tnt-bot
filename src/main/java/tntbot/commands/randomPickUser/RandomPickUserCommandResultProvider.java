package tntbot.commands.randomPickUser;

import tntbot.commands.EventCommandResultProvider;
import tntbot.core.notification.Notification;
import tntbot.core.notification.NotificationBuilder;
import tntbot.core.notification.NotificationColorType;
import tntbot.core.user.User;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Thomas Betous on 26/06/2016.
 */
public class RandomPickUserCommandResultProvider extends EventCommandResultProvider<List<User>> {

    protected RandomPickUserCommandResultProvider(RandomPickUserCommandResultProviderBuilder builder) {
        this.result = builder.getResult();
    }

    @Override
    public Notification getNotification() {
        StringBuilder sb = new StringBuilder("RPU result : ");

        return new NotificationBuilder()
                .withColor(NotificationColorType.GREEN)
                .withNotify(true)
                .withMessage(createMessage(result))
                .build();
    }

    private String createMessage(List<User> users) {
        StringBuilder sb = new StringBuilder("RPU result : ");
        String result;
        if (users.size() == 0) {
            result = "No one ! Let the multi faced god will decide !";
        } else if (users.size() == 1) {
            result = users.get(0).getAnnotedMentionName();
        } else {
            int last = users.size() - 1;
            result = String.join(" and ",
                    users.subList(0, last).stream()
                            .map(user -> user.getAnnotedMentionName())
                            .collect(Collectors.joining(", ")),
                    users.get(last).getAnnotedMentionName());
        }
        return sb.append(result).toString();
    }
}
