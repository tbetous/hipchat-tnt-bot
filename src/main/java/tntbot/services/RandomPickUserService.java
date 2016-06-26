package tntbot.services;

import tntbot.commands.randomPickUser.RandomPickUserCommand;
import tntbot.commands.randomPickUser.RandomPickUserCommandBuilder;
import tntbot.commands.randomPickUser.RandomPickUserCommandType;
import tntbot.core.exceptions.RandomPickUserException;
import tntbot.core.notification.Notification;
import tntbot.core.notification.NotificationBuilder;
import tntbot.core.notification.NotificationColorType;
import tntbot.core.room.Room;
import tntbot.core.user.User;
import tntbot.core.webhook.event.WebhookEvent;
import tntbot.core.webhook.event.message.WebhookMessageEventContent;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Singleton
public class RandomPickUserService {
    public Notification randomPickUser(WebhookEvent<WebhookMessageEventContent> messageEvent) {
        try {
            return new RandomPickUserCommandBuilder().buildFromMessageEvent(messageEvent).execute().getNotification();
        } catch (RandomPickUserException rpue) {
            return new NotificationBuilder()
                    .withColor(NotificationColorType.RED)
                    .withNotify(false)
                    .withMessage(rpue.getMessage())
                    .build();
        }
    }
}
