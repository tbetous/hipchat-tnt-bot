package tntbot.services;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import tntbot.commands.randomPickUser.RandomPickUserCommand;
import tntbot.commands.randomPickUser.RandomPickUserCommandType;
import tntbot.core.exceptions.RandomPickUserException;
import tntbot.core.room.Room;
import tntbot.core.room.RoomBuilder;
import tntbot.core.user.User;
import tntbot.core.user.UserBuilder;
import tntbot.core.webhook.UserMessage;
import tntbot.core.webhook.UserMessageBuilder;
import tntbot.core.webhook.event.WebhookEvent;
import tntbot.core.webhook.event.WebhookEventType;
import tntbot.core.webhook.event.message.WebhookMessageEventContent;
import tntbot.core.webhook.event.message.WebhookMessageEventContentBuilder;

import java.util.Arrays;
import java.util.List;


public class RandomPickUserServiceTest {

    RandomPickUserService randomPickUserService;

    @Before
    public void before() {
        randomPickUserService = new RandomPickUserService();
    }

}