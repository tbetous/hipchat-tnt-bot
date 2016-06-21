package tntbot.commands.randomPickUser;

import tntbot.core.exceptions.RandomPickUserException;
import tntbot.core.room.Room;
import tntbot.core.user.User;
import tntbot.core.webhook.event.WebhookEvent;
import tntbot.core.webhook.event.message.WebhookMessageEventContent;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RandomPickUserCommandBuilder {
    private static final String REGEX_MESSAGE = "^(.*)\\s+(" + RandomPickUserCommandType.MENTION.getValue() + "|" + RandomPickUserCommandType.ROOM.getValue() + ")\\s+(\\d+)";

    private RandomPickUserCommandType type;
    private Room room;
    private List<User> users;
    private int pickNumber;

    public RandomPickUserCommandType getType() {
        return type;
    }

    public RandomPickUserCommandBuilder withType(RandomPickUserCommandType type) {
        this.type = type;
        return this;
    }

    public Room getRoom() {
        return room;
    }

    public RandomPickUserCommandBuilder withRoom(Room room) {
        this.room = room;
        return this;
    }

    public List<User> getUsers() {
        return users;
    }

    public RandomPickUserCommandBuilder withUsers(List<User> users) {
        this.users = users;
        return this;
    }

    public int getPickNumber() {
        return pickNumber;
    }

    public RandomPickUserCommandBuilder withPickNumber(int pickNumber) {
        this.pickNumber = pickNumber;
        return this;
    }

    public RandomPickUserCommand build() {
        return new RandomPickUserCommand(this);
    }

    public RandomPickUserCommand buildFromMessageEvent(WebhookEvent<WebhookMessageEventContent> messageEvent) throws RandomPickUserException {
        Pattern p = Pattern.compile(REGEX_MESSAGE);
        Matcher m = p.matcher(messageEvent.getContent().getUserMessage().getMessage().trim().toLowerCase());
        if(m.find()){
            MatchResult mr = m.toMatchResult();
            RandomPickUserCommand command =  new RandomPickUserCommandBuilder()
                    .withPickNumber(Integer.parseInt(mr.group(3)))
                    .withType(mr.group(2).equalsIgnoreCase(RandomPickUserCommandType.ROOM.getValue()) ? RandomPickUserCommandType.ROOM : RandomPickUserCommandType.MENTION)
                    .withUsers(messageEvent.getContent().getUserMessage().getMentions())
                    .withRoom(messageEvent.getContent().getRoom())
                    .build();
            return command;
        } else {
            throw new RandomPickUserException("Command is not formatted correctly !");
        }
    }
}
