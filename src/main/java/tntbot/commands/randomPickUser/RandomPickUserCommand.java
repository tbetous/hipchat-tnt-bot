package tntbot.commands.randomPickUser;

import tntbot.commands.EventCommand;
import tntbot.core.exceptions.RandomPickUserException;
import tntbot.core.room.Room;
import tntbot.core.user.User;
import tntbot.core.webhook.event.WebhookEvent;
import tntbot.core.webhook.event.message.WebhookMessageEventContent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPickUserCommand  {

    private RandomPickUserCommandType type;
    private Room room;
    private List<User> users;
    private int pickNumber;

    public RandomPickUserCommand(RandomPickUserCommandBuilder builder) {
        this.type = builder.getType();
        this.room = builder.getRoom();
        this.users = builder.getUsers();
        this.pickNumber = builder.getPickNumber();
    }

    public RandomPickUserCommandType getType() {
        return type;
    }

    public Room getRoom() {
        return room;
    }

    public List<User> getUsers() {
        return users;
    }

    public int getPickNumber() {
        return pickNumber;
    }

    public RandomPickUserCommandResultProvider execute() throws RandomPickUserException {
        if(RandomPickUserCommandType.MENTION.equals(type)) {
            return randomPickUser();
        } else {
            return randomPickRoomUser();
        }
    }

    final protected RandomPickUserCommandResultProvider randomPickUser() throws RandomPickUserException {
        if(users == null || users.isEmpty()) {
            throw new RandomPickUserException("You didn't give any user to pick !");
        }
        if(pickNumber < 1) {
            throw new RandomPickUserException("You can't pick 0 user !");
        }

        int index = 0;
        Random rand = new Random();
        List<User> result = new ArrayList<User>();
        List<User> userList = new ArrayList<User>(users);
        for(int i = 0; i < pickNumber; i++) {
            index = rand.nextInt(userList.size());
            result.add(userList.get(index));
            userList.remove(index);
        }
        return new RandomPickUserCommandResultProviderBuilder()
                .withResult(result)
                .build();
    }

    final protected RandomPickUserCommandResultProvider randomPickRoomUser() throws RandomPickUserException {
        throw new RandomPickUserException("This function is not ready !");
    }
}
