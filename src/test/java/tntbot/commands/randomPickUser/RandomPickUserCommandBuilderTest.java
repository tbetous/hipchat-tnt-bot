package tntbot.commands.randomPickUser;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
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

public class RandomPickUserCommandBuilderTest {

    private final static User USER_1 = new UserBuilder().build();
    private final static User USER_2 = new UserBuilder().build();
    private final static User USER_3 = new UserBuilder().build();
    private static final List<User> ZERO_USER = Arrays.<User>asList();
    private static final List<User> ONE_USER = Arrays.<User>asList(USER_1);
    private static final List<User> ALL_USERS = Arrays.<User>asList(USER_1,USER_2,USER_3);
    private static final String MESSAGE_WITH_NO_ARGUMENT = "/Command";
    private static final String MESSAGE_WITH_UNKNOWN_RPU_TYPE = "/Command asdas 10";
    private static final String MESSAGE_WITH_NO_PICK_NUMBER = "/Command mention";
    private static final String MESSAGE_WITH_STRING_AS_PICK_NUMBER = "/Command mention pickNumber";
    private static final String MESSAGE_OK_FOR_ROOM_RPU_TYPE = "/Command room 10";
    private static final String MESSAGE_OK_FOR_MENTION_RPU_TYPE = "/Command mention 10";
    private static final String MESSAGE_OK_WITH_UPPER_AND_LOWER_CASE = "             /Command                            mEntIon            10             ";
    private static final String MESSAGE_OK_WITH_GIANT_SPACE = "             /Command                            mention            10             ";
    private static final Room ROOM = new RoomBuilder().build();

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void should_throw_an_exception_when_command_has_no_argument() throws Exception {
        //GIVEN
        WebhookEvent<WebhookMessageEventContent> event = getWebhookEvent(MESSAGE_WITH_NO_ARGUMENT);
        expectedEx.expect(RandomPickUserException.class);
        expectedEx.expectMessage("Command is not formatted correctly !");

        //WHEN
        RandomPickUserCommand command = new RandomPickUserCommandBuilder().buildFromMessageEvent(event);

        //THEN
        // Expects exceptions
    }

    @Test
    public void should_throw_an_exception_when_command_has_an_unknown_rpu_type() throws Exception {
        //GIVEN
        WebhookEvent<WebhookMessageEventContent> event = getWebhookEvent(MESSAGE_WITH_UNKNOWN_RPU_TYPE);
        expectedEx.expect(RandomPickUserException.class);
        expectedEx.expectMessage("Command is not formatted correctly !");

        //WHEN
        RandomPickUserCommand command = new RandomPickUserCommandBuilder().buildFromMessageEvent(event);

        //THEN
        // Expects exceptions
    }

    @Test
    public void should_throw_an_exception_when_command_has_no_pick_number() throws Exception {
        //GIVEN
        WebhookEvent<WebhookMessageEventContent> event = getWebhookEvent(MESSAGE_WITH_NO_PICK_NUMBER);
        expectedEx.expect(RandomPickUserException.class);
        expectedEx.expectMessage("Command is not formatted correctly !");

        //WHEN
        RandomPickUserCommand command = new RandomPickUserCommandBuilder().buildFromMessageEvent(event);

        //THEN
        // Expects exceptions
    }

    @Test
    public void should_throw_an_exception_when_command_has_wrong_format_pick_number() throws Exception {
        //GIVEN
        WebhookEvent<WebhookMessageEventContent> event = getWebhookEvent(MESSAGE_WITH_STRING_AS_PICK_NUMBER);
        expectedEx.expect(RandomPickUserException.class);
        expectedEx.expectMessage("Command is not formatted correctly !");

        //WHEN
        RandomPickUserCommand command = new RandomPickUserCommandBuilder().buildFromMessageEvent(event);

        //THEN
        // Expects exceptions
    }

    @Test
    public void should_return_rpu_command_of_type_room_when_command_is_formatted_correctly() throws Exception {
        //GIVEN
        WebhookEvent<WebhookMessageEventContent> event = getWebhookEvent(MESSAGE_OK_FOR_ROOM_RPU_TYPE);

        //WHEN
        RandomPickUserCommand command = new RandomPickUserCommandBuilder().buildFromMessageEvent(event);

        //THEN
        Assertions.assertThat(command.getPickNumber()).isEqualTo(10);
        Assertions.assertThat(command.getRoom()).isEqualTo(ROOM);
        Assertions.assertThat(command.getUsers()).isEqualTo(ALL_USERS);
        Assertions.assertThat(command.getType()).isEqualTo(RandomPickUserCommandType.ROOM);
    }

    @Test
    public void should_return_rpu_command_of_type_mention_when_command_is_formatted_correctly() throws Exception {
        //GIVEN
        WebhookEvent<WebhookMessageEventContent> event = getWebhookEvent(MESSAGE_OK_FOR_MENTION_RPU_TYPE);

        //WHEN
        RandomPickUserCommand command = new RandomPickUserCommandBuilder().buildFromMessageEvent(event);

        //THEN
        Assertions.assertThat(command.getPickNumber()).isEqualTo(10);
        Assertions.assertThat(command.getRoom()).isEqualTo(ROOM);
        Assertions.assertThat(command.getUsers()).isEqualTo(ALL_USERS);
        Assertions.assertThat(command.getType()).isEqualTo(RandomPickUserCommandType.MENTION);
    }

    @Test
    public void should_return_rpu_command_when_command_is_formatted_correctly_with_giant_space() throws Exception {
        //GIVEN
        WebhookEvent<WebhookMessageEventContent> event = getWebhookEvent(MESSAGE_OK_WITH_GIANT_SPACE);

        //WHEN
        RandomPickUserCommand command = new RandomPickUserCommandBuilder().buildFromMessageEvent(event);

        //THEN
        Assertions.assertThat(command.getPickNumber()).isEqualTo(10);
        Assertions.assertThat(command.getRoom()).isEqualTo(ROOM);
        Assertions.assertThat(command.getUsers()).isEqualTo(ALL_USERS);
        Assertions.assertThat(command.getType()).isEqualTo(RandomPickUserCommandType.MENTION);
    }

    @Test
    public void should_return_rpu_command_when_command_is_formatted_correctly_with_upper_and_lower_case() throws Exception {
        //GIVEN
        WebhookEvent<WebhookMessageEventContent> event = getWebhookEvent(MESSAGE_OK_WITH_UPPER_AND_LOWER_CASE);

        //WHEN
        RandomPickUserCommand command = new RandomPickUserCommandBuilder().buildFromMessageEvent(event);

        //THEN
        Assertions.assertThat(command.getPickNumber()).isEqualTo(10);
        Assertions.assertThat(command.getRoom()).isEqualTo(ROOM);
        Assertions.assertThat(command.getUsers()).isEqualTo(ALL_USERS);
        Assertions.assertThat(command.getType()).isEqualTo(RandomPickUserCommandType.MENTION);
    }

    private WebhookEvent<WebhookMessageEventContent> getWebhookEvent(String message) {
        return WebhookEvent.<WebhookMessageEventContent>newInstance(
                WebhookEventType.ROOM_MESSAGE,
                "blah",
                10L,
                new WebhookMessageEventContentBuilder()
                        .withRoom(ROOM)
                        .withUserMessage(getUserMessage(message))
                        .build()
        );
    }
    private UserMessage getUserMessage(String message) {
        return new UserMessageBuilder()
                .withMessage(message)
                .withMentions(ALL_USERS)
                .build();
    }

}