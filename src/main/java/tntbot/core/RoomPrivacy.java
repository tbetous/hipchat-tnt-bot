package tntbot.core;

public enum RoomPrivacy {
    PUBLIC("public"),
    PRIVATE("private");

    private String value;

    RoomPrivacy(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
