package tntbot.commands.randomPickUser;

import com.fasterxml.jackson.annotation.JsonValue;

public enum RandomPickUserCommandType {
    ROOM("room"),
    MENTION("mention");

    private String value;

    RandomPickUserCommandType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
