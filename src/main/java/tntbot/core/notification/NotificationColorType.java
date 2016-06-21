package tntbot.core.notification;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Background color for message.
 */
public enum NotificationColorType {
    YELLOW("yellow"),
    GREEN("green"),
    RED("red"),
    PURPLE("purple"),
    GRAY("gray"),
    RANDOM("random");

    private String value;

    NotificationColorType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
