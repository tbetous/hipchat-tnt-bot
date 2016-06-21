package tntbot.services;

import tntbot.commands.randomPickUser.RandomPickUserCommand;
import tntbot.commands.randomPickUser.RandomPickUserCommandBuilder;
import tntbot.commands.randomPickUser.RandomPickUserCommandType;
import tntbot.core.exceptions.RandomPickUserException;
import tntbot.core.notification.Notification;
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
    private static final String REGEX_MESSAGE = "^(.*)\\s+(" + RandomPickUserCommandType.MENTION.getValue() + "|" + RandomPickUserCommandType.ROOM.getValue() + ")\\s+(\\d+)";

    public List<User> randomPickUser(WebhookEvent<WebhookMessageEventContent> messageEvent) throws RandomPickUserException  {
        return new RandomPickUserCommandBuilder().buildFromMessageEvent(messageEvent).execute();
    }
}
