package tntbot.commands.randomPickUser;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import tntbot.core.exceptions.RandomPickUserException;
import tntbot.core.room.Room;
import tntbot.core.room.RoomBuilder;
import tntbot.core.user.User;
import tntbot.core.user.UserBuilder;
import tntbot.services.RandomPickUserService;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

import static org.junit.Assert.*;

public class RandomPickUserCommandTest {

    private final static User USER_1 = new UserBuilder().build();
    private final static User USER_2 = new UserBuilder().build();
    private final static User USER_3 = new UserBuilder().build();
    private static final List<User> ZERO_USER = Arrays.<User>asList();
    private static final List<User> ONE_USER = Arrays.<User>asList(USER_1);
    private static final List<User> ALL_USERS = Arrays.<User>asList(USER_1,USER_2,USER_3);
    private static final Room ROOM = new RoomBuilder().build();


    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void should_throw_an_exception_when_users_are_picked_from_a_room() throws Exception {
        //GIVEN
        RandomPickUserCommand command = new RandomPickUserCommandBuilder()
                .withRoom(ROOM)
                .withType(RandomPickUserCommandType.ROOM)
                .withPickNumber(123)
                .withUsers(ALL_USERS)
                .build();
        expectedEx.expect(RandomPickUserException.class);
        expectedEx.expectMessage("This function is not ready !");

        // WHEN
        List<User> users = command.randomPickRoomUser().getResult();

        // THEN
        // Expects exceptions
    }

    @Test
    public void should_throw_an_exception_when_number_of_pick_is_zero_and_user_are_picked_from_list() throws Exception {
        //GIVEN
        RandomPickUserCommand command = new RandomPickUserCommandBuilder()
                .withRoom(ROOM)
                .withType(RandomPickUserCommandType.MENTION)
                .withPickNumber(0)
                .withUsers(ALL_USERS)
                .build();
        expectedEx.expect(RandomPickUserException.class);
        expectedEx.expectMessage("You can't pick 0 user !");

        // WHEN
        List<User> users = command.randomPickUser().getResult();

        // THEN
        // Expects exceptions
    }

    @Test
    public void should_throw_an_exception_when_there_is_no_user_to_pick_in_the_list() throws Exception{
        //GIVEN
        RandomPickUserCommand command = new RandomPickUserCommandBuilder()
                .withRoom(ROOM)
                .withType(RandomPickUserCommandType.MENTION)
                .withPickNumber(0)
                .withUsers(ZERO_USER)
                .build();
        expectedEx.expect(RandomPickUserException.class);
        expectedEx.expectMessage("You didn't give any user to pick !");

        // WHEN
        List<User> users = command.randomPickUser().getResult();

        // THEN
        // Expects exceptions
    }

    @Test
    public void should_throw_an_exception_when_pick_number_is_more_than_user_number() throws Exception{
        //GIVEN
        RandomPickUserCommand command = new RandomPickUserCommandBuilder()
                .withRoom(ROOM)
                .withType(RandomPickUserCommandType.MENTION)
                .withPickNumber(100000)
                .withUsers(ALL_USERS)
                .build();
        expectedEx.expect(RandomPickUserException.class);
        expectedEx.expectMessage("Please, be realistic. You can't pick the entire world !");

        // WHEN
        List<User> users = command.randomPickUser().getResult();

        // THEN
        // Expects exceptions
    }

    @Test
    public void should_return_one_user_when_number_of_pick_is_one_and_user_number_in_the_list_is_more_than_one() throws Exception {
        //GIVEN
        RandomPickUserCommand command = new RandomPickUserCommandBuilder()
                .withRoom(ROOM)
                .withType(RandomPickUserCommandType.MENTION)
                .withPickNumber(1)
                .withUsers(ONE_USER)
                .build();
        Room room = new RoomBuilder().build();

        // WHEN
        List<User> users = command.randomPickUser().getResult();

        // THEN
        Assertions.assertThat(users).hasSize(1);
    }

    @Test
    public void should_return_three_different_user_when_number_of_pick_is_three_and_three_users_in_the_list() throws Exception {
        //GIVEN
        RandomPickUserCommand command = new RandomPickUserCommandBuilder()
                .withRoom(ROOM)
                .withType(RandomPickUserCommandType.MENTION)
                .withPickNumber(3)
                .withUsers(ALL_USERS)
                .build();
        Room room = new RoomBuilder().build();

        // WHEN
        List<User> users = command.randomPickUser().getResult();

        // THEN
        Assertions.assertThat(users).hasSize(3);
        Assertions.assertThat(users).containsAll(ALL_USERS);
    }

    @Test
    public void should_execute_random_pick_user_from_list() throws Exception {
        //GIVEN
        RandomPickUserCommand command = Mockito.spy(new RandomPickUserCommandBuilder()
                .withRoom(ROOM)
                .withType(RandomPickUserCommandType.MENTION)
                .withPickNumber(1)
                .withUsers(ALL_USERS)
                .build());
        Mockito.doReturn(ONE_USER).when(command).randomPickUser();

        command.execute();

        Mockito.verify(command).randomPickUser().getResult();
    }

    @Test
    public void should_execute_random_pick_user_from_room() throws Exception {
        //GIVEN
        RandomPickUserCommand command = Mockito.spy(new RandomPickUserCommandBuilder()
                .withRoom(ROOM)
                .withType(RandomPickUserCommandType.ROOM)
                .withPickNumber(1)
                .withUsers(ALL_USERS)
                .build());
        Mockito.doReturn(ONE_USER).when(command).randomPickRoomUser();

        command.execute();

        Mockito.verify(command).randomPickRoomUser().getResult();
    }

}