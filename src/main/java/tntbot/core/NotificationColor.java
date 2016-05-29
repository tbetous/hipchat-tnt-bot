package tntbot.core;

/**
 * Background color for message.
 */
public enum NotificationColor {
    YELLOW("yellow"),
    GREEN("green"),
    RED("red"),
    PURPLE("purple"),
    GRAY("gray"),
    RANDOM("random");

    private String value;

    NotificationColor(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
